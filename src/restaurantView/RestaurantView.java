package restaurantView;

import restaurantController.RestaurantController;
import resturantDTO.RestaurantDTO;
import resturantService.RestaurantService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//RestaurantView 클래스는 사용자 인터페이스를 제공하고 사용자의 입력을 처리합니다.

public class RestaurantView {
    public static void main(String[] args) {
        RestaurantService service = new RestaurantService();
        RestaurantController controller = new RestaurantController(service);

        // 초기 데이터 입력
        try {
            service.add(new RestaurantDTO("양식집 1", "양식", "스파게티", 10000, "피자", 15000));
            service.add(new RestaurantDTO("중식집 1", "중식", "짜장면", 6000, "탕수육", 25000));
            service.add(new RestaurantDTO("한식집 1", "한식", "불고기", 13000, "비빔밥", 8000));
            service.add(new RestaurantDTO("한식집 2", "한식", "김치찌개", 9000, "된장찌개", 4000));
            service.add(new RestaurantDTO("양식집 2", "양식", "스테이크", 20000, "샐러드", 8000));
            service.add(new RestaurantDTO("중식집 2", "중식", "볶음밥", 8000, "군만두", 6000));
            service.add(new RestaurantDTO("일식집 1", "일식", "스시", 12000, "튀김", 4000));
            service.add(new RestaurantDTO("일식집 2", "일식", "우동", 8000, "오코노미야끼", 10000));
        } catch (IllegalArgumentException e) {
            System.err.println("데이터 초기화 오류: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);

        // 사용자 인터페이스 루프
        while (true) {
            System.out.println("1. 요리 종류로 조회");
            System.out.println("2. 식당 이름으로 조회");
            System.out.println("3. 식당 추가");
            System.out.println("4. 식당 수정");
            System.out.println("5. 식당 삭제");
            System.out.println("6. 나가기");
            System.out.print("원하는 옵션을 선택하세요: ");

            int option = 0;
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");
                scanner.nextLine(); // 입력 버퍼 비우기
                continue;
            }

            scanner.nextLine(); // 버퍼 비우기

            if (option == 1) {
                System.out.print("원하시는 요리 종류를 선택하세요 (한식, 중식, 양식, 일식): ");
                String type = scanner.nextLine();

                // 입력한 종류에 해당하는 식당 목록 조회
                List<RestaurantDTO> restaurants = controller.getByType(type);

                if (restaurants.isEmpty()) {
                    System.out.println("입력한 종류에 해당하는 식당이 없습니다: " + type);
                } else {
                    for (RestaurantDTO restaurant : restaurants) {
                        System.out.println("식당: " + restaurant.getName());
                        System.out.println("종류: " + restaurant.getType());
                        System.out.println("메뉴 1: " + restaurant.getMenu1() + " - 가격: " + restaurant.getPrice1());
                        System.out.println("메뉴 2: " + restaurant.getMenu2() + " - 가격: " + restaurant.getPrice2());
                        System.out.println("---------------------------");
                    }
                }
            } else if (option == 2) {
                System.out.print("조회할 식당 이름을 입력하세요: ");
                String name = scanner.nextLine();

                // 입력한 이름에 해당하는 식당 조회
                RestaurantDTO restaurant = controller.getByName(name);

                if (restaurant == null) {
                    System.out.println("입력한 이름에 해당하는 식당이 없습니다: " + name);
                } else {
                    System.out.println("식당: " + restaurant.getName());
                    System.out.println("종류: " + restaurant.getType());
                    System.out.println("메뉴 1: " + restaurant.getMenu1() + " - 가격: " + restaurant.getPrice1());
                    System.out.println("메뉴 2: " + restaurant.getMenu2() + " - 가격: " + restaurant.getPrice2());
                    System.out.println("---------------------------");
                }
            } else if (option == 3) {
                try {
                    System.out.print("추가할 식당 이름을 입력하세요: ");
                    String name = scanner.nextLine();
                    System.out.print("레스토랑 종류를 입력하세요: ");
                    String type = scanner.nextLine();
                    System.out.print("메뉴 1을 입력하세요: ");
                    String menu1 = scanner.nextLine();
                    System.out.print("메뉴 1의 가격을 입력하세요: ");
                    int price1 = scanner.nextInt();
                    if (price1 < 0) throw new IllegalArgumentException("메뉴 1의 가격은 음수일 수 없습니다.");
                    scanner.nextLine(); // 버퍼 비우기
                    System.out.print("메뉴 2를 입력하세요: ");
                    String menu2 = scanner.nextLine();
                    System.out.print("메뉴 2의 가격을 입력하세요: ");
                    int price2 = scanner.nextInt();
                    if (price2 < 0) throw new IllegalArgumentException("메뉴 2의 가격은 음수일 수 없습니다.");
                    scanner.nextLine(); // 버퍼 비우기

                    controller.addRestaurant(new RestaurantDTO(name, type, menu1, price1, menu2, price2));
                } catch (InputMismatchException e) {
                    System.out.println("가격은 숫자여야 합니다. 입력을 다시 시도하세요.");
                    scanner.nextLine(); // 입력 버퍼 비우기
                } catch (IllegalArgumentException e) {
                    System.out.println("오류: " + e.getMessage());
                }
            } else if (option == 4) {
                try {
                    System.out.print("수정할 식당 이름을 입력하세요: ");
                    String name = scanner.nextLine();
                    System.out.print("새로운 식당 종류를 입력하세요: ");
                    String newType = scanner.nextLine();
                    System.out.print("새로운 메뉴 1을 입력하세요: ");
                    String newMenu1 = scanner.nextLine();
                    System.out.print("새로운 메뉴 1의 가격을 입력하세요: ");
                    int newPrice1 = scanner.nextInt();
                    if (newPrice1 < 0) throw new IllegalArgumentException("새로운 메뉴 1의 가격은 음수일 수 없습니다.");
                    scanner.nextLine(); // 버퍼 비우기
                    System.out.print("새로운 메뉴 2를 입력하세요: ");
                    String newMenu2 = scanner.nextLine();
                    System.out.print("새로운 메뉴 2의 가격을 입력하세요: ");
                    int newPrice2 = scanner.nextInt();
                    if (newPrice2 < 0) throw new IllegalArgumentException("새로운 메뉴 2의 가격은 음수일 수 없습니다.");
                    scanner.nextLine(); // 버퍼 비우기

                    controller.updateRestaurant(name, newType, newMenu1, newPrice1, newMenu2, newPrice2);
                } catch (InputMismatchException e) {
                    System.out.println("가격은 숫자여야 합니다. 입력을 다시 시도하세요.");
                    scanner.nextLine(); // 입력 버퍼 비우기
                } catch (IllegalArgumentException e) {
                    System.out.println("오류: " + e.getMessage());
                }
            } else if (option == 5) {
                System.out.print("삭제할 식당 이름을 입력하세요: ");
                String name = scanner.nextLine();

                controller.deleteRestaurant(name);
            } else if (option == 6) {
                break;
            } else {
                System.out.println("없는 옵션입니다. 다시 선택하세요.");
            }
        }

        scanner.close();
    }
}
