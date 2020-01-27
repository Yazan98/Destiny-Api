package com.yazan98.destiny.server.data.entity.order;

import io.vortex.spring.boot.base.models.database.VortexMysqlEntity;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public class Order extends VortexMysqlEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "delivery_data")
    private Long deliveryDate;

    @NonNull
    @Column(name = "profile_id")
    private Long profileId;

    @NonNull
    @Column(name = "price")
    private Double price;

    @NonNull
    @Column(name = "order_name")
    private String orderName;

    public Order() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
