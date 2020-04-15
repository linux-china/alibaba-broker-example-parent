package com.alibaba.user

import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.Serializable

@Serializable
data class KotlinUser(val id: Int, val nick: String, val email: String, val phone: String)

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

    suspend fun findUserById(id: Int): KotlinUser

    //Request/Stream
    fun findNamesByType(type: Int): Flow<String>

    //channel
    fun findNamesByIdFlow(idFlow: Flow<Int>): Flow<String>
}