package com.magednan.wallpaperapp.presention.navigation

sealed class NavDestination( val route:String){
    object AllListing:NavDestination("AllListing")
    object SearchListing:NavDestination("SearchListing")
}
