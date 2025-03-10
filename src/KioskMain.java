public class KioskMain {

    public static void main(String[] args) {
        // Menu 객체 생성하면서 카테고리 이름 설정
        Menu burgers = new Menu("Burgers");
        Menu drinks = new Menu("Drinks");
        Menu desserts = new Menu("Desserts");

        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        burgers.addMenu(new MenuItem(1, "shackBurgur", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenu(new MenuItem(2, " SmokeShack ", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenu(new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenu(new MenuItem(4, "  Hamburger ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        drinks.addMenu(new MenuItem(1, "Lemonade", 4.5, "매장에서 직접 만드는 상큼한 레몬에이드"));
        drinks.addMenu(new MenuItem(2, "Iced Tea", 3.7, "직접 유기농 홍차를 우려낸 아이스티"));
        drinks.addMenu(new MenuItem(3, "  Coke  ", 2.9, "코카콜라"));
        drinks.addMenu(new MenuItem(4, " Sprite ", 4.5, "스프라이트"));

        desserts.addMenu(new MenuItem(1, "Shack Attack", 6.2, "초콜릿 커스터드에 세 가지 초콜릿 토핑"));
        desserts.addMenu(new MenuItem(2, "    Fries   ", 4.9, "바삭하고 담백한 크링클 컷 프라이"));
        desserts.addMenu(new MenuItem(3, "   Hot dog  ", 5.1, "비프 소시지와 포테이토 번을 사용한 핫도그"));

        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk();

        kiosk.addCategory(burgers);
        kiosk.addCategory(drinks);
        kiosk.addCategory(desserts);

        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}
