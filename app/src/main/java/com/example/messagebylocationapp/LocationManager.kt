package com.example.messagebylocationapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Looper
import android.util.Log
import com.example.messagebylocationapp.data.UserLocationData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationAvailability
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@SuppressLint("MissingPermission")

class LocationManager(private val context: Context) {
    // flow로 lastLocation, currentLocation 실시간으로 노출 필요

    private val _locationFlow: MutableStateFlow<UserLocationData> =
        MutableStateFlow(UserLocationData())
    val locationFlow = _locationFlow.asStateFlow()


    private val fusedLocationClient: FusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    private val locationCallback: LocationCallback

    init {
        fusedLocationClient.lastLocation.addOnSuccessListener { it ->
            _locationFlow.update {
                it.copy(
                    latitude = it.latitude,
                    longitude = it.longitude
                )
            }
        }
        locationCallback = object : LocationCallback() {
            override fun onLocationAvailability(p0: LocationAvailability) {
                super.onLocationAvailability(p0)
                // TODO location이 이용 불가능 할 때 에러 메시지 error message
            }

            override fun onLocationResult(locationResult: LocationResult) {
                super.onLocationResult(locationResult)
                Log.d("updateLocation", "$locationResult")
                _locationFlow.update {
                    it.copy(
                        latitude = locationResult.lastLocation.latitude,
                        longitude = locationResult.lastLocation.longitude
                    )
                }
            }
        }
    }

    private val locationRequest = LocationRequest.create().apply {
        interval = 10000 // 위치 업데이트 간격 (10초)
        fastestInterval = 5000 // 가장 빠른 위치 업데이트 간격 (5초)
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY // 위치 업데이트 우선순위
    }

    fun startLocationUpdates() {
        Log.d("wooTest223344" , "startRequest")
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    fun stopLocationUpdates() {
        Log.d("wooTest223344" , "stopRequest")
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }
}