package resturantService;

import resturantDTO.RestaurantDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RestaurantService {
    private final Map<String, RestaurantDTO> restaurants = new HashMap<>();

    // 식당 추가 메서드
    public void add(RestaurantDTO restaurant) {
        if (restaurant == null) {
            throw new IllegalArgumentException("식당 정보는 null일 수 없습니다.");
        }
        restaurants.put(restaurant.getName(), restaurant);
    }

    // 타입에 따른 식당 목록 조회 메서드
    public List<RestaurantDTO> getByType(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("타입은 null이거나 빈 문자열일 수 없습니다.");
        }
        List<RestaurantDTO> result = new ArrayList<>();
        for (RestaurantDTO restaurant : restaurants.values()) {
            if (restaurant.getType().equalsIgnoreCase(type)) {
                result.add(restaurant);
            }
        }
        return result;
    }

    // 이름으로 식당 조회 메서드
    public RestaurantDTO getByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 null이거나 빈 문자열일 수 없습니다.");
        }
        return restaurants.get(name);
    }
}
