package com.example.messagebylocationapp.route

// 캡슐화 나중에 해보자
sealed class NavigationRoute {
    val route = "route${javaClass.simpleName}"
    val destination = "destination${javaClass.simpleName}"

    object Map : NavigationRoute()
    object InputUserMessage : NavigationRoute()
    object LocationSelectMap: NavigationRoute()

}