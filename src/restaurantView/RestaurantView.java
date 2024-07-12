package restaurantView;

import restaurantController.ResturantController;
import resturantDTO.ResturantDTO;
import resturantService.ResturantService;

import java.util.List;
import java.util.Scanner;

public class RestaurantView {
    public static void main(String[] args) {
        ResturantService restaurantService = new ResturantService();
        ResturantController restaurantController = new ResturantController(restaurantService);

        // 초기 데이터 입력 (DB 대신 View에 데이터 입력)
        restaurantService.addRestaurant(new ResturantDTO("Restaurant A", "양식", "스파게티", "피자"));
        restaurantService.addRestaurant(new ResturantDTO("Restaurant B", "중식", "짜장면", "탕수육"));
        restaurantService.addRestaurant(new ResturantDTO("Restaurant C", "한식", "불고기", "비빔밥"));
        restaurantService.addRestaurant(new ResturantDTO("Restaurant D", "한식", "김치찌개", "된장찌개"));
        restaurantService.addRestaurant(new ResturantDTO("Restaurant E", "양식", "스테이크", "샐러드"));
        restaurantService.addRestaurant(new ResturantDTO("Restaurant F", "중식", "볶음밥", "군만두"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Display Restaurants by Type");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (option == 1) {
                System.out.print("Enter restaurant type (한식, 중식, 양식): ");
                String type = scanner.nextLine();
                List<ResturantDTO> restaurants = restaurantController.getRestaurantsByType(type);
                if (restaurants.isEmpty()) {
                    System.out.println("No restaurants found for type: " + type);
                } else {
                    for (ResturantDTO restaurant : restaurants) {
                        System.out.println("Restaurant: " + restaurant.getName());
                        System.out.println("Type: " + restaurant.getType());
                        System.out.println("Menu 1: " + restaurant.getMenu1());
                        System.out.println("Menu 2: " + restaurant.getMenu2());
                        System.out.println("---------------------------");
                    }
                }
            } else if (option == 2) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
