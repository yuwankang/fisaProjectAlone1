package restaurantView;


import restaurantController.RestaurantController;
import resturantDTO.RestaurantDTO;
import resturantService.RestaurantService;

import java.util.InputMismatchException;

import java.util.List;
import java.util.Scanner;

public class RestaurantView {
    public static void main(String[] args) {
        RestaurantService service = new RestaurantService();
        RestaurantController controller = new RestaurantController(service);

        // 초기 데이터 입력
        service.add(new RestaurantDTO("양식집 1", "양식", "스파게티", 11000, "피자", 15000));
        service.add(new RestaurantDTO("중식집 1", "중식", "짜장면", 7000, "탕수육", 25000));
        service.add(new RestaurantDTO("한식집 1", "한식", "불고기", 12000, "비빔밥", 10000));
        service.add(new RestaurantDTO("한식집 2", "한식", "김치찌개", 9700, "된장찌개", 8000));
        service.add(new RestaurantDTO("양식집 2", "양식", "스테이크", 20000, "샐러드", 9000));
        service.add(new RestaurantDTO("중식집 2", "중식", "볶음밥", 7000, "군만두", 6000));
        service.add(new RestaurantDTO("일식집 1", "일식", "스시", 13000, "튀김", 6000));
        service.add(new RestaurantDTO("일식집 2", "일식", "우동", 7000, "오코노미야끼", 10000));


        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 요리 종류로 조회");
            System.out.println("2. 식당 이름으로 조회");
            System.out.println("3. 나가기");
            System.out.print("원하는 옵션을 선택하세요: ");

            int option = 0;
            try {
                option = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");
                scanner.nextLine(); // 입력 버퍼 비우기
                continue;
            }

            if (option == 1) {
                System.out.print("원하시는 요리 종류를 선택하세요 (한식, 중식, 양식, 일식): ");
                scanner.nextLine(); // 버퍼 비우기
                String type = scanner.nextLine();

                // 입력한 type에 해당하는 식당 목록 조회
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
                System.out.print("조회할 식당의 이름을 입력하세요: ");
                scanner.nextLine(); // 버퍼 비우기
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
                break;
            } else {
                System.out.println("없는 옵션입니다. 다시 선택하세요.");
            }
        }

        scanner.close();
    }
}
