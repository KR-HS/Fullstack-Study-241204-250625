# 타입 , 서브쿼리, 함수 
# 오라클에서 mysql로 변경되는점
# varchar2(30) -> varchar(30)
# number(10) -> int<정수형> , decimal(10,3)<실수(자리수,소수점자리수)>
# date -> date, timestamp
# 시퀀스가 없고 auto_increment
# 조인구문은 다 같음 (inner,left,right,full,cross)
# 서브쿼리절에는 반드시 테이블 앨리어스를 부착
select * from
(select 'hello') as a; 
# 함수는 찾아서 쓸것