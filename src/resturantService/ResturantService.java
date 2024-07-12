package resturantService;

import resturantDTO.ResturantDTO;

import java.util.ArrayList;
import java.util.List;

public class ResturantService {
    private List<ResturantDTO> restaurants = new ArrayList<>();

    public void addRestaurant(ResturantDTO restaurant) {
        restaurants.add(restaurant);
    }

    public List<ResturantDTO> getRestaurantsByType(String type) {
        List<ResturantDTO> result = new ArrayList<>();
        for (ResturantDTO restaurant : restaurants) {
            if (restaurant.getType().equalsIgnoreCase(type)) {
                result.add(restaurant);
            }
        }
        return result;
    }

    public List<ResturantDTO> getRestaurants() {
        return restaurants;
    }
}

