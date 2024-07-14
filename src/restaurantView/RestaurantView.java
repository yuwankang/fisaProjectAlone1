package restaurantView;

import restaurantController.RestaurantController;
import resturantDTO.RestaurantDTO;
import resturantService.RestaurantService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// RestaurantView 클래스는 사용자 인터페이스를 제공하고 사용자의 입력을 처리합니다.
public class RestaurantView {
    public static void main(String[] args) {
        RestaurantService service = new RestaurantService();  // RestaurantService 객체 생성
        RestaurantController controller = new RestaurantController(service);  // RestaurantController 객체 생성

        // 초기 데이터 입력
        service.add(new RestaurantDTO("양식집 1", "양식", "스파게티", 10000, "피자", 15000));
        service.add(new RestaurantDTO("중식집 1", "중식", "짜장면", 6000, "탕수육", 25000));
        service.add(new RestaurantDTO("한식집 1", "한식", "불고기", 13000, "비빔밥", 8000));
        service.add(new RestaurantDTO("한식집 2", "한식", "김치찌개", 9000, "된장찌개", 4000));
        service.add(new RestaurantDTO("양식집 2", "양식", "스테이크", 20000, "샐러드", 8000));
        service.add(new RestaurantDTO("중식집 2", "중식", "볶음밥", 8000, "군만두", 6000));
        service.add(new RestaurantDTO("일식집 1", "일식", "스시", 12000, "튀김", 4000));
        service.add(new RestaurantDTO("일식집 2", "일식", "우동", 8000, "오코노미야끼", 10000));
        service.add(new RestaurantDTO("분식집 1", "분식", "떡볶이", 5000, "순대", 4000));

        Scanner scanner = new Scanner(System.in);//입력 받기 위한 스캐너사용

        //사용자 인터페이스
        while (true) {
            //메뉴 옵션 출력
            System.out.println("1. 요리 종류로 조회");
            System.out.println("2. 식당 이름으로 조회");
            System.out.println("3. 식당 랜덤 추천");
            System.out.println("4. 식당 추가");
            System.out.println("5. 식당 수정");
            System.out.println("6. 식당 삭제");
            System.out.println("7. 나가기");
            System.out.print("원하는 옵션을 선택하세요: ");

            int option = 0;  //사용자 입력 선언 및 초기화
            try {
                option = scanner.nextInt();  //옵션을 입력받음
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력하세요.");  //입력 오류 시 메시지 출력
                scanner.nextLine(); //입력 버퍼 비우기
                continue;  //루프의 처음으로 돌아가 다시 입력 받음
            }

            scanner.nextLine(); //버퍼 비우기

            //입력에 따른 기능 수행
            switch (option) {
                case 1:
                    // 요리 종류로 조회
                    System.out.print("원하시는 요리 종류를 선택하세요 (한식, 중식, 양식, 일식, 분식): ");
                    String type = scanner.nextLine();  //요리 종류 입력
                    List<RestaurantDTO> restaurants = controller.getByType(type);  //입력된 종류에 따라 식당 목록 조회
                    if (restaurants.isEmpty()) {
                        //입력된 종류에 해당하는 식당이 없는 경우
                        System.out.println("입력한 종류에 해당하는 식당이 없습니다: " + type);
                    } else {
                        //해당 종류의 식당 목록 출력
                        for (RestaurantDTO restaurant : restaurants) {
                            System.out.println("식당: " + restaurant.getName());
                            System.out.println("종류: " + restaurant.getType());
                            System.out.println("메뉴 1: " + restaurant.getMenu1() + " - 가격: " + restaurant.getPrice1());
                            System.out.println("메뉴 2: " + restaurant.getMenu2() + " - 가격: " + restaurant.getPrice2());
                            System.out.println("---------------------------");
                        }
                    }
                    break;
                case 2:
                    //식당 이름으로 조회
                    System.out.print("조회할 식당 이름을 입력하세요: ");
                    String name = scanner.nextLine();  //식당 이름 입력 받음
                    RestaurantDTO restaurant = controller.getByName(name);  //입력된 이름에 따라 식당 조회
                    if (restaurant == null) {
                        //입력된 이름에 해당하는 식당이 없는 경우
                        System.out.println("입력한 이름에 해당하는 식당이 없습니다: " + name);
                    } else {
                        //해당 식당 정보 출력
                        System.out.println("식당: " + restaurant.getName());
                        System.out.println("종류: " + restaurant.getType());
                        System.out.println("메뉴 1: " + restaurant.getMenu1() + " - 가격: " + restaurant.getPrice1());
                        System.out.println("메뉴 2: " + restaurant.getMenu2() + " - 가격: " + restaurant.getPrice2());
                        System.out.println("---------------------------");
                    }
                    break;
                case 3:
                    //식당 랜덤 추천
                    System.out.print("원하는 음식 종류를 고르세요 (한식, 중식, 양식, 일식, 분식): ");
                    String recommendType = scanner.nextLine();  // 요리 종류 입력 받음
                    if (!recommendType.matches("한식|중식|양식|일식|분식")) {
                        //입력된 요리 종류가 올바르지 않은 경우
                        System.out.println("올바른 요리 종류를 입력하세요 (한식, 중식, 양식, 일식, 분식)");
                        break;
                    }
                    try {
                        RestaurantDTO recommendedRestaurant = controller.recommendByType(recommendType);  //입력된 종류에 따라 랜덤 식당 추천
                        //추천된 식당 정보 출력
                        System.out.println("추천 식당: " + recommendedRestaurant.getName());
                        System.out.println("종류: " + recommendedRestaurant.getType());
                        System.out.println("메뉴 1: " + recommendedRestaurant.getMenu1() + " - 가격: " + recommendedRestaurant.getPrice1());
                        System.out.println("메뉴 2: " + recommendedRestaurant.getMenu2() + " - 가격: " + recommendedRestaurant.getPrice2());
                        System.out.println("---------------------------");
                    } catch (IllegalArgumentException e) {
                        //추천 과정에서 오류 발생 시 메시지 출력
                        System.out.println("오류: " + e.getMessage());
                    }
                    break;
                case 4:
                    //식당 추가
                    try {
                        //식당 정보 입력 받음
                        System.out.print("추가할 식당 이름을 입력하세요: ");
                        String addName = scanner.nextLine();
                        System.out.print("음식 종류를 입력하세요: ");
                        String addType = scanner.nextLine();
                        if (!addType.matches("한식|중식|양식|일식|분식")) {
                            // 입력된 음식 종류가 올바르지 않은 경우
                            System.out.println("올바른 요리 종류를 입력하세요 (한식, 중식, 양식, 일식, 분식)");
                            break;
                        }
                        System.out.print("메뉴 1을 입력하세요: ");
                        String addMenu1 = scanner.nextLine();
                        System.out.print("메뉴 1의 가격을 입력하세요: ");
                        int addPrice1 = scanner.nextInt();
                        if (addPrice1 < 0) throw new IllegalArgumentException("메뉴 1의 가격은 음수일 수 없습니다.");  // 가격이 음수인 경우 예외 발생
                        scanner.nextLine(); // 버퍼 비우기
                        System.out.print("메뉴 2를 입력하세요: ");
                        String addMenu2 = scanner.nextLine();
                        System.out.print("메뉴 2의 가격을 입력하세요: ");
                        int addPrice2 = scanner.nextInt();
                        if (addPrice2 < 0) throw new IllegalArgumentException("메뉴 2의 가격은 음수일 수 없습니다.");  // 가격이 음수인 경우 예외 발생
                        scanner.nextLine(); // 버퍼 비우기

                        // 입력된 정보를 바탕으로 식당 추가
                        controller.addRestaurant(new RestaurantDTO(addName, addType, addMenu1, addPrice1, addMenu2, addPrice2));
                    } catch (InputMismatchException e) {
                        // 가격 입력 오류 시 메시지 출력
                        System.out.println("가격은 숫자여야 합니다. 입력을 다시 시도하세요.");
                        scanner.nextLine(); // 입력 버퍼 비우기
                    } catch (IllegalArgumentException e) {
                        // 기타 예외 발생 시 메시지 출력
                        System.out.println("오류: " + e.getMessage());
                    }
                    break;
                case 5:
                    // 식당 수정
                    try {
                        // 수정할 식당 정보 입력 받음
                        System.out.print("수정할 식당 이름을 입력하세요: ");
                        String updateName = scanner.nextLine();
                        System.out.print("새로운 식당 종류를 입력하세요: ");
                        String newType = scanner.nextLine();
                        if (!newType.matches("한식|중식|양식|일식|분식")) {
                            // 입력된 음식 종류가 올바르지 않은 경우
                            System.out.println("올바른 요리 종류를 입력하세요 (한식, 중식, 양식, 일식, 분식)");
                            break;
                        }
                        System.out.print("새로운 메뉴 1을 입력하세요: ");
                        String newMenu1 = scanner.nextLine();
                        System.out.print("새로운 메뉴 1의 가격을 입력하세요: ");
                        int newPrice1 = scanner.nextInt();
                        if (newPrice1 < 0) throw new IllegalArgumentException("메뉴 1의 가격은 음수일 수 없습니다.");  //가격이 음수인 경우 예외 발생
                        scanner.nextLine(); // 버퍼 비우기
                        System.out.print("새로운 메뉴 2를 입력하세요: ");
                        String newMenu2 = scanner.nextLine();
                        System.out.print("새로운 메뉴 2의 가격을 입력하세요: ");
                        int newPrice2 = scanner.nextInt();
                        if (newPrice2 < 0) throw new IllegalArgumentException("메뉴 2의 가격은 음수일 수 없습니다.");  //가격이 음수인 경우 예외 발생
                        scanner.nextLine(); // 버퍼 비우기

                        //식당 정보 수정
                        controller.updateRestaurant(updateName, newType, newMenu1, newPrice1, newMenu2, newPrice2);
                    } catch (InputMismatchException e) {
                        //가격 입력 오류 시 메시지 출력
                        System.out.println("가격은 숫자여야 합니다. 입력을 다시 시도하세요.");
                        scanner.nextLine(); // 입력 버퍼 비우기
                    } catch (IllegalArgumentException e) {
                        //기타 예외 발생 시 메시지 출력
                        System.out.println("오류: " + e.getMessage());
                    }
                    break;
                case 6:
                    //식당 삭제
                    System.out.print("삭제할 식당 이름을 입력하세요: ");
                    String deleteName = scanner.nextLine();  // 삭제할 식당 이름 입력 받음
                    controller.deleteRestaurant(deleteName);  // 입력된 이름에 따라 식당 삭제
                    break;
                case 7:
                    //프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    return;  // main 메서드 종료
                default:
                    //올바르지 않은 옵션 입력 시 메시지 출력
                    System.out.println("올바른 옵션을 선택하세요.");
                    break;
            }
        }
    }
}
