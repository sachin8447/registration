package com.techphantoms.registration.util;

import java.io.Serializable;

import org.codehaus.jackson.map.ObjectMapper;

public final class JSONUtil implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String convertObjectToJson(Object object) {
        try {
            String json = mapper.writeValueAsString(object);
            return json;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static Object convertJsonToObject(String json, Class<?> objectClass) {
        try {
            Object object = mapper.readValue(json, objectClass);
            return object;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }
}
