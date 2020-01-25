package com.yazan98.destiny.server.config.entity

import com.yazan98.destiny.server.data.entity.Recipe
import com.yazan98.destiny.server.data.entity.RecipeComment
import com.yazan98.destiny.server.data.entity.user.Profile
import com.yazan98.destiny.server.data.repository.RecipeCommentsRepository
import com.yazan98.destiny.server.service.FoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
open class RecipesConfig @Autowired constructor(foodService: FoodService, comments: RecipeCommentsRepository) {

    init {
        getAllRecipes().forEach {
            foodService.create(it)
        }

        getAllComments().forEach {
            comments.save(it)
        }
    }

    private fun getAllRecipes(): List<Recipe> {
        return arrayListOf(
                Recipe("Salamon Fish Steak",
                        "https://thumbs.dreamstime.com/z/red-salamon-5368900.jpg",
                        "Net wt. 500gms", 150.10, false, 4.2F, 20L, "1 Day", "Net wt. 500gms",
                        "A fish steak is cut crosswise (perpendicular to the spine), cutting through the bone, whereas a fillet is cut lengthwise parallel to the bone",
                        "No. 2 - 7", false, 1),
                Recipe("Chicken Drumstick",
                        "https://thumbs.dreamstime.com/z/raw-chicken-drumstick-raw-chicken-drumstick-chicken-drumstick-cutting-board-spices-tomatoes-spinach-leaves-108902281.jpg",
                        "Net wt. 500gms", 10.15, false, 4.2F, 20L, "1 Day", "Net wt. 500gms",
                        "A fish steak is cut crosswise (perpendicular to the spine), cutting through the bone, whereas a fillet is cut lengthwise parallel to the bone",
                        "No. 2 - 7", false, 1),
                Recipe("Red fish omega 3, fresh avocado",
                        "https://thumbs.dreamstime.com/z/red-fish-avocado-nuts-blue-wooden-background-healthy-food-fresh-organic-red-fish-avocado-organic-nuts-blue-wooden-124754955.jpg",
                        "Net wt. 500gms", 150.0, false, 4.2F, 20L, "1 Day", "Net wt. 500gms",
                        "A fish steak is cut crosswise (perpendicular to the spine), cutting through the bone, whereas a fillet is cut lengthwise parallel to the bone",
                        "No. 2 - 7", false, 1),
                Recipe("Sausages, shish kebab",
                        "https://thumbs.dreamstime.com/z/sausages-shish-kebab-fried-fish-other-food-street-food-festival-sausages-shish-kebab-fried-fish-salads-other-food-109810460.jpg",
                        "Net wt. 500gms", 150.0, false, 4.2F, 20L, "1 Day", "Net wt. 500gms",
                        "A fish steak is cut crosswise (perpendicular to the spine), cutting through the bone, whereas a fillet is cut lengthwise parallel to the bone",
                        "No. 2 - 7", false, 1),
                Recipe("Salamon Fish Steak",
                        "https://firebasestorage.googleapis.com/v0/b/destiny-51653.appspot.com/o/food%2FNew%20Project%20(5).jpg?alt=media&token=758101a6-99d2-4d1c-a03c-de56ae47832b",
                        "Net wt. 500gms", 150.0, false, 4.2F, 20L, "1 Day", "Net wt. 500gms",
                        "A fish steak is cut crosswise (perpendicular to the spine), cutting through the bone, whereas a fillet is cut lengthwise parallel to the bone",
                        "No. 2 - 7", false, 1)
        )
    }

    private fun getAllComments(): List<RecipeComment> {
        return arrayListOf(
                RecipeComment(
                        "This Recipe Is Awesome :D",
                        Profile("Yazan", "123456789", "ss@yahoo.com",
                                "AA", true,
                                "https://images.unsplash.com/photo-1518806118471-f28b20a1d79d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80",
                                "123456789"),
                        7
                ),
                RecipeComment(
                        "This Recipe Is Awesome :D",
                        Profile("Yazan", "123456789", "ss@yahoo.com",
                                "AA", true,
                                "https://images.unsplash.com/photo-1529665253569-6d01c0eaf7b6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=976&q=80",
                                "123456789"),
                        7
                ),
                RecipeComment(
                        "Good Recipe :D",
                        Profile("Yazan", "123456789", "ss@yahoo.com",
                                "AA", true,
                                "https://images.unsplash.com/photo-1497316730643-415fac54a2af?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=700&q=80",
                                "123456789"),
                        7
                )
        )
    }

}
