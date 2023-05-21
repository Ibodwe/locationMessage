package com.example.messagebylocationapp.map

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.example.messagebylocationapp.R
import com.example.messagebylocationapp.databinding.LocationMessageMarkerBinding
import net.daum.mf.map.api.CalloutBalloonAdapter
import net.daum.mf.map.api.MapPOIItem

class LocationMessageBalloon(context: Context) : CalloutBalloonAdapter {

    private val locationMessageMarkerBalloonBinding : LocationMessageMarkerBinding

    init {
        locationMessageMarkerBalloonBinding = LocationMessageMarkerBinding.inflate(LayoutInflater.from(context), null,false)
    }

    override fun getCalloutBalloon(poiItem: MapPOIItem): View {
        locationMessageMarkerBalloonBinding.title.text = poiItem.itemName
        return locationMessageMarkerBalloonBinding.root
    }

    // message 가 pressed 되었을 때
    override fun getPressedCalloutBalloon(poiItem: MapPOIItem): View? {
        return null
    }
}