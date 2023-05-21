package com.example.messagebylocationapp.map

import android.annotation.SuppressLint
import android.widget.RelativeLayout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.messagebylocationapp.LocationManager
import com.example.messagebylocationapp.MarkerManager
import com.example.messagebylocationapp.data.UserLocationData
import com.example.messagebylocationapp.data.toKakaoMapPoint
import com.example.messagebylocationapp.map.floatingbutton.MessageFloatingButton
import net.daum.mf.map.api.MapView

// android viewModel context로 이용하는건 어떤가?

@Composable
fun MapScreen(
    locationManager: LocationManager,
    viewModel: MapScreenViewModel,
    navigateMessageInputScreen: () -> Unit
) {

    val userLocation by locationManager.locationFlow.collectAsState()

    MapScreen(
        userLocationData = userLocation,
        onClickFloatingButton = navigateMessageInputScreen
    )

    DisposableEffect(key1 = Unit) {
        onDispose {

        }
    }

}


@SuppressLint("MissingPermission", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MapScreen(
    userLocationData: UserLocationData,
    onClickFloatingButton: () -> Unit
) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = { MessageFloatingButton(onClickFloatingButton) }
    ) {

        // mapView를 어디에서 destory 해야하나~
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                RelativeLayout(context).apply {
                     val mapView = MapView(context)
                    this.addView(mapView)
                    mapView.setZoomLevel(1, true)

                    mapView.setCalloutBalloonAdapter(LocationMessageBalloon(context = context))
                    mapView.setMapCenterPoint(userLocationData.toKakaoMapPoint(), true)
                    mapView.currentLocationTrackingMode =
                        MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeading
                    val markerManager = MarkerManager(mapView)
                    markerManager.init()

                }
            }
        )
    }
}