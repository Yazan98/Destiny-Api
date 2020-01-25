package com.yazan98.destiny.server.config.entity

import com.yazan98.destiny.server.data.entity.Food
import com.yazan98.destiny.server.service.FoodService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
open class FoodConfig @Autowired constructor(foodService: FoodService) {

    init {
        getAllRecipes().forEach {
            foodService.create(it)
        }
    }

    private fun getAllRecipes(): List<Food> {
        return arrayListOf(
                Food("Salamon Fish Steak",
                        "https://thumbs.dreamstime.com/z/red-salamon-5368900.jpg",
                        "Net wt. 500gms", 150.10, true, 4.2F, 20L, "1 Day", "Net wt. 500gms",
                        "A fish steak is cut crosswise (perpendicular to the spine), cutting through the bone, whereas a fillet is cut lengthwise parallel to the bone",
                        "No. 2 - 7", true, 1),
                Food("Chicken Drumstick",
                        "https://thumbs.dreamstime.com/z/raw-chicken-drumstick-raw-chicken-drumstick-chicken-drumstick-cutting-board-spices-tomatoes-spinach-leaves-108902281.jpg",
                        "Net wt. 500gms", 10.15, true, 4.2F, 20L, "1 Day", "Net wt. 500gms",
                        "A fish steak is cut crosswise (perpendicular to the spine), cutting through the bone, whereas a fillet is cut lengthwise parallel to the bone",
                        "No. 2 - 7", true, 1),
                Food("Red fish omega 3, fresh avocado",
                        "https://thumbs.dreamstime.com/z/red-fish-avocado-nuts-blue-wooden-background-healthy-food-fresh-organic-red-fish-avocado-organic-nuts-blue-wooden-124754955.jpg",
                        "Net wt. 500gms", 150.0, true, 4.2F, 20L, "1 Day", "Net wt. 500gms",
                        "A fish steak is cut crosswise (perpendicular to the spine), cutting through the bone, whereas a fillet is cut lengthwise parallel to the bone",
                        "No. 2 - 7", true, 1),
                Food("Sausages, shish kebab",
                        "https://thumbs.dreamstime.com/z/sausages-shish-kebab-fried-fish-other-food-street-food-festival-sausages-shish-kebab-fried-fish-salads-other-food-109810460.jpg",
                        "Net wt. 500gms", 150.0, true, 4.2F, 20L, "1 Day", "Net wt. 500gms",
                        "A fish steak is cut crosswise (perpendicular to the spine), cutting through the bone, whereas a fillet is cut lengthwise parallel to the bone",
                        "No. 2 - 7", true, 1),
                Food("Salamon Fish Steak",
                        "https://firebasestorage.googleapis.com/v0/b/destiny-51653.appspot.com/o/food%2FNew%20Project%20(5).jpg?alt=media&token=758101a6-99d2-4d1c-a03c-de56ae47832b",
                        "Net wt. 500gms", 150.0, true, 4.2F, 20L, "1 Day", "Net wt. 500gms",
                        "A fish steak is cut crosswise (perpendicular to the spine), cutting through the bone, whereas a fillet is cut lengthwise parallel to the bone",
                        "No. 2 - 7", true, 1)
        )
    }

}
