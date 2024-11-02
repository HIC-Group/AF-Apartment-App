package com.yunpnzr.afapartmentapp.common.screen

sealed class AppScreen(val route: String) {
    data object Login : AppScreen("login")
    data object Register : AppScreen("register")
    data object ForgetPassword : AppScreen("forget_password")

    data object Main : AppScreen("main")
}