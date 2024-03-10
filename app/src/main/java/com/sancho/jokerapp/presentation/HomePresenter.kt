package com.sancho.jokerapp.presentation

import android.graphics.Color
import android.os.Handler
import android.os.Looper
import com.sancho.jokerapp.data.CategoryRemoteDataSource
import com.sancho.jokerapp.data.ListCategoryCallback
import com.sancho.jokerapp.model.Category
import com.sancho.jokerapp.view.CategoryItem
import com.sancho.jokerapp.view.HomeFragment

class HomePresenter(
    private val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource
    ) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

//    fun onSuccess(response: List<Category>) {
////        val categories = mutableListOf<CategoryItem>()
////
////        for (category in response) {
////            categories.add(CategoryItem(category))
////        }
//
//        val categories = response.map{category ->
//            CategoryItem(category)
//        }

//        view.showCategories(categories)
//    }

    override fun onSuccess(response: List<String>) {
        val start = 40
        val end = 190
        val diff = (end - start) / response.size

        val categories = response.mapIndexed { index, s ->
            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                100.0f
            )
            Category(s, Color.HSVToColor(hsv).toLong())
        }
        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }


}