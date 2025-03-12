### 키오스크 만들기

- JDK version

Oracle OpenJDK 23.0.1

- 목적

메뉴들을 출력한 뒤 사용자 입력을 통해 주문을 받고 최종 결제까지 할 수 있는 프로그램

- 주요기능

Main : 시작 지점이 되는 클래스, public static void main(String[] args)
MenuItem: 세부 메뉴 속성 가지는 클래스 
Kiosk: 프로그램 순서 및 흐름 제어를 담당하는 클래스
Menu: MenuItem 클래스를 관리하는 클래스
DiscountPercent: enum을 통해 할인율을 관리하는 클래스
ShoppingCart: 사용자 입력을 통해 받은 주문을 저장해놓는 클래스

- 트러블슈팅 및 느낀점
> https://velog.io/@w0729/%ED%82%A4%EC%98%A4%EC%8A%A4%ED%81%AC-%EB%A7%8C%EB%93%A4%EA%B8%B0#lv-1-%EA%B8%B0%EB%B3%B8%EC%A0%81%EC%9D%B8-%ED%82%A4%EC%98%A4%EC%8A%A4%ED%81%AC%EB%A5%BC-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D%ED%95%B4%EB%B3%B4%EC%9E%90
