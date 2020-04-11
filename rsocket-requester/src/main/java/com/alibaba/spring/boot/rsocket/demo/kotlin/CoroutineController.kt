package com.alibaba.spring.boot.rsocket.demo.kotlin

import com.alibaba.user.UserKotlinService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * coroutines controller
 *
 * @author linux_china
 */
@RestController
@RequestMapping("/kt")
class CoroutineController {
    @Autowired
    private lateinit var userKotlinService: UserKotlinService;

    @GetMapping("/hello")
    suspend fun hello(): String {
        return "Hello " + userKotlinService.getNickById(1)
    }

    @GetMapping("/stream1")
    fun stream1(): Flow<String> {
        return userKotlinService.findNamesByType(1)
    }

    @GetMapping("/channel1")
    fun channel1(): Flow<String> {
        return userKotlinService.findNamesByIdFlow(arrayOf(1, 2).asFlow())
    }
}