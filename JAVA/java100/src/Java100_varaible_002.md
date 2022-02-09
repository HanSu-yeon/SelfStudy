**Q.자바의 데이터타입(자료형)에 대해서 각 타입의 사이즈와 함께 설명해보시오. 정수형의 경우 사이즈와 범위도 말해보시오**


A.
크게 봤을 때 기본형타입과 참조형 타입으로 나뉨

**기본형 타입(Primitive Data Type)** ⇒ 8개

1. 정수형: byte(1byte), short(2byte), **int(4)**, long(8)
2. 실수형: float(4), **double(8)**
3. 문자형: char(2byte)⇒ 문자형. 참고로 기본형에서 문자열을 다루는 타입은 없다
4. 부울형(논리형: true or false): boolean(1byte)

**참조형 타입(Reference Data Type)** ⇒위 기본형에 속하지 않는 데이터형들 
대표적으로 클래스(class), 배열(array), 인터페이스(Interface), 문자열(String/immutable)이 있다

참조형 변수의 **특징**

데이터가 저장된 메모리의 주소 값을 저장하는 변수