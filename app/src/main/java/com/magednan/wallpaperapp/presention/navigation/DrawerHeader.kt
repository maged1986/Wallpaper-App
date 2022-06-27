package com.magednan.wallpaperapp.presention.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.magednan.wallpaperapp.R

@Composable
fun DrawerHeader() {

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 64.dp),
    contentAlignment = Alignment.Center){
        Text(text = "Category")
    }
}