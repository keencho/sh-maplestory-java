package com.sh.maplestory.config;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

@Slf4j
public class OpenAPIDeserializer extends JsonDeserializer<Object> implements ContextualDeserializer {

    private JavaType javaType;

    public OpenAPIDeserializer() {
    }

    public OpenAPIDeserializer(JavaType javaType) {
        this.javaType = javaType;
    }

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        var objectMapper = (ObjectMapper) jsonParser.getCodec();
        var jsonNode = (JsonNode) objectMapper.readTree(jsonParser);

        var clazz = this.javaType.getRawClass();

        if (clazz == null) {
            return null;
        }

        return this.map(clazz, jsonNode, objectMapper);
    }

    private String toSnakeCase(String input) {
        // Replace capital letters with "_"+lowercase letter
        var snakeCase = input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
        // Add "_" before any digit that is preceded by a letter
        snakeCase = snakeCase.replaceAll("([a-zA-Z])(\\d)", "$1_$2");
        return snakeCase;
    }

    private Object map(Class<?> clazz, JsonNode jsonNode, ObjectMapper objectMapper) {

        Object instance = null;
        try {
            instance = clazz.getConstructor().newInstance();

            for (var field : clazz.getDeclaredFields()) {
                field.setAccessible(true);

                var snakeField = this.toSnakeCase(field.getName());
                if (jsonNode.has(snakeField)) {
                    var innerNode = jsonNode.get(snakeField);

                    if (innerNode.isObject()) {
                        field.set(instance, this.map(field.getType(), innerNode, objectMapper));
                    } else if (innerNode.isArray()) {
                        var arr = new ArrayList<>();
                        innerNode.forEach(item -> {
                            arr.add(this.map((Class<?>) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0], item, objectMapper));
                        });
                        field.set(instance, arr);
                    } else {
                        field.set(instance, objectMapper.convertValue(jsonNode.get(snakeField), field.getType()));
                    }
                }
            }

        } catch (Exception ignored) { }

        return instance;
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
        var type = deserializationContext.getContextualType() != null
                ? deserializationContext.getContextualType()
                : beanProperty.getMember().getType();
        return new OpenAPIDeserializer(type);
    }
}
