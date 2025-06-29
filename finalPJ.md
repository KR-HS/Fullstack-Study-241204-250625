## 🎥 실시간 방송(WebRTC)을 활용한 온라인 경매 플랫폼
**BIDCAST**는 누구나 경매를 개설하고 입찰에 참여할 수 있는 실시간 영상 기반 경매 시스템입니다.  
실시간 채팅, 영상 공유, 입찰 기능을 통해 생동감 있는 경매 경험을 제공합니다.

🔗 [BIDCAST 서버 GitHub](https://github.com/KR-HS/BidCast_Server)
🔗 [BIDCAST 클라이언트 GitHub](https://github.com/KR-HS/BidCast) 
🔗 [AWS세팅하기](AWS세팅.md) 
🌐 [BIDCAST 홈페이지](https://bidcast.kro.kr)

---

### 🔧 주요 기능
- **경매 탐색**: 경매 일정과 검색 기능을 통해 원하는 경매를 손쉽게 찾을 수 있습니다.
- **관심 경매 등록**: 마이페이지에서 관심 경매로 바로 이동할 수 있습니다.
- **경매 개설**: 누구나 경매사가 되어 경매를 개설할 수 있습니다.
- **경매 진행 기능**:
  - 경매사는 실시간 방송을 통해 입찰을 진행하고, 물품을 낙찰/유찰 처리할 수 있습니다.
  - 경매 단위 조정 및 입찰 종료 기능을 제공합니다.
- **입찰자 기능**:
  - 실시간 입찰, 낙찰/유찰 결과를 모달 및 영상을 통해 확인할 수 있습니다. 
  - 실시간 채팅기능을 구현하였습니다. (최근 40개 메시지 유지)
- **마이페이지**:
  - 경매 이력, 낙찰 내역, 등록 상품 상태 등을 확인할 수 있습니다.

---
### 📦 프로젝트 구성 및 배포
- **Vite 기반 멀티 페이지 구성**
- **EC2 배포**, **Nginx + certbot으로 HTTPS** 설정
- **Jenkins**를 통한 **CI/CD 구축**
- **AWS S3**를 통한 파일 저장
- **PostgreSQL (RDS)** 기반 데이터베이스 사용
- **JWT**를 통한 인증 및 **비밀번호 암호화** 적용
> ⚠️ **주의**: `application-custom.properties` 파일은 Git에 포함되지 않습니다.
> *직접 `src/main/resources` 경로에 아래 내용을 포함한 파일을 추가해주세요:*

<details>
<summary><code>application-custom.properties</code> 예시 보기</summary>

```bash
properties
spring.datasource.url=jdbc:postgresql://<DB주소>:5432/bidcast
spring.datasource.username=<DB유저>
spring.datasource.password=<DB비밀번호>

jwt.secret=<JWT 비밀 키>
jwt.expiration=3600000

aws.s3.access-key=<AccessKey>
aws.s3.secret-key=<SecretKey>
aws.s3.region=ap-northeast-2
aws.s3.bucket=<버킷명>
aws.s3.folder=uploads
```
</details> 

---

### 🛠 사용 기술 스택

> ### 1. Server
> #### 1-1. App Server (유저 서비스)
> - **Build Tools**: `Vite`, `Gradle`
> - **Front-End**: `React`, `HTML`, `CSS`, `Thymeleaf`
> - **Back-End**: `Spring Boot`, `WebRTC`, `WebSocket`
> - **Persistence**: `MyBatis`
> - **Authorization**: `JWT`, `Spring Security`
>
> #### 1-2. SFU Server (중계 서버)
> - `Node.js`, `WebRTC`, `mediasoup`, `WebSocket`
>
> #### 1-3. Database
> - `Amazon RDS`, `PostgreSQL`
>
> #### 1-4. Cloud Storage
> - `Amazon S3`

> ### 2. Infrastructure
> - `Nginx`, `certbot`, `Let's Encrypt`

> ### 3. Dev Tools
> - `IntelliJ IDEA`, `Figma`

> ### 4. Collaboration
> - `Git`, `GitHub`

> ### 5. CI/CD
> - `Jenkins`


---

# 서버 코드분석

# 1.WebSocket
<details>
<summary>접기/펼치기</summary>

### 종류

- **`socket`**  
  **클라이언트 하나하나의 연결**을 나타내는 객체
  해당 클라이언트와 **1:1 통신**하거나 이벤트를 처리할 때 사용

- **`io`**  
  **전체 소켓 서버 객체**로, **모든 클라이언트에 메시지를 보내거나 특정 방(room)에 메시지를 전달**할 때 사용
  예: `io.to(roomId).emit('event',data)`

- **`broadcast`**  
  **자신을 제외한 같은 방 또는 전체 클라이언트에게 메시지 전송**
  예: `socket.broadcast.emit()` — 자기 자신을 제외한 모두에게 전송

### 방식

- **`on`**  
  클라이언트로부터 **이벤트가 왔을 때** 실행할 콜백을 등록  
  예: `socket.on('produce', callback)`

- **`emit`**  
  **이벤트와 데이터를 보내는 방식**  
  서버 ↔ 클라이언트 양방향으로 사용
  예: `socket.emit('new-producer', data)`

---

## WebRTC & mediasoup

### WebRTC

- **실시간 음성, 영상, 데이터 통신을 위한 표준 기술**
- 브라우저 또는 네이티브 앱 간 **P2P 연결을 지원**
- 직접 연결이 어려운 경우 **SFU 방식** 사용 (Selective Forwarding Unit)

#### ICE, STUN, TURN

| 용어   | 설명 |
|--------|------|
| **ICE**  | 연결 가능한 후보 주소들을 수집해 최적 경로를 선택하는 프레임워크 |
| **STUN** | 공인 IP 및 포트 정보를 알아내기 위한 서버 |
| **TURN** | P2P 연결이 불가한 경우 미디어를 **중계**해주는 서버 (대역폭 소모 ↑) |

### mediasoup

- **WebRTC SFU 서버 구현 라이브러리** 
- 미디어 흐름 제어를 위한 객체 기반 구조

### mediasoup 주요 개념

| 용어       | 설명 |
|------------|-----|
| **Worker**     | 미디어 처리를 담당하는 **백그라운드 프로세스** |
| **Router**     | 한 방(room)에 하나씩 존재, **미디어 경로 제어** 역할 |
| **Transport**  | **클라이언트와 서버 간 미디어 연결 통로** (DTLS/ICE 등 포함) |
| **Producer**   | 클라이언트가 **미디어를 송출할 때** 생성되는 객체 |
| **Consumer**   | 클라이언트가 **미디어를 수신할 때** 생성되는 객체 |

<details>
<summary>상세 설명</summary>

- **Worker** : 미디어 처리를 담당하는 **엔진** 같은 프로세스, 실제 미디어 데이터(음성, 영상)를 다룸 
- **Router** : producer가 보내는 미디어 스트림을 받아서 어떤 consumer에게 보낼지 정함. 하나의 방에는 하나의 Router가 있음
- **Transport** : ICE 연결, DTLS 핸드셰이크 등을 포함한 통신 경로, consumer/producer 각각 쓰는 tranport가 다름
</details>


## rtpCapabilities

- **WebRTC 연결 시 사용할 수 있는 미디어 형식 (코덱, 해상도 등) 목록**
- 송신자와 수신자의 **미디어 호환 여부를 판단**하기 위해 필수
- 예시:
  ```
  {
    "codecs": [
      { "kind": "audio", "mimeType": "audio/opus", ... },
      { "kind": "video", "mimeType": "video/VP8", ... }
    ]
  }
  ```

## DTLS
- **UDP 기반** 통신에서 **보안 연결을 위한 SSL/TLS 계층**
- WebRTC에서 **미디어 데이터 암호화 및 인증** 역할 수행

---

## 서버 미디어 처리 흐름
<details>
<summary>접기/펼치기</summary>

### 1) rtpCapabilities 요청

```
socket.on('create-router', (_, callback) => {
  callback({ rtpCapabilities: router.rtpCapabilities });
});
```

### 2) Transport 생성
<details>
<summary>create-transport 코드 보기</summary>

```bash
socket.on('create-transport', async ({ direction }, callback) => {
  const transport = await router.createWebRtcTransport({
    listenIps: [{ ip: '0.0.0.0', announcedIp: 'bidcastserver.kro.kr' }],
    enableUdp: true,
    enableTcp: true,
    preferUdp: true,
    portRange: { min: 40000, max: 40010 },
    iceServers: [
      { urls: 'stun:stun.l.google.com:19302' },
      { urls: 'turn:bidcastserver.kro.kr:3478', username: 'webrtc', credential: '1234' }
    ],
  });
  transports.set(transport.id, { transport, socketId: socket.id, direction });

  callback({
    id: transport.id,
    iceParameters: transport.iceParameters,
    iceCandidates: transport.iceCandidates,
    dtlsParameters: transport.dtlsParameters,
  });
});
```
</details>

### 3) Transport 연결 (DTLS 핸드쉐이크)
```
socket.on('connect-transport', async ({ dtlsParameters, transportId }, callback) => {
  const data = transports.get(transportId);
  if (!data) throw new Error('Transport not found');
  await data.transport.connect({ dtlsParameters });
  callback();
});
```

### 4) Producer 생성 (미디어 송출 시작)
<details> 
<summary>produce 요청 처리</summary>

```
socket.on('produce', async ({ kind, rtpParameters, transportId, roomId }, callback) => {
  const data = transports.get(transportId);
  if (!data) throw new Error('Transport not found');
  const producer = await data.transport.produce({ kind, rtpParameters });

  if (!producers.has(roomId)) producers.set(roomId, new Map());
  producers.get(roomId).set(producer.id, { producer, socketId: socket.id, kind });

  socket.broadcast.to(roomId).emit('new-producer', {
    producerId: producer.id,
    socketId: socket.id,
    kind,
  });

  callback({ id: producer.id });
});
```
</details>

### 5) Consumer 생성 (미디어 수신 요청)
<details> <summary>consume 요청 처리</summary>

```
socket.on('consume', async ({ producerId, rtpCapabilities, transportId, roomId }, callback) => {
  const data = transports.get(transportId);
  if (!data) throw new Error('Transport not found');

  const roomProducers = producers.get(roomId);
  if (!roomProducers || !roomProducers.has(producerId)) throw new Error('Producer not found');

  if (!router.canConsume({ producerId, rtpCapabilities })) throw new Error('Cannot consume');

  const consumer = await data.transport.consume({
    producerId,
    rtpCapabilities,
    paused: false,
  });

  consumers.set(consumer.id, { consumer, socketId: socket.id });

  callback({
    id: consumer.id,
    producerId,
    kind: consumer.kind,
    rtpParameters: consumer.rtpParameters,
  });
});
```
</details>

### 6) Consumer 재생 시작
```
socket.on('consumer-resume', async ({ consumerId }) => {
  const data = consumers.get(consumerId);
  if (!data) return;
  await data.consumer.resume();
});
```

### 7) 연결 종료 시 자원 정리
<details> <summary>disconnect 처리 전체 코드</summary>

```bash
socket.on('disconnect', () => {
  for (const [transportId, data] of transports) {
    if (data.socketId === socket.id) {
      data.transport.close();
      transports.delete(transportId);
    }
  }
  for (const [roomId, roomProducers] of producers) {
    for (const [producerId, data] of roomProducers) {
      if (data.socketId === socket.id) {
        data.producer.close();
        roomProducers.delete(producerId);
        io.emit('user-disconnected', {
          socketId: socket.id,
          producerId,
        });
      }
    }
    if (roomProducers.size === 0) producers.delete(roomId);
  }
  for (const [consumerId, data] of consumers) {
    if (data.socketId === socket.id) {
      data.consumer.close();
      consumers.delete(consumerId);
    }
  }
});
```
</details>

</details>

</details>

---

# 2. 서버 주요 전역 변수 및 함수 정리

<details>
<summary>접기/펼치기</summary>

---

## 1. mediasoup 관련 변수

- `transports` (Map)  
  transportId를 key로, `{ transport, socketId, direction }` 객체를 value로 저장  
  - mediasoup WebRTC 연결용 Transport 객체 관리용

- `producers` (Map)  
  roomId를 key로, value는 또 다른 Map  
  내부 Map: producerId를 key로 `{ producer, socketId, kind }`  
  - 각 방(room)별 미디어 송출자(Producer) 객체 저장

- `consumers` (Map)  
  consumerId를 key로, `{ consumer, socketId }` 저장  
  - 미디어 수신자(Consumer) 객체 관리


## 2. 소켓 & 방 관리 변수

- `socketRoomMap` (Map)  
  socketId를 key로, 현재 사용자가 입장한 roomId 저장  
  - 한 사용자가 여러 방에 동시에 접속하지 못하도록 제한하는 역할

- `socketIdMap` (Map)  
  loginId를 key로, 소켓 ID 저장  
  - 로그인 유저와 소켓 연결 관리

- `auctionHostMap` (Map)  
  auctionId를 key로, 해당 경매의 호스트 소켓 ID 저장  
  - 경매별 호스트 소켓 관리

- `auctionStates` (객체)  
  auctionId를 key로, 경매 진행 상태(선택된 상품 등) 저장  
  - 경매 상태 및 진행 정보 관리

- `auctionUserStatus` (객체)  
  socketId를 key로, 입찰자 닉네임, 마지막 입찰가 등 상태 저장  
  - 입찰자 개인별 현재 상태 정보를 저장


## 3. 상품 데이터 정규화 함수

```
function normalizeProduct(raw) {
  return {
    prodKey: raw.prod_key,
    aucKey: raw.auc_key,
    prodName: raw.prod_name,
    prodDetail: raw.prod_detail,
    unitValue: raw.unit_value,
    initPrice: raw.init_price,
    currentPrice: raw.current_price,
    finalPrice: raw.final_price,
    winnerId: raw.winner_id,
    prodStatus: raw.prod_status,
    fileUrl: raw.file_url
  };
}
```
</details>

---
# 3. 클라이언트-서버 통신 흐름

<details>
<summary>접기/펼치기</summary>

## 1. 경매장 입장/퇴장

### 입장
- 요청: `join-room(roomId, userInfo)`
- 사용 변수:
  - `socketRoomMap[socket.id] = roomId`
  - `socketIdMap[userInfo.loginId] = socket.id`
  - `auctionUserStatus[socket.id] = { nickname, lastBid: 0 }`
- 응답:
  - 입장자 목록 반환
  - 기존 유저에게 `user-status-update` 브로드캐스트

### 퇴장
- 발생: 소켓 종료 시 자동
- 처리:
  - `transports`, `producers`, `consumers`에서 socket 자원 제거
  - `socketRoomMap`, `socketIdMap`, `auctionUserStatus`에서 제거
- 브로드캐스트: `user-disconnected`


## 2. 영상 송출 (mediasoup)

### 미디어 스트림 수신 발송
- 요청: `produce(kind, rtpParameters, transportId, roomId)`
- 사용 변수:
  - `transports[transportId]` 확인
  - `producers[roomId][producerId] = { producer, socketId, kind }`
- 응답: `producerId`
- 브로드캐스트: `new-producer`

### 기존 Producer 리스트 요청
- 요청: `get-existing-producers(roomId)`
- 사용 변수:
  - `producers` Map(roomId → Map(producerId → { producer, socketId, kind }))  
  - `auctionHostMap` (roomId → hostSocketId)
- 응답: 콜백으로 `{ existingProducers, hostSocketId }` 반환

### Producer 삭제
- 요청: `close-producer(roomId)`
- 사용 변수:
  - `producers` Map에서 socket.id에 해당하는 Producer 객체 제거 및 close 호출
- 브로드캐스트:
  - 해당 경매방에 `user-disconnected` 이벤트 (해당 socketId, producerId) 전송
- 추가:
  - 방 내 Producer가 없으면 `producers` Map에서 해당 roomId 삭제

### 미디어 스트림 수신 요청
- 요청: `consume(producerId, rtpCapabilities, transportId, roomId)`
- 사용 변수:
  - `transports[transportId]` 확인
  - `consumers[consumerId] = { consumer, socketId }`
- 응답: `{ consumerId, producerId, kind, rtpParameters }`

### 재생시작
- 요청: `consumer-resume(consumerId)`
- 처리: `consumers[consumerId].consumer.resume()`


## 3. 채팅

### 채팅
- 요청: `chat-message(roomId, userId, message)`
- 사용 변수:
  - `socketRoomMap[socket.id]` → roomId 추출
- 브로드캐스트: `chat-message`


## 4. 입찰

### 입찰시도
- 요청: `bid-attempt(roomId, productId, bidAmount,userLoginId)`
- 사용 변수:
  - `auctionStates[auctionId]` → 선택된 상품 상태 갱신  
  - `auctionUserStatus[auctionId][socket.id]` → 입찰자별 입찰 기록 저장  
  - `pool.query()` → 사용자 정보 조회, 상품 가격 갱신, 입찰 기록 저장
- 브로드캐스트:
  - `user-status-update` → 입찰자 상태 갱신 전체 전송  
  - `bid-update` → 입찰 결과(상품, 입찰자 정보 포함) 전송  
  - `bid-rejected` → 입찰 실패 시 개별 응답


## 5. 경매 관리 (호스트)

### 상품 선택
- 요청: `host-selected-product(auctionId, product)`
- 사용 변수:
  - `auctionStates[auctionId].selectedProduct = product`
  - DB `product.prod_status = 'P'` 업데이트
- 브로드캐스트:
  - 해당 경매방에 `host-selected-product` (선택된 상품 정보) 전송

### 낙찰 / 유찰 상태 변경
- 요청: `bid-status(auctionId, prodKey, winner_id, status)`
- 사용 변수:
  - DB `product.prod_status` 업데이트 (`'C'` or `'F'`)
  - `auctionUserStatus[auctionId]`에서 해당 상품 입찰 기록 삭제
- 브로드캐스트:
  - 해당 방에 `bid-status` (상품 상태, 낙찰자 정보) 전송 (호스트 제외)
  - 이후 `user-status-update` (전체 유저 상태 갱신)

### 최고 입찰자 되돌리기
- 요청: `revert-bidder(auctionId, prodKey, winnerId, finalPrice)`
- 사용 변수:
  - DB `product.final_price`, `winner_id` 업데이트
  - `auctionStates[auctionId].selectedProduct` 업데이트
  - DB에서 낙찰자 닉네임 조회
- 브로드캐스트:
  - 해당 방에 `bid-update` (업데이트된 상품·낙찰자 정보) 전송

### 입찰 단위 변경
- 요청: `change-bid-unit(roomId, newUnit)`
- 사용 변수:
  - `auctionStates[roomId].selectedProduct.unitValue = newUnit`
- 브로드캐스트: `bid-unit-changed`

### 경매 종료
- 요청: `auction-end(auctionId)`
- 사용 변수:
  - DB `auction` 테이블 status='종료', end_time=NOW()로 업데이트
- 브로드캐스트: `auction-ended`


## 6. 기타

### 시청자 수 조회
- 요청: `get-guest-counts(auctionIds[])`
- 사용 변수:
  - `io.sockets.adapter.rooms` (각 경매방(room) 인원 수 조회)
- 응답:
  - 콜백 함수로 `{ auctionId: 인원수 }` 객체 반환

</details>