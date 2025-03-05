package com.example.macy

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HealthTipDao {
    @Insert
    suspend fun insert(tip: HealthTip)

    @Query("SELECT * FROM health_tips")
    suspend fun getAllTips(): List<HealthTip>

    @Query("SELECT * FROM health_tips WHERE tipId = :tipId")
    suspend fun getTipById(tipId: Long): HealthTip?
}