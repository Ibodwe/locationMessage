package com.example.messagebylocationapp.map.floatingbutton

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable

@Composable
fun MessageFloatingButton(
    onClickFloatingButton: () -> Unit
) {
    FloatingActionButton(
        onClick = onClickFloatingButton,
        contentColor = contentColorFor(MaterialTheme.colors.primary),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            Icons.Filled.Add,
            contentDescription = null,
            tint = MaterialTheme.colors.onPrimary
        )
    }
}