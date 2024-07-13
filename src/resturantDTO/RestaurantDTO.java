package resturantDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    //식당 이름
    private String name;
    //식당 종류
    private String type;
    //메뉴 1
    private String menu1;
    //메뉴 1 가격
    private int price1;
    //메뉴 2
    private String menu2;
    //메뉴 2 가격
    private int price2;

}

