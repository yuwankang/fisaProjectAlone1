package restaurantController;

import resturantDTO.RestaurantDTO;
import resturantService.RestaurantService;

import java.util.List;

public class RestaurantController {
    // RestaurantService 인스턴스 선언
    private final RestaurantService service;

    // 생성자: RestaurantService 객체를 받아서 service 필드를 초기화
    public RestaurantController(RestaurantService service) {
        this.service = service;
    }

    //주어진 타입에 따라 레스토랑 목록을 반환하는 메서드
    public List<RestaurantDTO> getByType(String type) {
        try {
            // RestaurantService의 getByType 메서드 호출하여 레스토랑 목록 가져오기
            return service.getByType(type);
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 오류 메시지를 출력하고 빈 리스트를 반환
            System.err.println("오류: " + e.getMessage());
            return List.of();
        }
    }


    // 주어진 이름에 따라 레스토랑을 반환하는 메서드
    public RestaurantDTO getByName(String name) {
        try {
            // RestaurantService의 getByName 메서드 호출하여 레스토랑 가져오기
            return service.getByName(name);
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 오류 메시지를 출력하고 null을 반환
            System.err.println("오류: " + e.getMessage());
            return null;
        }
    }
}
