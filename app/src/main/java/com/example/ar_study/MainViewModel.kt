package com.example.ar_study

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ar_study.models.Category
import com.example.ar_study.models.Topic
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

):ViewModel() {
    private val _isReady = MutableStateFlow(false)
    val isReady  = _isReady.asStateFlow()

    init{
        viewModelScope.launch {
            delay(2000L)
            _isReady.value = true
        }
    }
    val Topics = mutableStateOf(
        listOf<Topic>(
            Topic(
                topicName = "Jet Turbine",
                desc = "A jet turbine engine, commonly known as a gas turbine engine, is a type of internal combustion engine that converts fuel into mechanical energy by igniting fuel-air mixtures in a combustion chamber. The resulting high-pressure, high-temperature gases are directed through a series of turbines, which are connected to a shaft. As the gases pass through the turbines, they spin the shaft, which drives various components such as compressors, fans, or generators, depending on the application. \nIn the context of aviation, jet turbine engines are commonly used in jet aircraft to provide thrust for propulsion. These engines are highly efficient and capable of generating significant amounts of power, allowing aircraft to travel at high speeds and altitudes.\n" +
                        "\nIn summary, a jet turbine engine is a type of gas turbine engine used in various applications, including aircraft propulsion and power generation, to convert fuel into mechanical energy",
                image = R.drawable.jetturbine,
                category = "Machinery",
                packageName = "com.Meehtan.JetTurbine",
                stars =4.0,
            ),
            Topic(
                topicName = "Jet Turbine",
                desc = "A jet turbine engine, commonly known as a gas turbine engine, is a type of internal combustion engine that converts fuel into mechanical energy by igniting fuel-air mixtures in a combustion chamber. The resulting high-pressure, high-temperature gases are directed through a series of turbines, which are connected to a shaft. As the gases pass through the turbines, they spin the shaft, which drives various components such as compressors, fans, or generators, depending on the application. \nIn the context of aviation, jet turbine engines are commonly used in jet aircraft to provide thrust for propulsion. These engines are highly efficient and capable of generating significant amounts of power, allowing aircraft to travel at high speeds and altitudes.\n" +
                        "\nIn summary, a jet turbine engine is a type of gas turbine engine used in various applications, including aircraft propulsion and power generation, to convert fuel into mechanical energy",
                image = R.drawable.jetturbine,
                packageName = "com.Meehtan.JetTurbine",
                category = "Machinery",
                stars = 3.0,
            ),
            Topic(
                topicName = "Jet Turbine",
                desc = "A jet turbine engine, commonly known as a gas turbine engine, is a type of internal combustion engine that converts fuel into mechanical energy by igniting fuel-air mixtures in a combustion chamber. The resulting high-pressure, high-temperature gases are directed through a series of turbines, which are connected to a shaft. As the gases pass through the turbines, they spin the shaft, which drives various components such as compressors, fans, or generators, depending on the application. \nIn the context of aviation, jet turbine engines are commonly used in jet aircraft to provide thrust for propulsion. These engines are highly efficient and capable of generating significant amounts of power, allowing aircraft to travel at high speeds and altitudes.\n" +
                        "\nIn summary, a jet turbine engine is a type of gas turbine engine used in various applications, including aircraft propulsion and power generation, to convert fuel into mechanical energy",
                image = R.drawable.jetturbine,
                category = "Machinery",
                packageName = "com.Meehtan.JetTurbine",
                stars = 3.0,
            ),
            Topic(
                topicName = "Heart",
                desc = "The heart is a muscular organ responsible for pumping blood throughout the body, supplying oxygen and nutrients to tissues and organs and removing waste products. It is a vital component of the circulatory system, which is essential for maintaining the body's overall health and function.The human heart is located in the chest cavity, slightly left of the center, behind and slightly to the left of the sternum (breastbone). The heart functions as a double pump, with each side working simultaneously but independently. The right side pumps blood through the pulmonary circulation, while the left side pumps blood through the systemic circulation.Heart diseases are among the leading causes of death worldwide and can result from various factors, including genetics, lifestyle choices, and underlying medical conditions." +
                        "\nOverall, the heart is a vital organ essential for maintaining the body's overall health and function, and understanding its anatomy, physiology, and pathology is crucial for healthcare professionals and researchers.",
                image = R.drawable.heart,
                category = "Physiology",
                stars = 4.0,
                packageName = "com.DefaultCompany.AR_STUDY",
                marker = R.drawable.onboarding3
            ),
            Topic(
                topicName = "Heart",
                desc = "The heart is a muscular organ responsible for pumping blood throughout the body, supplying oxygen and nutrients to tissues and organs and removing waste products. It is a vital component of the circulatory system, which is essential for maintaining the body's overall health and function.The human heart is located in the chest cavity, slightly left of the center, behind and slightly to the left of the sternum (breastbone). The heart functions as a double pump, with each side working simultaneously but independently. The right side pumps blood through the pulmonary circulation, while the left side pumps blood through the systemic circulation.Heart diseases are among the leading causes of death worldwide and can result from various factors, including genetics, lifestyle choices, and underlying medical conditions." +
                        "\nOverall, the heart is a vital organ essential for maintaining the body's overall health and function, and understanding its anatomy, physiology, and pathology is crucial for healthcare professionals and researchers.",
                image = R.drawable.heart,
                category = "Physiology",
                stars = 5.0,
                packageName = "com.DefaultCompany.AR_STUDY",
                marker = R.drawable.onboarding3
            ),
            Topic(
                topicName = "Heart",
                desc = "The heart is a muscular organ responsible for pumping blood throughout the body, supplying oxygen and nutrients to tissues and organs and removing waste products. It is a vital component of the circulatory system, which is essential for maintaining the body's overall health and function.The human heart is located in the chest cavity, slightly left of the center, behind and slightly to the left of the sternum (breastbone). The heart functions as a double pump, with each side working simultaneously but independently. The right side pumps blood through the pulmonary circulation, while the left side pumps blood through the systemic circulation.Heart diseases are among the leading causes of death worldwide and can result from various factors, including genetics, lifestyle choices, and underlying medical conditions." +
                        "\nOverall, the heart is a vital organ essential for maintaining the body's overall health and function, and understanding its anatomy, physiology, and pathology is crucial for healthcare professionals and researchers.",
                image = R.drawable.heart,
                category = "Physiology",
                stars = 2.0,
                packageName = "com.DefaultCompany.AR_STUDY",
                marker = R.drawable.onboarding3
            ),
        )
    )

    val Categories = mutableStateOf(
        listOf<Category>(
            Category(
                categoryName = "Machinery",
                coverImage = R.drawable.machinery,
                topics = listOf(
                    Topic(
                        topicName = "Jet Turbine",
                        desc = "A jet turbine engine, commonly known as a gas turbine engine, is a type of internal combustion engine that converts fuel into mechanical energy by igniting fuel-air mixtures in a combustion chamber. The resulting high-pressure, high-temperature gases are directed through a series of turbines, which are connected to a shaft. As the gases pass through the turbines, they spin the shaft, which drives various components such as compressors, fans, or generators, depending on the application. \nIn the context of aviation, jet turbine engines are commonly used in jet aircraft to provide thrust for propulsion. These engines are highly efficient and capable of generating significant amounts of power, allowing aircraft to travel at high speeds and altitudes.\n" +
                                "\nIn summary, a jet turbine engine is a type of gas turbine engine used in various applications, including aircraft propulsion and power generation, to convert fuel into mechanical energy",
                        image = R.drawable.jetturbine,
                        category = "Machinery",
                        packageName = "com.Meehtan.JetTurbine",
                        stars =4.0,
                    ),
                    Topic(
                        topicName = "Jet Turbine",
                        desc = "A jet turbine engine, commonly known as a gas turbine engine, is a type of internal combustion engine that converts fuel into mechanical energy by igniting fuel-air mixtures in a combustion chamber. The resulting high-pressure, high-temperature gases are directed through a series of turbines, which are connected to a shaft. As the gases pass through the turbines, they spin the shaft, which drives various components such as compressors, fans, or generators, depending on the application. \nIn the context of aviation, jet turbine engines are commonly used in jet aircraft to provide thrust for propulsion. These engines are highly efficient and capable of generating significant amounts of power, allowing aircraft to travel at high speeds and altitudes.\n" +
                                "\nIn summary, a jet turbine engine is a type of gas turbine engine used in various applications, including aircraft propulsion and power generation, to convert fuel into mechanical energy",
                        image = R.drawable.jetturbine,
                        packageName = "com.Meehtan.JetTurbine",
                        category = "Machinery",
                        stars = 3.0,
                    ),
                    Topic(
                        topicName = "Jet Turbine",
                        desc = "A jet turbine engine, commonly known as a gas turbine engine, is a type of internal combustion engine that converts fuel into mechanical energy by igniting fuel-air mixtures in a combustion chamber. The resulting high-pressure, high-temperature gases are directed through a series of turbines, which are connected to a shaft. As the gases pass through the turbines, they spin the shaft, which drives various components such as compressors, fans, or generators, depending on the application. \nIn the context of aviation, jet turbine engines are commonly used in jet aircraft to provide thrust for propulsion. These engines are highly efficient and capable of generating significant amounts of power, allowing aircraft to travel at high speeds and altitudes.\n" +
                                "\nIn summary, a jet turbine engine is a type of gas turbine engine used in various applications, including aircraft propulsion and power generation, to convert fuel into mechanical energy",
                        image = R.drawable.jetturbine,
                        category = "Machinery",
                        packageName = "com.Meehtan.JetTurbine",
                        stars = 3.0,
                    ),
                )
            ),
            Category(
                categoryName = "Physiology",
                coverImage = R.drawable.physiology,
                topics = listOf(
                    Topic(
                        topicName = "Heart",
                        desc = "The heart is a muscular organ responsible for pumping blood throughout the body, supplying oxygen and nutrients to tissues and organs and removing waste products. It is a vital component of the circulatory system, which is essential for maintaining the body's overall health and function.The human heart is located in the chest cavity, slightly left of the center, behind and slightly to the left of the sternum (breastbone). The heart functions as a double pump, with each side working simultaneously but independently. The right side pumps blood through the pulmonary circulation, while the left side pumps blood through the systemic circulation.Heart diseases are among the leading causes of death worldwide and can result from various factors, including genetics, lifestyle choices, and underlying medical conditions." +
                                "\nOverall, the heart is a vital organ essential for maintaining the body's overall health and function, and understanding its anatomy, physiology, and pathology is crucial for healthcare professionals and researchers.",
                        image = R.drawable.heart,
                        category = "Physiology",
                        stars = 4.0,
                        packageName = "com.DefaultCompany.AR_STUDY",
                        marker = R.drawable.onboarding3
                    ),
                    Topic(
                        topicName = "Heart",
                        desc = "The heart is a muscular organ responsible for pumping blood throughout the body, supplying oxygen and nutrients to tissues and organs and removing waste products. It is a vital component of the circulatory system, which is essential for maintaining the body's overall health and function.The human heart is located in the chest cavity, slightly left of the center, behind and slightly to the left of the sternum (breastbone). The heart functions as a double pump, with each side working simultaneously but independently. The right side pumps blood through the pulmonary circulation, while the left side pumps blood through the systemic circulation.Heart diseases are among the leading causes of death worldwide and can result from various factors, including genetics, lifestyle choices, and underlying medical conditions." +
                                "\nOverall, the heart is a vital organ essential for maintaining the body's overall health and function, and understanding its anatomy, physiology, and pathology is crucial for healthcare professionals and researchers.",
                        image = R.drawable.heart,
                        category = "Physiology",
                        stars = 5.0,
                        packageName = "com.DefaultCompany.AR_STUDY",
                        marker = R.drawable.onboarding3
                    ),
                    Topic(
                        topicName = "Heart",
                        desc = "The heart is a muscular organ responsible for pumping blood throughout the body, supplying oxygen and nutrients to tissues and organs and removing waste products. It is a vital component of the circulatory system, which is essential for maintaining the body's overall health and function.The human heart is located in the chest cavity, slightly left of the center, behind and slightly to the left of the sternum (breastbone). The heart functions as a double pump, with each side working simultaneously but independently. The right side pumps blood through the pulmonary circulation, while the left side pumps blood through the systemic circulation.Heart diseases are among the leading causes of death worldwide and can result from various factors, including genetics, lifestyle choices, and underlying medical conditions." +
                                "\nOverall, the heart is a vital organ essential for maintaining the body's overall health and function, and understanding its anatomy, physiology, and pathology is crucial for healthcare professionals and researchers.",
                        image = R.drawable.heart,
                        category = "Physiology",
                        stars = 2.0,
                        packageName = "com.DefaultCompany.AR_STUDY",
                        marker = R.drawable.onboarding3
                    ),
                )
            ),
        )

    )
    var isSearchStarting = true
    var topicCachedList = listOf<Topic>()
    var categoryCachedList = listOf<Category>()

    var isSearching = mutableStateOf(false)
    fun reloadList(){
        if(topicCachedList.isNotEmpty()) {
            Topics.value = topicCachedList
        }
        if(categoryCachedList.isNotEmpty()) {
            Categories.value = categoryCachedList
        }
    }

    fun searchList(query: String) {
        val topicListToSearch = if (isSearchStarting) {
            Topics.value
        } else {
            topicCachedList
        }
        val categoryListToSearch = if (isSearchStarting) {
            Categories.value
        } else {
            categoryCachedList
        }
        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                Topics.value = topicCachedList
                Categories.value = categoryCachedList
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }
            val topicResults = topicListToSearch.filter {
                it.topicName.contains(query, ignoreCase = true)
            }
            val categoryResults = categoryListToSearch.filter {
                it.categoryName.contains(query, ignoreCase = true)
            }
            if (isSearchStarting) {
                topicCachedList = Topics.value
                categoryCachedList = Categories.value
                isSearchStarting = false

            }
            Topics.value = topicResults
            Categories.value = categoryResults
            isSearching.value = true
        }

    }
}