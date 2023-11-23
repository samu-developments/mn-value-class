package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.serde.ObjectMapper
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest

@MicronautTest
class HelloSerdeTest(
    val om: ObjectMapper
) : StringSpec ({

    "can serde hello value class" {
        val hello = Hello("hey")
        val serialized = om.writeValueAsString(hello)

        // Fails
        val deserialized = om.readValue(serialized, Hello::class.java)

        deserialized.value shouldBe hello.value
    }
})