package com.example.macy.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.macy.data.model.HealthTip

@Dao
interface HealthTipDao {
    @Insert
    suspend fun insert(tip: HealthTip)

    @Query("SELECT * FROM health_tips")
    suspend fun getAllTips(): List<HealthTip>

    @Query("SELECT * FROM health_tips WHERE tipId = :tipId")
    suspend fun getTipById(tipId: Long): HealthTip?
}