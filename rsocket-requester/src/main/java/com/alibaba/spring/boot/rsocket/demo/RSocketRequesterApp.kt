package com.alibaba.spring.boot.rsocket.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * RSocket requester app
 *
 * @author leijuan
 */
@SpringBootApplication
class RSocketRequesterApp

fun main(args: Array<String>) {
    runApplication<RSocketRequesterApp>(*args)
}