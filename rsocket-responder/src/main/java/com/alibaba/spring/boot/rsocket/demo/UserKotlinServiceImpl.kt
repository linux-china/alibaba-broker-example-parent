package com.alibaba.spring.boot.rsocket.demo

import com.alibaba.rsocket.RSocketService
import com.alibaba.user.UserKotlinService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Service

/**
 * User Kotlin Service implementation
 *
 * @author linux_china
 */
@Service
@RSocketService(serviceInterface = UserKotlinService::class)
class UserKotlinServiceImpl : UserKotlinService {
    override suspend fun getOwner(): String {
        return "leijuan"
    }

    override suspend fun getNickById(id: Int): String {
        return "nick: $id"
    }

    override fun getAllNames(): Flow<String> {
        return arrayOf("first", "second").asFlow()
    }

    override fun findNamesByType(type: Int): Flow<String> {
        return arrayOf("first", "second", "type: $type").asFlow();
    }
}