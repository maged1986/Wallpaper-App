package com.magednan.wallpaperapp.presention.allLisiting

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import com.magednan.wallpaperapp.presention.navigation.*
import com.magednan.wallpaperapp.presention.rvItem.RvItem
import com.magednan.wallpaperapp.utils.SearchState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState")
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@ExperimentalPagingApi
@Composable
fun AllListingScreen(navController: NavHostController,
                     homeViewModel: AllListingViewModel = hiltViewModel()
) {
    val getAllImages = homeViewModel.getAllImages.collectAsLazyPagingItems()
    val scope = rememberCoroutineScope()
  //  val scaffoldState = rememberScaffoldState()
 /*   val context= LocalContext.current

    val _searchState: MutableState<SearchState> = mutableStateOf(SearchState.CLOSED)
    val searchState: State<SearchState> = _searchState

    val _searchTextState: MutableState<String> = mutableStateOf("")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchState(newVal: SearchState) {
        _searchState.value = newVal
    }

    fun updateSearchTextState(newVal: String) {
        _searchTextState.value = newVal
    }*/


    /*Scaffold(
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
                   }
               )
           *//*DrawerAppBar(
                onSearchClicked = {
                    navController.navigate(NavDestination.SearchListing.route)
                }, onNavIconClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }

                }
            )*//*
        },
        content = {
            RvItem(items = getAllImages)
        },
        drawerContent = {
            DrawerHeader()
          

        }
    )*/
    Column(Modifier.fillMaxWidth()) {
        RvItem(items = getAllImages)
    }

}