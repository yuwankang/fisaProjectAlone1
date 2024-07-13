package restaurantController;

import resturantDTO.RestaurantDTO;
import resturantService.RestaurantService;

import java.util.List;

//RestaurantController 클래스는 사용자 입력을 처리하고 서비스 계층과 상호 작용합니다.
public class RestaurantController {
    private final RestaurantService service;

    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    //식당 종류로 조회 요청 처리
    public List<RestaurantDTO> getByType(String type) {
        try {
            return service.getByType(type);
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
            return List.of();
        }
    }

    //식당 이름으로 조회 요청 처리
    public RestaurantDTO getByName(String name) {
        try {
            return service.getByName(name);
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
            return null;
        }
    }

    // 새로운 식당 추가 요청 처리
    public void addRestaurant(RestaurantDTO restaurant) {
        try {
            service.add(restaurant);
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
        }
    }

    //식당 정보 업데이트 요청 처리
    public void updateRestaurant(String name, String newType, String newMenu1, int newPrice1, String newMenu2, int newPrice2) {
        try {
            service.updateRestaurant(name, newType, newMenu1, newPrice1, newMenu2, newPrice2);
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
        }
    }

    // 식당 삭제 요청 처리
    public void deleteRestaurant(String name) {
        try {
            service.deleteRestaurant(name);
        } catch (IllegalArgumentException e) {
            System.err.println("오류: " + e.getMessage());
        }
    }
}
