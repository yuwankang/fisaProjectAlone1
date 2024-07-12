package resturantDTO;

public class ResturantDTO {
    private String name;
    private String type;
    private String menu1;
    private String menu2;

    public ResturantDTO(String name, String type, String menu1, String menu2) {
        this.name = name;
        this.type = type;
        this.menu1 = menu1;
        this.menu2 = menu2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMenu1() {
        return menu1;
    }

    public void setMenu1(String menu1) {
        this.menu1 = menu1;
    }

    public String getMenu2() {
        return menu2;
    }

    public void setMenu2(String menu2) {
        this.menu2 = menu2;
    }
}
