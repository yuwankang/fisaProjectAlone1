package resturantDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//RestaurantDTO 클래스는 식당의 정보를 담고 전송하는 데이터 객체입니다.
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDTO {
    private String name;  // 식당 이름
    private String type;  // 레스토랑 종류 (한식, 중식, 양식, 잃식 등)
    private String menu1; // 메뉴 1
    private int price1;   // 메뉴 1의 가격
    private String menu2; // 메뉴 2
    private int price2;   // 메뉴 2의 가격

    // 메뉴 1의 가격 설정 (음수일 경우 예외 발생)
    public void setPrice1(int price1) {
        if (price1 < 0) {
            throw new IllegalArgumentException("메뉴1의 가격은 음수일 수 없습니다.");
        }
        this.price1 = price1;
    }

    // 메뉴 2의 가격 설정 (음수일 경우 예외 발생)
    public void setPrice2(int price2) {
        if (price2 < 0) {
            throw new IllegalArgumentException("메뉴2의 가격은 음수일 수 없습니다.");
        }
        this.price2 = price2;
    }
}
