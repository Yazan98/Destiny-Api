package com.yazan98.destiny.server.data.entity.phone;

import io.vortex.spring.boot.base.models.database.VortexBaseEntity;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:32 PM
 */

@Entity
@Table(name = "accounts_numbers")
public class PhoneNumber implements Serializable, VortexBaseEntity {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "user_id")
    private Long userId;

    @NonNull
    @Column(name = "code")
    private String code;

    @NonNull
    @Column(name = "status")
    private String status;

    public PhoneNumber() {

    }

    public PhoneNumber(@NonNull Long userId, @NonNull String code, @NonNull String status) {
        this.userId = userId;
        this.code = code;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
