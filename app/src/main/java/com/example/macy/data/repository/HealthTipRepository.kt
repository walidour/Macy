package com.example.macy.data.repository

import com.example.macy.data.local.HealthTipDao
import com.example.macy.data.model.HealthTip

class HealthTipRepository(private val healthTipDao: HealthTipDao) {
    suspend fun getAllTips(): List<HealthTip> = healthTipDao.getAllTips()
    suspend fun getTipById(tipId: Long): HealthTip? = healthTipDao.getTipById(tipId)
}