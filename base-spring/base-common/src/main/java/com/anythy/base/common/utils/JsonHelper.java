package com.anythy.base.common.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Leach on 0009 2018/3/9.
 * JSON工具类
 */
public class JsonHelper {
    private static ObjectMapper mapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    
    /**
     * 从JSON字符串转换为对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static  <T> T fromJSON(String json, Class<T> clazz) {
        try {
            return mapper.readValue(json, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 对象转JSON字符串
     * @param obj
     * @return
     */
    public static String toJSON(Object obj) {

        StringWriter writer = new StringWriter();
        try {
            mapper.writeValue(writer, obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return writer.toString();
    }
    
    public static <T> T fromJSON(String json, TypeReference<T> valueTypeRef) {
		try {
			json = json.replaceAll(" ", "");
			return mapper.readValue(json, valueTypeRef);
		}  catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
