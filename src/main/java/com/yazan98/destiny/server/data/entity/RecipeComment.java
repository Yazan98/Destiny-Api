package com.yazan98.destiny.server.data.entity;

import com.yazan98.destiny.server.data.entity.user.Profile;
import lombok.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "recipes")
public class RecipeComment implements Serializable {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Column(name = "comment")
    private String comment;

    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    @NonNull
    @Column(name = "recipe_id")
    private Long recipeId;

    public RecipeComment() {

    }

    public RecipeComment(String comment, Profile profileId, Long recipeId) {
        this.comment = comment;
        this.profile = profileId;
        this.recipeId = recipeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
