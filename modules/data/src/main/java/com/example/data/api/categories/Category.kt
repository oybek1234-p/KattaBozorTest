package com.example.data.api.categories

// categories пакет для пример,так как техническом задание нет,
// в актуальном проекте может быть по другому; Например в Каттабазаре

data class Category(val name: String) {

    companion object {
        const val mainCategory = "mainName"
    }

    fun isMainCategory() = name == mainCategory
}
