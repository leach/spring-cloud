package com.anythy.base.spring.apiversion;

import com.anythy.base.common.constants.Versions;
import com.anythy.base.spring.apiversion.annotation.ApiVersion;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * requestMapping
 * @author Leach
 */
public class ApiVersionRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {
        return createCondition(handlerType);
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        return createCondition(method.getClass());
    }

    private static RequestCondition<ApiVersionCondition> createCondition(Class<?> clazz){
        RequestMapping requestMapping = AnnotationUtils.findAnnotation(clazz, RequestMapping.class);
        if(requestMapping == null){
            return null;
        }
        StringBuilder mappingUrlBuilder = new StringBuilder();
        if(requestMapping.value().length > 0){
            mappingUrlBuilder.append(requestMapping.value()[0]);
        }
        String mappingUrl = mappingUrlBuilder.toString();
        if(!mappingUrl.contains(Versions.VERSION_PLACEHOLDER)){
            return null;
        }
        ApiVersion apiVersion = AnnotationUtils.findAnnotation(clazz, ApiVersion.class);
        ApiVersionCondition apiVersionCondition = apiVersion == null ? new ApiVersionCondition(Versions.BASE) : new ApiVersionCondition(apiVersion.value());
        return apiVersionCondition;
    }
}