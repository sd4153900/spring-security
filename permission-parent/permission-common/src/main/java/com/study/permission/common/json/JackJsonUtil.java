package com.study.permission.common.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * @author caad
 * @date: Create in 17:13 2019/4/8
 */
public class JackJsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
//        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
//        objectMapper.setFilterProvider(new SimpleFilterProvider().setFailOnUnknownId(false));
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static <T> String toJson(T object) throws JsonProcessingException {
        if(object == null){
            return null;
        }
        return objectMapper.writeValueAsString(object);
    }

    public static <T> T toObject(String json, TypeReference<T> typeReference) throws IOException {
        if(StringUtils.isEmpty(json) || typeReference == null){
            return null;
        }
        return objectMapper.readValue(json,typeReference);
    }

    public static <T> T toObject(String json, Class<T> clazz) throws IOException {
        if(StringUtils.isEmpty(json) || clazz == null){
            return null;
        }
        return objectMapper.readValue(json,clazz);
    }

}
