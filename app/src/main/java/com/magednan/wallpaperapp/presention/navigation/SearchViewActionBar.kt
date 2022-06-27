package com.magednan.wallpaperapp.presention.allLisiting

import android.annotation.SuppressLint
import android.graphics.fonts.FontFamily
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily.Companion.SansSerif
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.magednan.wallpaperapp.presention.navigation.NavDestination
import com.magednan.wallpaperapp.utils.SearchState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.primary
    ) {
        TextField(
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            modifier = Modifier
                .fillMaxWidth(),
            placeholder = {
                Text(
                    text = "Search here...",
                    color = Color.White,
                    modifier = Modifier.alpha(ContentAlpha.medium)
                )
            },
            textStyle = TextStyle(
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = { },
                    modifier = Modifier.alpha(ContentAlpha.medium)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "SearchImage",
                        tint = Color.White
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        if (text.isNotEmpty()) {
                            onTextChange("")
                        } else {
                            onCloseClicked()
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close Image",
                        tint = Color.White
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                cursorColor = Color.White.copy(alpha = ContentAlpha.medium)
            )
        )
    }
}

@Composable
fun DefaultAppBar(
    onSearchClicked: () -> Unit,
    onNavIconClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(text = "")
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = {onNavIconClick()}) {
                Icon(Icons.Filled.Menu,
                    contentDescription = "NavigationMenu")
            }
        },
        actions = {
            IconButton(onClick = { onSearchClicked() }) {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search Image",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun AppBar(
    searchState: SearchState,
    searchTextState: String,
    onTextChange: (String) -> Unit,
    onCloseClicked: () -> Unit,
    onSearchClicked: (String) -> Unit,
    onSearchTriggered: () -> Unit,
    onNavIconClick: () -> Unit,
) {
    when (searchState) {
        SearchState.CLOSED -> {
            DefaultAppBar(
                onSearchClicked = onSearchTriggered,
                onNavIconClick=onNavIconClick,

            )
        }
        SearchState.OPENED -> {
            SearchAppBar(
                text = searchTextState,
                onTextChange = onTextChange,
                onCloseClicked = onCloseClicked,
                onSearchClicked = onSearchClicked
            )
        }
    }
}

