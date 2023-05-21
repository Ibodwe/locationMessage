package com.example.messagebylocationapp.userinputmessage

import android.annotation.SuppressLint
import android.widget.RelativeLayout
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.messagebylocationapp.data.toKakaoMapPoint
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

@Composable
fun SelectLocationMapScreen(
    viewModel: SelectLocationMapViewModel = viewModel(),
    clickSaveBtn: () -> Unit
) {

    val uim by viewModel.uimFlow.collectAsState()
    SelectLocationMapScreen(
        uim = uim,
        clickSaveBtn = clickSaveBtn
    )
}

@SuppressLint("MissingPermission", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelectLocationMapScreen(
    uim: SelectLocationMapUim,
    clickSaveBtn: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = { }
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            AndroidView(
                modifier = Modifier
                    .weight(1f)
                    .height(500.dp),
                factory = { context ->
                    RelativeLayout(context).apply {
                        val mapView = MapView(context)
                        this.addView(mapView)
                        mapView.setZoomLevel(1, true)
                        mapView.setMapCenterPoint(uim.userLocationData.toKakaoMapPoint(), false)
                        mapView.setMapViewEventListener(object : MapView.MapViewEventListener {
                            override fun onMapViewInitialized(p0: MapView?) {}

                            override fun onMapViewCenterPointMoved(p0: MapView?, p1: MapPoint?) {}

                            override fun onMapViewZoomLevelChanged(p0: MapView?, p1: Int) {}

                            override fun onMapViewSingleTapped(
                                mapView: MapView?,
                                mapPoint: MapPoint?
                            ) {
                                val selectedMapItem = SelectedMapItem(
                                    latitude = mapPoint?.mapPointScreenLocation?.x ?: 0.0,
                                    longitude = mapPoint?.mapPointScreenLocation?.y ?: 0.0,
                                    displayName = mapView?.display?.name ?: ""
                                )
                                uim.updateMapLocationData.invoke(selectedMapItem)
                            }

                            override fun onMapViewDoubleTapped(p0: MapView?, p1: MapPoint?) {}

                            override fun onMapViewLongPressed(p0: MapView?, p1: MapPoint?) {}

                            override fun onMapViewDragStarted(p0: MapView?, p1: MapPoint?) {}

                            override fun onMapViewDragEnded(p0: MapView?, p1: MapPoint?) {}

                            override fun onMapViewMoveFinished(p0: MapView?, p1: MapPoint?) {}
                        })
                        // click Event 받아서 위도 경도 지명 이름 알려주기
                    }
                }
            )
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "selected Latitude")
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "selected longitude")
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "selected address")
                Spacer(modifier = Modifier.height(15.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = clickSaveBtn
                ) {
                    Text(
                        text = "save"
                    )
                }
            }
        }
    }
}