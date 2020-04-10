package com.alibaba.spring.boot.rsocket.demo.kotlin

import com.alibaba.user.UserKotlinService
import kotlinx.coroutines.flow.Flow
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

    @GetMapping("/flow")
    fun flow(): Flow<String> {
        return userKotlinService.getAllNames()
    }
}