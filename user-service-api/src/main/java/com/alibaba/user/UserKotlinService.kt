package com.alibaba.user

import kotlinx.coroutines.flow.Flow

/**
 * User Kotlin Service
 *
 * @author linux_china
 */
interface UserKotlinService {
    //FNF
    suspend fun job1()

    //Request/Response
    suspend fun getNickById(id: Int): String

    //Request/Stream
    fun findNamesByType(type: Int): Flow<String>

    //channel
    fun findNamesByIdFlow(idFlow: Flow<Int>): Flow<String>
}