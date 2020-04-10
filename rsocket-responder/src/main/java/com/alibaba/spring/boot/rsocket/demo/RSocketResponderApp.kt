package com.alibaba.spring.boot.rsocket.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * RSocket Responder App
 *
 * @author leijuan
 */
@SpringBootApplication
class RSocketResponderApp

fun main(args: Array<String>) {
    runApplication<RSocketResponderApp>(*args)
}