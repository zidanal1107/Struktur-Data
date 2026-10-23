package praktikum.demo.Services;

import praktikum.demo.Data.MyLinkedList.MyLinkedList;
import praktikum.demo.Data.MyLinkedList.Node;

public class FoodOrder<T> extends Customer<T> {
    private String code;
    private MyLinkedList<OrderItem> linkedList;

    public FoodOrder(String name, T id, String code) {
        super(name, id);
        this.code = code;
        this.linkedList = new MyLinkedList<>();
    }

    public void getItem() {
        linkedList.print();
    }
    public boolean find(OrderItem data) {
        return linkedList.findData(data);
    }
    public void addItem(OrderItem orderItem) {
        linkedList.addNormalPassenger(orderItem);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
