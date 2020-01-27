package com.yazan98.destiny.server.data.entity.order;

import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_items")
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "image")
    private String image;

    @NonNull
    @Column(name = "price")
    private Double price;

    @NonNull
    @Column(name = "qty")
    private Integer qty;

    @NonNull
    @Column(name = "order_id")
    private Long orderId;

    public OrderItem() {

    }

    public OrderItem(String name, String image, Double price, Integer qty, Long orderId) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.qty = qty;
        this.orderId = orderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
