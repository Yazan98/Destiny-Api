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

    private String name;
    private String image;
    private Long profileId;

    @NonNull
    @Column(name = "recipe_id")
    private Long recipeId;

    public RecipeComment() {

    }

    public RecipeComment(String comment, Profile profileId, Long recipeId, Long profileIdD) {
        this.comment = comment;
        this.profileId = profileIdD;
        this.image = profileId.getImage();
        this.name = profileId.getName();
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

    public Long getProfileId() {
        return profileId;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
