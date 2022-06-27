package com.magednan.wallpaperapp.presention.searchLisiting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.magednan.wallpaperapp.presention.rvItem.RvItem

@ExperimentalPagingApi
@ExperimentalCoilApi
@Composable
fun SearchListingScreen(
    query: String,
    navController: NavHostController,
    searchViewModel: SearchListingViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery
    val searchedImages = searchViewModel.searchedImages.collectAsLazyPagingItems()
    val context = LocalContext.current

    if (!query.isNullOrEmpty()) {
        searchViewModel.searchHeroes(query)
        Column(Modifier.fillMaxSize()) {
            RvItem(items = searchedImages)
        }
    } else {
    }

}

