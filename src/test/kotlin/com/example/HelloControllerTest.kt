package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest

@MicronautTest
class HelloControllerTest(
    @Client("/") val client: HttpClient
) : StringSpec ({

    "can say hello" {
        val request = HttpRequest.GET<Any>("")

        // Fails
        val body = client.toBlocking().retrieve(request, Hello::class.java)

        body.value shouldBe "Hello world"
    }
})