package com.alibaba.user

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf
import org.junit.jupiter.api.Test

/**
 * Kotlin user test with Json, Protobuf and Cbor
 *
 * @author linux_china
 */
@UnstableDefault
@ImplicitReflectionSerializer
class KotlinUserTest {

    @Test
    fun testJson() {
        val jsonText = Json.stringify(KotlinUser.serializer(), constructUser())
        println(jsonText)
        val user = Json.parse(KotlinUser.serializer(), jsonText);
        println(user.nick)
    }

    @Test
    fun testProtobuf() {
        val protoBytes = ProtoBuf.dump(KotlinUser.serializer(), constructUser())
        val user = ProtoBuf.load(KotlinUser.serializer(), protoBytes);
        println(user.nick)
    }

    @Test
    fun testCbor() {
        val cborBytes = Cbor.dump(KotlinUser.serializer(), constructUser())
        val user = Cbor.load(KotlinUser.serializer(), cborBytes);
        println(user.nick)
    }

    private fun constructUser(): KotlinUser {
        return KotlinUser(1, "linux_china", "xxx@yyy.com", "186")
    }
}