package com.example.demo

import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
class HealthController {
    @GetMapping("/health")
    fun healthCheck() = "ok"
}

@RestController
class IpController {
    @GetMapping("/ip")
    fun getIpAddress(request: HttpServletRequest) = getIp(request)
}

@RestController
class ExceptionController {
    @GetMapping("/exceptions")
    fun throwException(): Nothing = throw RuntimeException("throw runtime exception!")
}

@RestController
class LogController {
    private val log = KotlinLogging.logger{}

    @GetMapping("/log")
    fun logging() {
        log.trace("trace")
        log.debug("debug")
        log.info("info")
        log.warn("warn")
        log.error("error")
    }
}

@RestController
class PhaseController(private val phase: Phase) {
    @GetMapping("/phase")
    fun getPhase() = phase
}

@RestController
class ApiController {
    @GetMapping("/v1/cards")
    fun getCards() = listOf("card 1", "card 2")
}