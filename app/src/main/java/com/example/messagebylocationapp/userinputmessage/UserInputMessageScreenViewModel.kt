package com.example.messagebylocationapp.userinputmessage

import androidx.lifecycle.ViewModel
import com.example.messagebylocationapp.component.LocationMessageEditTextUim
import com.example.messagebylocationapp.component.LocationMessageTopBarUim
import com.example.messagebylocationapp.data.UserLocationData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserInputMessageScreenViewModel : ViewModel() {
    private val _uimFlow: MutableStateFlow<UserInputMessageUim> = MutableStateFlow(createUim())
    val uimFlow = _uimFlow.asStateFlow()


    private fun createUim() = UserInputMessageUim(
        topBarUim = LocationMessageTopBarUim(
            topBarTitle = "사용자 입력 화면"
        ),
        titleTextField = LocationMessageEditTextUim(
            onTextChanged = { newTitleText ->
                _uimFlow.update {
                    it.copy(
                        titleTextField = it.titleTextField.copy(text = newTitleText)
                    )
                }
            },
            placeHolderText = "메시지 제목을 입력해주세요."
        ),
        contextTextField = LocationMessageEditTextUim(
            onTextChanged = { newTitleText ->
                _uimFlow.update {
                    it.copy(
                        titleTextField = it.contextTextField.copy(text = newTitleText)
                    )
                }
            },
            placeHolderText = "메시지 내용을 입력해주세요."
        ),
    )
}


// 캡슐화 하게 되니 업데이트가 불편한 문제가 있네
data class UserInputMessageUim(
    val topBarUim: LocationMessageTopBarUim = LocationMessageTopBarUim(),
    val titleTextField: LocationMessageEditTextUim = LocationMessageEditTextUim(
        placeHolderText = "메시지의 제목을 입력해주세요.",
    ),
    val contextTextField: LocationMessageEditTextUim = LocationMessageEditTextUim(
        placeHolderText = "메시지의 내용을 입력해주세요."
    ),
    val LocationText: UserLocationData = UserLocationData(),
    val saveUserInputMessage: () -> Unit = {}
)


