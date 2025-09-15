# DP

## 1. LIS (Longest Increasing Subsequence , 최장 증가 부분 수열)
 + 주어진 수열에서 **부분 수열 중에서 증가하는 수열의 길이가 가장 긴 것**을 찾는 문제
    > ```text
    > 수열: 10, 20, 10, 30, 20, 50
    > LIS: 10, 20, 30, 50  (길이 4)
    > ```
 
 + 특징
    > + 1차원 DP
    > + 순서 유지 필수, 연속X

 + 변형
    > + 최장 감소 수열(LDS)
    > + 바이토닉 수열(LIS)
    > + 전깃줄 문제


### DP 접근
1. dp[i] 정의
 + dp[i] = i번째 원소를 마지막으로 하는 LIS 길이

2. 점화식
 ```pgsql
 dp[i] = 1
 for j = 0 to i-1:
     if arr[j] < arr[i]:
         dp[i] = max(dp[i], dp[j]+1)
 ```

3. 최종답
 + 전체 LIS길이 = `max(dp[0..n-1])`

---

## 2. LCS (Longest Common Subsequence, 최장 공통 부분 수열)
 + 두 수열에서 **부분 수열 중 두 수열 모두에 공통으로 존재하는 수열** 중 길이가 가장 긴 것
 
 + 예시
    > ```ini
    > s1 = ACAYKP
    > s2 = CAPCAK
    > LCS = ACAK (길이 4)
    > ```
 
 + 특징
    > + 2차원 DP
    > + 순서 유지 필수, 연속X

 + 변형
    > + 편집 거리
    > + 부분 문자열 매칭
    > + 문자열 비교, DNA/텍스트 분석 문제

### DP 접근
1. dp[i][j] 정의
 + dp[i][j] = s1 처음 i글자와 s2 처음 j글자에서 LCS길이

2. 점화식
 ```lua
 if s1[i-1] == s2[j-1]:
    dp[i][j] = dp[i-1][j-1] + 1
 else:
     dp[i][j] = max(dp[i-1][j], dp[i][j-1])
 ```
 
3. 최종답
 + dp[n][m] (s1전체와 s2 전체 기준)

