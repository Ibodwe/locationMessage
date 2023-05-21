package com.example.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MessageLocationData(
    @PrimaryKey val uid: Long,
    @ColumnInfo(name = "messageCode") val messageCode: String,
    @ColumnInfo(name = "message_latitude") val messageLatitude: Double,
    @ColumnInfo(name = "message_longitude") val messageLongitude: Double,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "imageUrl") val image: String?
)