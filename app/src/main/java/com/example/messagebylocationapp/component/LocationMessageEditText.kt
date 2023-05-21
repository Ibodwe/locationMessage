package com.example.messagebylocationapp.component

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


data class LocationMessageEditTextUim(
    val text: String = "",
    val placeHolderText: String = "",
    val onTextChanged: (String) -> Unit = {}
)

@Composable
fun LocationMessageEditText(
    modifier: Modifier,
    uim: LocationMessageEditTextUim,
) {
    TextField(
        modifier = modifier,
        value = uim.text,
        onValueChange = uim.onTextChanged,
        placeholder = { LocationMessagePlaceHolder(holderText = uim.placeHolderText) },
        shape = MaterialTheme.shapes.small.copy(CornerSize(20.dp)),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            textColor = MaterialTheme.colors.onSurface,
            cursorColor = MaterialTheme.colors.onSurface,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


@Composable
fun LocationMessagePlaceHolder(holderText: String) {
    Text(text = holderText)
}