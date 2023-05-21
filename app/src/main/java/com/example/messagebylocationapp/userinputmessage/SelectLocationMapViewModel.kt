package com.example.messagebylocationapp.userinputmessage

import androidx.lifecycle.ViewModel
import com.example.messagebylocationapp.data.LocationMessageUser
import com.example.messagebylocationapp.data.UserLocationData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SelectLocationMapViewModel : ViewModel() {
    private val _uimFlow: MutableStateFlow<SelectLocationMapUim> =
        MutableStateFlow(createUim())
    val uimFlow = _uimFlow.asStateFlow()

    private fun createUim() = SelectLocationMapUim(
        userLocationData = UserLocationData(
            LocationMessageUser.userLocationData.latitude,
            LocationMessageUser.userLocationData.longitude
        ),
        updateMapLocationData = { selectedMapItem ->
            _uimFlow.update {
                it.copy(
                    selectedMapItemData = selectedMapItem
                )
            }
        }
    )
}

data class SelectLocationMapUim(
    val userLocationData: UserLocationData = UserLocationData(),
    val selectedMapItemData: SelectedMapItem = SelectedMapItem(),
    val updateMapLocationData: (SelectedMapItem) -> Unit
)

data class SelectedMapItem(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val displayName: String = "위도와 경도가 선택 되지 않았습니다."
)