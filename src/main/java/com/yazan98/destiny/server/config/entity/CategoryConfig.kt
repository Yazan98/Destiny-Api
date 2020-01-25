package com.yazan98.destiny.server.config.entity

import com.yazan98.destiny.server.controller.CategoryController
import com.yazan98.destiny.server.controller.FoodController
import com.yazan98.destiny.server.data.entity.category.Category
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
open class CategoryConfig @Autowired constructor(placesController: CategoryController) {

    init {
        getAllCategories().forEach {
            placesController.save(it)
        }
    }

    private fun getAllCategories(): List<Category> {
        return arrayListOf(
                Category(
                        "Steak",
                        "https://firebasestorage.googleapis.com/v0/b/destiny-51653.appspot.com/o/icons%2FNew%20Project.png?alt=media&token=04a43f17-37ad-4ab8-9011-07dfc2b189f5"
                ),
                Category(
                        "Shrimp",
                        "https://firebasestorage.googleapis.com/v0/b/destiny-51653.appspot.com/o/icons%2FNew%20Project%20(1).png?alt=media&token=532779f6-1b28-4235-bfcd-0e309daeba58"
                ),
                Category(
                        "Ham",
                        "https://firebasestorage.googleapis.com/v0/b/destiny-51653.appspot.com/o/icons%2FNew%20Project%20(2).png?alt=media&token=b9326d8d-b715-4a61-a2f6-63abd80e3a64"
                ),
                Category(
                        "Fish",
                        "https://firebasestorage.googleapis.com/v0/b/destiny-51653.appspot.com/o/icons%2FNew%20Project%20(3).png?alt=media&token=50649750-a732-4da2-8a64-2c2f47f41638"
                ),
                Category(
                        "Sushi",
                        "https://firebasestorage.googleapis.com/v0/b/destiny-51653.appspot.com/o/icons%2FNew%20Project%20(4).png?alt=media&token=8e3d173f-9b90-4147-b447-fb4d32bcce9c"
                )
        )
    }

}