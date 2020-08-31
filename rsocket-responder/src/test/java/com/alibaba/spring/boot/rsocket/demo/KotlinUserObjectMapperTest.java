package com.alibaba.spring.boot.rsocket.demo;

import com.alibaba.account.Account;
import com.alibaba.user.KotlinUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import com.google.protobuf.GeneratedMessageV3;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.json.Json;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * Kotlin User ObjectMapper test
 *
 * @author leijuan
 */
public class KotlinUserObjectMapperTest {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static ObjectMapper cborMapper = new ObjectMapper(new CBORFactory());


    @BeforeAll
    public static void setUp() {
        objectMapper.findAndRegisterModules();
    }

    @Test
    public void testJsonOutput() throws Exception {
        KotlinUser user = new KotlinUser(1, "linux_china", "email", "186");
        String jsonText = objectMapper.writeValueAsString(user);
        System.out.println(jsonText);
        KotlinUser kotlinUser = objectMapper.readValue(jsonText, KotlinUser.class);
        System.out.println(kotlinUser.getNick());
    }

    @Test
    public void testKtClass() throws Exception {
        KSerializer<?> serializer = getSerializer(KotlinUser.class);
        KotlinUser user = new KotlinUser(1, "linux_china", "email", "186");
        String jsonText = Json.Default.encodeToString((SerializationStrategy<? super KotlinUser>) serializer, user);
        System.out.println(jsonText);
    }

    public KSerializer<?> getSerializer(Class<?> clazz) throws Exception {
        Class<?> serializerClazz = Class.forName(clazz.getCanonicalName() + "$$serializer");
        Field instanceField = serializerClazz.getDeclaredField("INSTANCE");
        return (KSerializer<?>) instanceField.get(null);
    }

    @Test
    public void testProtobufClass() {
        Class<Account> clazz = Account.class;
        boolean assignableFrom = GeneratedMessageV3.class.isAssignableFrom(clazz);
        System.out.println(assignableFrom);
    }

    @Test
    public void testCbor() throws Exception {
        KotlinUser user = new KotlinUser(1, "linux_china", "xxx@yyy.com", "186");
        byte[] bytes = cborMapper.writeValueAsBytes(user);
        System.out.println(bytes.length);
        KotlinUser user2 = cborMapper.readValue(bytes, KotlinUser.class);
        System.out.println(user2.getNick());
    }
}
