//모듈 임포트
/*
 모듈은 JS에서 미리 작성해 놓은 스크립트 파일

 export방식은 2가지 있습니다.
 - 여러값을 내보낼때 named export방식
 - 단 하나의 값을 내보낼때 사용하는 default export방식
*/

export const name = "홍길동"
export const age = 20;
export const some = () => {
    console.log("hello");
}

const addr = "서울시";
const any = () => {
    console.log("any");
}

//마지막에 내보내고 싶은 값을 지정가능 {}사용
export {addr, any}; 



