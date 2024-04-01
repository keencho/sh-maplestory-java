package com.sh.maplestory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.sh.maplestory.external.open_api.Client;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class ShMaplestoryJavaApplicationTests {

    private static Client client;

    @BeforeAll
    public static void beforeAll() {

        var key = System.getenv("MAPLESTORY_API_KEY");

        if (!StringUtils.hasText(key)) {
            throw new RuntimeException("The test cannot be started because the required key is not registered with the system environment variable.");
        }

        var objectMapper = new ObjectMapper();

        var deserializerModule = new SimpleModule();
        deserializerModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

        objectMapper.registerModule(deserializerModule);

        client = new Client(key, objectMapper);
    }

    @Test
    void test() {
//        var ocid = client.getOcid("세땃");
        var ocid = "ba2a3bc1861300f1c5f3d18565718285";
        var basic = client.getCharacterStat(ocid, LocalDate.now().minusDays(1));

        System.out.println(basic);
    }

}
