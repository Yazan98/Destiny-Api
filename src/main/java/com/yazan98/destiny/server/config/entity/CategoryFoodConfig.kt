package com.yazan98.destiny.server.config.entity

import com.yazan98.destiny.server.controller.FoodController
import com.yazan98.destiny.server.data.entity.Food
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
open class CategoryFoodConfig @Autowired constructor(foodController: FoodController) {

    init {
        getSteakRecipes().forEach {
            foodController.save(it)
        }

        getFishRecipes().forEach {
            foodController.save(it)
        }
    }

    private fun getSteakRecipes(): List<Food> {
        return arrayListOf(
                Food(
                        "Steak On The Fire",
                        "https://images.unsplash.com/photo-1558030006-450675393462?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1789&q=80",
                        "Net wt. 600gms", 20.21, true, 4.5F, 10L, "20 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 1
                ),
                Food(
                        "Steak With Potato",
                        "https://images.unsplash.com/photo-1544025162-d76694265947?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1049&q=80",
                        "Net wt. 200gms", 10.21, true, 2.5F, 10L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 1
                ), Food(
                "Steak With Vigetables",
                "https://images.unsplash.com/photo-1564857767283-2218d1cfb032?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 10.21, true, 2.5F, 10L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 1
        ), Food(
                "Family Steak Dinner",
                "https://images.unsplash.com/photo-1504674900247-0877df9cc836?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 60.21, true, 2.5F, 10L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 1
        ), Food(
                "Steak With Reddd",
                "https://images.unsplash.com/photo-1570481060336-9c82d078588e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, true, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 1
        ), Food(
                "Steak On The Fire",
                "https://images.unsplash.com/photo-1558030137-a56c1b004fa3?ixlib=rb-1.2.1&auto=format&fit=crop&w=1189&q=80",
                "Net wt. 200gms", 50.21, true, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 1
        ), Food(
                "Steak On The Old Way",
                "https://images.unsplash.com/photo-1573225342350-16731dd9bf3d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=957&q=80",
                "Net wt. 200gms", 50.21, true, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 1
        ), Food(
                "Cold Steak",
                "https://images.unsplash.com/photo-1547637205-fde0c9011f9d?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, true, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 1
        ), Food(
                "Steak With Wood",
                "https://images.unsplash.com/photo-1571162242324-f1607b1eceaa?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 1
        ), Food(
                "Great Steak",
                "https://images.unsplash.com/photo-1567778744680-eb44ae7aa09b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 1
        ), Food(
                "Fire Steak V2",
                "https://images.unsplash.com/photo-1558030077-82dd9347c407?ixlib=rb-1.2.1&auto=format&fit=crop&w=1189&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 1
        ), Food(
                "Chicken With Potato",
                "https://images.unsplash.com/photo-1570263495075-b8258671743f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 1
        ), Food(
                "Awesome Chicken :D",
                "https://images.unsplash.com/photo-1526743891018-fc876a01332c?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 1
        ), Food(
                "The Final Steak",
                "https://images.unsplash.com/photo-1576488489579-6967c02c56fc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 1
        )
        )
    }

    private fun getFishRecipes(): List<Food> {
        return arrayListOf(
                Food(
                        "Red Fish Collection",
                        "https://images.unsplash.com/photo-1534948216015-843149f72be3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                        "Net wt. 200gms", 50.21, true, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 4
                ), Food(
                "The Red Monster",
                "https://images.unsplash.com/photo-1551463682-189bf47449d0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=986&q=80",
                "Net wt. 200gms", 50.21, true, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 4
        ), Food(
                "Fish On The Fire",
                "https://images.unsplash.com/photo-1543738066-f1b819c5f69d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1005&q=80",
                "Net wt. 200gms", 50.21, true, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 4
        ), Food(
                "Snikky Fish :D",
                "https://images.unsplash.com/photo-1554998171-706e730d721d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, true, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 4
        ), Food(
                "Monster Collection",
                "https://images.unsplash.com/photo-1475905760530-a22eda0fb1b3?ixlib=rb-1.2.1&auto=format&fit=crop&w=1054&q=80",
                "Net wt. 200gms", 50.21, true, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", true, 4
        ), Food(
                "Red Fish At Hell",
                "https://images.unsplash.com/photo-1554371650-4484f3a102f2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 4
        ), Food(
                "The Fish Attacker",
                "https://images.unsplash.com/photo-1572943382791-571d9dd253a4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 4
        ), Food(
                "Family Dinner V1",
                "https://images.unsplash.com/photo-1569494315581-abddb8d41cfe?ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 4
        ), Food(
                "Family Dinner Fish Potato",
                "https://images.unsplash.com/photo-1568226189367-fe1122beb1dd?ixlib=rb-1.2.1&auto=format&fit=crop&w=1189&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 4
        ), Food(
                "The Final Fish",
                "https://images.unsplash.com/photo-1552334405-4929565998d5?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80",
                "Net wt. 200gms", 50.21, false, 4.5F, 20L, "100 Min", "500 gms", "The Chicken Steak", "6 - 9", false, 4
        )
        )
    }

}
