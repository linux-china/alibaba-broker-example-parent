package com.alibaba.spring.boot.rsocket.demo

import com.alibaba.rsocket.RSocketService
import com.alibaba.user.UserKotlinService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Service

/**
 * User Kotlin Service implementation
 *
 * @author linux_china
 */
@Service
@RSocketService(serviceInterface = UserKotlinService::class)
class UserKotlinServiceImpl : UserKotlinService {
    override suspend fun job1() {
        println("job1")
    }

    override suspend fun getNickById(id: Int): String {
        return "nick: $id"
    }

    override fun findNamesByType(type: Int): Flow<String> {
        return arrayOf("first", "second", "type: $type").asFlow();
    }

    override fun findNamesByIdFlow(idFlow: Flow<Int>): Flow<String> {
        return idFlow.map {
            "nick: $it"
        }
    }
}