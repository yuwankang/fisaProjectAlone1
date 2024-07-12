package restaurantController;


import resturantDTO.RestaurantDTO;
import resturantService.RestaurantService;

import java.util.List;

public class RestaurantController {
    private RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public List<RestaurantDTO> getRestaurantsByType(String type) {
        return restaurantService.getRestaurantsByType(type);
    }
}
