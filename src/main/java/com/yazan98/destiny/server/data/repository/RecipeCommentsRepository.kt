package com.yazan98.destiny.server.data.repository

import com.yazan98.destiny.server.data.entity.RecipeComment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecipeCommentsRepository : JpaRepository<RecipeComment, Long> {

    fun findAllByRecipeId(recipeId: Long): List<RecipeComment>

}
