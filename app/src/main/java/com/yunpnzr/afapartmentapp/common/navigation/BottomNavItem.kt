package com.yunpnzr.afapartmentapp.common.navigation

import com.yunpnzr.afapartmentapp.R

sealed class BottomNavItem(val route: String, val icon: Int, val title: String){
    data object Home : BottomNavItem(
        route = "home",
        icon = R.drawable.ic_home,
        title = "Home"
    )
    data object History : BottomNavItem(
        route = "history",
        icon = R.drawable.ic_history,
        title = "History"
    )
    data object Messages : BottomNavItem(
        route = "messages",
        icon = R.drawable.ic_messages,
        title = "Messages"
    )
    data object Profile : BottomNavItem(
        route = "profile",
        icon = R.drawable.ic_person,
        title = "Profile"
    )
}