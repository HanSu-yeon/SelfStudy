package chap06;
//Ex 6-8
/*
변수가 선언된 위치를 보면 변수의 종류를 알 수 있다
클래스 블럭{}내에 선언된 변수= 인스턴스 변수
static이 붙은 것= static변수(클래스 변수)
나머지= 모두 지역변수

* - 클래스변수(static변수) : width, height
* - 인스턴스 변수: kind, num
* - 지역변수: k, n ,args, p
* */
class PlayingCard {
    int kind;
    int num;
    
    static int width;
    static int height;

    PlayingCard(int k, int n) {
        this.kind = k;
        this.num =n;
    }

    public static void main(String[] args) {
        PlayingCard p = new PlayingCard(1,1);
    }
}

//Ex 6-9
//이 클래스의 멤버중에 static을 붙여야 하는 것은 어떤 것들이고 그 이유는 무엇인가?
//- weapon, armor --> 모든 Marine인스턴스에 대해 동일한 값이어야 하므로
//- weaponUp, armorUp: static변수에 대한 작업을 하는 메서드이므로

//--> 인스턴스마다 개별적인 값을 가져야하는 변수는 인스턴스 변수로, 모든 인스턴스가 공통적인 값을 가져야하는 변수는 클래스 변수(static변수)로 선언
class Marine {
    int x=0, y=0; // Marine (x,y) 의 위치좌표
    int hp = 60; // 현재 체력
    int weapon = 6; // 공격력
    int armor = 0; // 방어력
    void weaponUp() {
        weapon++;
    }
    void armorUp() {
        armor++;
    }
    void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
