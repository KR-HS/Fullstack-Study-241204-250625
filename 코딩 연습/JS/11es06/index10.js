/*
하나의 모듈에서 하나의 함수 or 객체를 내보낼때
default export방식을 사용합니다.

*/
function some() {
    return "hello";
}

class Person {
    name = "홍길동";
    speak() {
        console.log("hello");
    }
}

//export default some;
export default Person;


