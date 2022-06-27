package com.magednan.wallpaperapp.presention

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.paging.ExperimentalPagingApi
import com.magednan.wallpaperapp.presention.navigation.DrawerBody
import com.magednan.wallpaperapp.presention.theme.WallpaperAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    @ExperimentalAnimationApi
    @ExperimentalPagingApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WallpaperAppTheme {
                val scope= rememberCoroutineScope()
                val scaffoldState= rememberScaffoldState()
                DrawerBody(scaffoldState = scaffoldState, scope = scope)
            }
        }
    }
}
