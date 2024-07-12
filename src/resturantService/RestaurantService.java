package resturantService;

import lombok.Getter;
import resturantDTO.RestaurantDTO;

import java.util.ArrayList;
import java.util.List;


public class RestaurantService {
    private final List<RestaurantDTO> restaurants = new ArrayList<>();

    public void addRestaurant(RestaurantDTO restaurant) {
        restaurants.add(restaurant);
    }

    public List<RestaurantDTO> getRestaurantsByType(String type) {
        List<RestaurantDTO> result = new ArrayList<>();
        for (RestaurantDTO restaurant : restaurants) {
            if (restaurant.getType().equalsIgnoreCase(type)) {
                result.add(restaurant);
            }
        }
        return result;
    }

}
