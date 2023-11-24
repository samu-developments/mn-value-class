package com.example

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.serde.annotation.Serdeable

@Controller
class HelloController {
    @Get
    fun value(): Hello {
        return Hello("Hello world")
    }

    @Get("/container")
    fun container(): HelloContainer {
        return HelloContainer(Hello("Hello world"))
    }

    @Get("/phantom")
    fun phantom(): HelloContainerWithPhantom {
        return HelloContainerWithPhantom(Hello("Hello world"))
    }
}

@JvmInline
@Serdeable
value class Hello(val value: String)

@Serdeable
data class HelloContainer(val hello: Hello)

@Serdeable
data class HelloContainerWithPhantom(val hello: Hello, val _phantom: String = "phantom")