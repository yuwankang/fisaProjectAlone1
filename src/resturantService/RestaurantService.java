package resturantService;

import resturantDTO.RestaurantDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//RestaurantService 클래스는 식당 데이터를 관리하는 클래스입니다.
public class RestaurantService {
    private final Map<String, RestaurantDTO> restaurants = new HashMap<>(); // 레스토랑 데이터 저장소

    // 새로운 식당 추가
    public void add(RestaurantDTO restaurant) {
        if (restaurant == null) {
            throw new IllegalArgumentException("식당 정보가 비었습니다.");
        }
        restaurants.put(restaurant.getName(), restaurant);
    }

    // 식당 종류로 조회
    public List<RestaurantDTO> getByType(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("식당 종류가 비었습니다..");
        }
        List<RestaurantDTO> result = new ArrayList<>();
        for (RestaurantDTO restaurant : restaurants.values()) {
            if (restaurant.getType().equalsIgnoreCase(type)) {
                result.add(restaurant);
            }
        }
        return result;
    }

    //식당 이름으로 조회
    public RestaurantDTO getByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("식당이름이 비었습니다.");
        }
        return restaurants.get(name);
    }

    //식당 정보 업데이트
    public void updateRestaurant(String name, String newType, String newMenu1, int newPrice1, String newMenu2, int newPrice2) {
        RestaurantDTO restaurant = restaurants.get(name);
        if (restaurant == null) {
            throw new IllegalArgumentException("해당 이름의 식당이 존재하지 않습니다: " + name);
        }
        restaurant.setType(newType);
        restaurant.setMenu1(newMenu1);
        restaurant.setPrice1(newPrice1);
        restaurant.setMenu2(newMenu2);
        restaurant.setPrice2(newPrice2);
    }

    //식당 삭제
    public void deleteRestaurant(String name) {
        if (!restaurants.containsKey(name)) {
            throw new IllegalArgumentException("해당 이름의 식당이 존재하지 않습니다: " + name);
        }
        restaurants.remove(name);
    }
}
