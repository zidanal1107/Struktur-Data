package praktikum.demo.Services;

public class OrderItem {
    private String name;
    private FoodCategory foodCategory;
    private int quantity;

    public OrderItem(String name, FoodCategory foodCategory, int quantity) {
        this.name = name;
        this.foodCategory = foodCategory;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return " - "+name+" x"+quantity+" ("+foodCategory+") ";
    }

    public String getName() {
        return name;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public int getCount() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public void setCount(int quantity) {
        this.quantity = quantity;
    }
}
