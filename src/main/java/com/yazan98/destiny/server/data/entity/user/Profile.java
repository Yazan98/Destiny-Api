package com.yazan98.destiny.server.data.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vortex.spring.boot.base.models.database.VortexBaseEntity;
import io.vortex.spring.boot.base.models.database.VortexMysqlEntity;
import lombok.NonNull;
import javax.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

/**
 * Created By : Yazan Tarifi
 * Date : 12/30/2019
 * Time : 3:14 AM
 */

@Entity
@Table(name = "accounts")
public class Profile implements UserDetails, Serializable, VortexBaseEntity {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Size(min = 8, max = 25, message = "Password Min 8 , Max 25")
    @Column(name = "password")
    private String password;

    @NonNull
    @Email
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "status")
    private String accountStatus;

    @NonNull
    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "image")
    private String image;

    @NonNull
    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnore
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private ProfileLocation location;

    public Profile() {

    }

    public Profile(String id, @NonNull String username, @NonNull @Size(min = 8, max = 25, message = "Password Min 8 , Max 25") String password, @NonNull @Email String email, @NonNull String accountStatus, @NonNull Boolean enabled, @NonNull String image, @NonNull String phoneNumber) {
        this.name = username;
        this.password = password;
        this.email = email;
        this.accountStatus = accountStatus;
        this.enabled = enabled;
        this.image = image;
        this.phoneNumber = phoneNumber;
    }

    public void setLocation(ProfileLocation location) {
        this.location = location;
    }

    public ProfileLocation getLocation() {
        return location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    //
    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

}
