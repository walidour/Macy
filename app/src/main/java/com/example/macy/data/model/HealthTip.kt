package com.example.macy.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "health_tips")
data class HealthTip(
    @PrimaryKey(autoGenerate = true) val tipId: Long = 0,
    val title: String,
    val content: String,
    val imageUrl: String
)