package com.alibaba.user

import kotlinx.coroutines.flow.Flow

/**
 * User Kotlin Service
 *
 * @author linux_china
 */
interface UserKotlinService {
    suspend fun getOwner(): String

    suspend fun getNickById(id: Int): String

    fun getAllNames(): Flow<String>

    fun findNamesByType(type: Int): Flow<String>

}