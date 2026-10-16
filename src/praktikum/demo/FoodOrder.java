package praktikum.demo;

public class FoodOrder<T> extends Customer<T> {
    private String code;
    private String menuName;
    private FoodCategory foodCategory;

    public FoodOrder(String name, T id, String code,String menuName, FoodCategory foodCategory) {
        super(name, id);
        this.code = code;
        this.menuName = menuName;
        this.foodCategory = foodCategory;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }
}
