package com.example.messagebylocationapp

import android.graphics.Color
import android.util.Log
import net.daum.mf.map.api.MapCircle
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

class MarkerManager(private val mapView: MapView) {

    fun init() {
        mapView.setPOIItemEventListener(object : MapView.POIItemEventListener {
            override fun onCalloutBalloonOfPOIItemTouched(
                p0: MapView?,
                p1: MapPOIItem?,
                p2: MapPOIItem.CalloutBalloonButtonType?
            ) {
                Log.d("test223344", "markerTouched")
            }

            override fun onDraggablePOIItemMoved(
                p0: MapView?,
                p1: MapPOIItem?,
                p2: MapPoint?
            ) {
                Log.d("test223344", "markerTouched")
            }

            override fun onPOIItemSelected(p0: MapView?, p1: MapPOIItem?) {
                Log.d("test223344", "markerTouched")
            }

            override fun onCalloutBalloonOfPOIItemTouched(
                p0: MapView?,
                p1: MapPOIItem?
            ) {
                Log.d("test223344", "markerTouched")
            }
        }
        )
    }

    fun addMarker() {
        val customMarker = MapPOIItem()
        customMarker.itemName = "Default Marker"
        customMarker.tag = 1
        customMarker.markerType = MapPOIItem.MarkerType.CustomImage
        mapView.selectPOIItem(customMarker, true)
        mapView.addPOIItem(customMarker)
    }
}