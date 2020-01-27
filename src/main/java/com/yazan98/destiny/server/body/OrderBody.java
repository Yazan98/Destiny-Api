package com.yazan98.destiny.server.body;

import com.yazan98.destiny.server.data.entity.order.Order;
import com.yazan98.destiny.server.data.entity.order.OrderItem;

import java.util.List;

public class OrderBody {

    private Order order;
    private List<OrderItem> items;

    public OrderBody() {

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
