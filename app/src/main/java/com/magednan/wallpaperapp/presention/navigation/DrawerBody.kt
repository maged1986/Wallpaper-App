package com.magednan.wallpaperapp.presention.navigation

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import com.magednan.wallpaperapp.presention.allLisiting.AppBar
import com.magednan.wallpaperapp.presention.searchLisiting.SearchListingViewModel
import com.magednan.wallpaperapp.utils.SearchState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@SuppressLint("UnrememberedMutableState")
@ExperimentalPagingApi
@Composable
fun DrawerBody(scope: CoroutineScope,
               scaffoldState: ScaffoldState, ) {

    val navController = rememberNavController()

    val context= LocalContext.current

    val _searchState: MutableState<SearchState> = mutableStateOf(SearchState.CLOSED)
    val searchState: State<SearchState> = _searchState

    val _searchTextState: MutableState<String> = mutableStateOf("")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchState(newVal: SearchState) {
        _searchState.value = newVal
    }

    fun updateSearchTextState(newVal: String) {
        _searchTextState.value = newVal
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBar(
                searchState = searchState.value,
                searchTextState = searchTextState.value,
                onTextChange = { text ->
                    updateSearchTextState(text)
                    scope.launch {
                        delay(500)
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "query",
                            searchTextState.value
                        )
                        navController.navigate(NavDestination.SearchListing.route)
                    }
                },
                onCloseClicked = {
                    updateSearchState(SearchState.CLOSED)
                },
                onSearchClicked = {
                    Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                },
                onSearchTriggered = {
                    updateSearchState(SearchState.OPENED)
                },
                onNavIconClick = {scope.launch {
                    scaffoldState.drawerState.open()
                } }
            )
        },
        drawerContent = {
            DrawerHeader()
            DrawerMenu(listOf(
                DrawerMItem(
                    id = "pets",
                    title = "Pets",
                    icon = Icons.Default.Pets
                ),
                DrawerMItem(
                    id = "nature",
                    title = "Nature",
                    icon = Icons.Default.Nature
                ),
                DrawerMItem(
                    id = "architecture",
                    title = "Architecture",
                    icon = Icons.Default.Architecture
                ),DrawerMItem(
                    id = "business-work",
                    title = "Business & Work",
                    icon = Icons.Default.Business
                ),DrawerMItem(
                    id = "film",
                    title = "Film",
                    icon = Icons.Default.Movie
                ),DrawerMItem(
                    id = "food_drink",
                    title = "Food & Drink",
                    icon = Icons.Default.Fastfood
                ),DrawerMItem(
                    id = "health_wellness",
                    title = "Health & Wellness",
                    icon = Icons.Default.Healing
                ),DrawerMItem(
                    id = "people",
                    title = "People",
                    icon = Icons.Default.People
                ),DrawerMItem(
                    id = "travel",
                    title = "Travel",
                    icon = Icons.Default.TravelExplore
                ),
            ), onItemClick = {
                when (it.id){
                    "pets"->{navController.currentBackStackEntry?.savedStateHandle?.set("query","pets")
                        navController.navigate(NavDestination.SearchListing.route)
                        Toast.makeText(context,"pets",Toast.LENGTH_SHORT).show()}
                    "nature"->{navController.currentBackStackEntry?.savedStateHandle?.set("query","nature")
                        navController.navigate(NavDestination.SearchListing.route)
                        Toast.makeText(context,"nature",Toast.LENGTH_SHORT).show()}
                    "architecture"->{navController.currentBackStackEntry?.savedStateHandle?.set("query","architecture")
                        navController.navigate(NavDestination.SearchListing.route)
                        Toast.makeText(context,"architecture",Toast.LENGTH_SHORT).show()}
                    "business-work"->{navController.currentBackStackEntry?.savedStateHandle?.set("query","business-work")
                        navController.navigate(NavDestination.SearchListing.route)
                        Toast.makeText(context,"business&work",Toast.LENGTH_SHORT).show()}
                    "film"->{navController.currentBackStackEntry?.savedStateHandle?.set("query","film")
                        navController.navigate(NavDestination.SearchListing.route)
                        Toast.makeText(context,"Film",Toast.LENGTH_SHORT).show()}
                    "food_drink"->{navController.currentBackStackEntry?.savedStateHandle?.set("query","food_drink")
                        navController.navigate(NavDestination.SearchListing.route)
                        Toast.makeText(context,"food & drink",Toast.LENGTH_SHORT).show()}
                    "health_wellness"->{navController.currentBackStackEntry?.savedStateHandle?.set("query","health_wellness")
                        navController.navigate(NavDestination.SearchListing.route)
                        Toast.makeText(context,"health & wellness",Toast.LENGTH_SHORT).show()}
                    "people"->{navController.currentBackStackEntry?.savedStateHandle?.set("query","people")
                        navController.navigate(NavDestination.SearchListing.route)
                        Toast.makeText(context,"people",Toast.LENGTH_SHORT).show()}
                    "travel"->{navController.currentBackStackEntry?.savedStateHandle?.set("query","travel")
                        navController.navigate(NavDestination.SearchListing.route)
                        Toast.makeText(context,"travel",Toast.LENGTH_SHORT).show()}
                }
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })

        }) {
        NavGraph(navController)
    }
}

