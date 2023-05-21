package com.example.messagebylocationapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.messagebylocationapp.R

data class LocationMessageTopBarUim(
    val topBarTitle: String = ""
)

@Composable
fun LocationMessageTopBar(
    uim: LocationMessageTopBarUim,
    navigateBack: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            modifier = Modifier
                .padding(10.dp)
                .clickable { navigateBack.invoke() },
            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
            contentDescription = ""
        )
        Text(
            text = uim.topBarTitle
        )
        Spacer(modifier = Modifier)
    }
}