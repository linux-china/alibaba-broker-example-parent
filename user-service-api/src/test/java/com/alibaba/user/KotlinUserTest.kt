package com.alibaba.user

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.cbor.Cbor
import kotlinx.serialization.json.Json
import kotlinx.serialization.protobuf.ProtoBuf
import org.junit.jupiter.api.Test

/**
 * Kotlin user test with Json, Protobuf and Cbor
 *
 * @author linux_china
 */
@ExperimentalSerializationApi
class KotlinUserTest {

    @Test
    fun testJson() {
        val jsonText = Json.encodeToString(KotlinUser.serializer(), constructUser())
        println(jsonText)
        val user = Json.decodeFromString(KotlinUser.serializer(), jsonText);
        println(user.nick)
    }

    @Test
    fun testProtobuf() {
        val serializer = KotlinUser.serializer()
        println(serializer.javaClass)
        val protoBytes = ProtoBuf.encodeToByteArray(serializer, constructUser())
        val user = ProtoBuf.decodeFromByteArray(serializer, protoBytes);
        println(user.nick)
    }

    @Test
    fun testCbor() {
        val cborBytes = Cbor.encodeToByteArray(KotlinUser.serializer(), constructUser())
        println(cborBytes.size)
        val user = Cbor.decodeFromByteArray(KotlinUser.serializer(), cborBytes);
        println(user.nick)
    }

    private fun constructUser(): KotlinUser {
        return KotlinUser(1, "linux_china", "xxx@yyy.com", "186")
    }
}