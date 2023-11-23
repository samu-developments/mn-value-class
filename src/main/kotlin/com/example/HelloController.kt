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
}

@JvmInline
@Serdeable
value class Hello(val value: String)
