package restaurantView;

import restaurantController.RestaurantController;


import resturantDTO.RestaurantDTO;
import resturantService.RestaurantService;

import java.util.List;
import java.util.Scanner;

public class RestaurantView {
    public static void main(String[] args) {
        RestaurantService restaurantService = new RestaurantService();
        RestaurantController restaurantController = new RestaurantController(restaurantService);

        // 초기 데이터 입력 (DB 대신 View에 데이터 입력)
        restaurantService.addRestaurant(new RestaurantDTO("양식집 1", "양식", "스파게티", "피자"));
        restaurantService.addRestaurant(new RestaurantDTO("중식집 1", "중식", "짜장면", "탕수육"));
        restaurantService.addRestaurant(new RestaurantDTO("한식집 1", "한식", "불고기", "비빔밥"));
        restaurantService.addRestaurant(new RestaurantDTO("한식집 2", "한식", "김치찌개", "된장찌개"));
        restaurantService.addRestaurant(new RestaurantDTO("양식집 2", "양식", "스테이크", "샐러드"));
        restaurantService.addRestaurant(new RestaurantDTO("중식집 2", "중식", "볶음밥", "군만두"));
        restaurantService.addRestaurant(new RestaurantDTO("일식집 2", "일식", "스시", "튀김"));
        restaurantService.addRestaurant(new RestaurantDTO("일식집 2", "일식", "우동", "오코노미야끼"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 실행");
            System.out.println("2. 나가기");
            System.out.print("원하는 옵션을 선택하세요: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("원하시는 요리 종류를 선택하세요 (한식, 중식, 양식, 일식): ");
                String type = scanner.nextLine();
                List<RestaurantDTO> restaurants = restaurantController.getRestaurantsByType(type);
                if (restaurants.isEmpty()) {
                    System.out.println("없는 타입의 식당입니다.: " + type);
                } else {
                    for (RestaurantDTO restaurant : restaurants) {
                        System.out.println("레스토랑: " + restaurant.getName());
                        System.out.println("종류: " + restaurant.getType());
                        System.out.println("메뉴 1: " + restaurant.getMenu1());
                        System.out.println("메뉴 2: " + restaurant.getMenu2());
                        System.out.println("---------------------------");
                    }
                }
            } else if (option == 2) {
                break;
            } else {
                System.out.println("없는 옵션입니다 다시 선택하세요.");
            }
        }

        scanner.close();
    }
}
