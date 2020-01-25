package com.yazan98.destiny.server.service

import com.yazan98.destiny.server.body.RecipeCommentBody
import com.yazan98.destiny.server.data.entity.Recipe
import com.yazan98.destiny.server.data.entity.RecipeComment
import com.yazan98.destiny.server.data.repository.FoodRepository
import com.yazan98.destiny.server.data.repository.RecipeCommentsRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class FoodService @Autowired constructor(private val repo: FoodRepository) : BaseService<Long, Recipe, FoodRepository>() {
    override fun create(entity: Recipe): Recipe {
        getRepository().save(entity)
        return getEntityById(entity.id)
    }

    override fun getRepository(): FoodRepository {
        return repo
    }

    fun saveCommentByProfileName(
            newComment: RecipeCommentBody,
            profileService: ProfileService,
            commentsRepository: RecipeCommentsRepository
    ): RecipeComment {
        val profile = profileService.getEntityById(newComment.profileId)
        return commentsRepository.save(RecipeComment(newComment.comment, profile, newComment.recipeId))
    }

    fun getAllRecipesPopular(status: Boolean): List<Recipe> {
        return getRepository().findAllByIsPopular(status)
    }

    fun getByCategoryId(id: Long): List<Recipe> {
        return getRepository().findAllByCategoryId(id)
    }

    override fun update(entity: Recipe): Recipe {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
