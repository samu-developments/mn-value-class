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

    "can say hello container" {
        val request = HttpRequest.GET<Any>("/container")

        // Fails
        val body = client.toBlocking().retrieve(request, HelloContainer::class.java)

        body.hello.value shouldBe "Hello world"
    }

    "can say hello phantom" {
        val request = HttpRequest.GET<Any>("/phantom")

        // Works
        val body = client.toBlocking().retrieve(request, HelloContainerWithPhantom::class.java)

        body.hello.value shouldBe "Hello world"
    }
})