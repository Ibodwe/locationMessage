package com.example.messagebylocationapp.userinputmessage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.messagebylocationapp.component.LocationMessageEditText
import com.example.messagebylocationapp.component.LocationMessageTopBar

@Composable
fun UserInputMessageScreen(
    viewModel: UserInputMessageScreenViewModel = viewModel(),
    navigateBack: () -> Unit,
    navigateSelectLocation: () -> Unit
) {
    val uim by viewModel.uimFlow.collectAsState()

    UserInputMessageScreen(
        userInputMessageUim = uim,
        navigateBack = navigateBack,
        navigateSelectLocation = navigateSelectLocation
    )
}

@Composable
fun UserInputMessageScreen(
    userInputMessageUim: UserInputMessageUim,
    navigateBack: () -> Unit,
    navigateSelectLocation: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LocationMessageTopBar(
            uim = userInputMessageUim.topBarUim,
            navigateBack = navigateBack
        )
        Spacer(modifier = Modifier.height(30.dp))
        LocationMessageEditText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            uim = userInputMessageUim.titleTextField
        )
        Spacer(modifier = Modifier.height(30.dp))
        LocationMessageEditText(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(200.dp),
            uim = userInputMessageUim.contextTextField
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = "latitude: ${userInputMessageUim.LocationText.latitude}")
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "longitude: ${userInputMessageUim.LocationText.longitude}")
            }
            Button(onClick = navigateSelectLocation) {
                Text("메시지 남길 위치 선택하기")
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = userInputMessageUim.saveUserInputMessage
        ) {
            Text(text = "저장하기")
        }
    }
}

