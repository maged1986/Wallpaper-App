package com.magednan.wallpaperapp.presention.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import com.magednan.wallpaperapp.presention.allLisiting.AllListingScreen
import com.magednan.wallpaperapp.presention.searchLisiting.SearchListingScreen

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalPagingApi
@Composable
fun NavGraph(navController:NavHostController){

    NavHost(navController = navController,
        startDestination =NavDestination.AllListing.route ){
        composable(NavDestination.AllListing.route){
          AllListingScreen(navController = navController)
        }
        composable(NavDestination.SearchListing.route){
            val item=navController.previousBackStackEntry?.savedStateHandle?.get<String>("query")
            item?.let{
                SearchListingScreen( query = item, navController =navController)}

        }
    }
}