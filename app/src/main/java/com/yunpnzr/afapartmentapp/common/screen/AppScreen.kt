package com.yunpnzr.afapartmentapp.common.screen

sealed class AppScreen(route: String) {
    data object Login : AppScreen("login")
    data object Register : AppScreen("register")
    data object Main : AppScreen("main")
}