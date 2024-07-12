package restaurantController;

import resturantDTO.ResturantDTO;
import resturantService.ResturantService;

import java.util.List;

public class ResturantController {
    private ResturantService restaurantService;

    public ResturantController(ResturantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public List<ResturantDTO> getRestaurantsByType(String type) {
        return restaurantService.getRestaurantsByType(type);
    }
}
