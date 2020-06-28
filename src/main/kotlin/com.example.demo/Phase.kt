package com.example.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment

enum class Phase {
    LOCAL,
    DEV,
    LIVE,
    TEST,
    DEFAULT
    ;

    companion object {
        private val map = values().associateBy { it.name.toLowerCase() }
        fun of(phase: String?) = map[phase] ?: DEFAULT
    }

    val isLocal: Boolean
        get() = this == LOCAL
    val isDev: Boolean
        get() = this == DEV
    val isLive: Boolean
        get() = this == LIVE
    val isTest: Boolean
        get() = this == TEST
}

@Configuration
class PhaseConfig {
    @Bean
    fun phase(environment: Environment): Phase {
        return environment.activeProfiles.map { Phase.of(it) }.first { it != Phase.DEFAULT }
    }
}