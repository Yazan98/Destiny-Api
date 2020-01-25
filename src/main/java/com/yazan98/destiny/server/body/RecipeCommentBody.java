package com.yazan98.destiny.server.body;

public class RecipeCommentBody {

    private Long profileId;
    private String comment;
    private Long recipeId;

    public RecipeCommentBody(Long profileId, String comment, Long recipeId) {
        this.profileId = profileId;
        this.comment = comment;
        this.recipeId = recipeId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public Long getProfileId() {
        return profileId;
    }

    public String getComment() {
        return comment;
    }
}
