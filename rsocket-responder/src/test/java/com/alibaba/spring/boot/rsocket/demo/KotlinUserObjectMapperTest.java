package com.alibaba.spring.boot.rsocket.demo;

import com.alibaba.user.KotlinUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Kotlin User ObjectMapper test
 *
 * @author leijuan
 */
public class KotlinUserObjectMapperTest {
    private static ObjectMapper objectMapper = new ObjectMapper();

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
}
