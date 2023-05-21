package com.example.messagebylocationapp.data

import net.daum.mf.map.api.MapPoint

object LocationMessageUser {
    val userLocationData = UserLocationData()
}


data class UserLocationData(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0
)

fun UserLocationData.toKakaoMapPoint() = MapPoint.mapPointWithGeoCoord(latitude, longitude)