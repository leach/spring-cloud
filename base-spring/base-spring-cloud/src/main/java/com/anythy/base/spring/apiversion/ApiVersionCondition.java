package com.anythy.base.spring.apiversion;

import com.anythy.base.common.constants.Numbers;
import com.anythy.base.common.constants.Versions;
import com.anythy.base.common.utils.UrlUtil;
import org.apache.catalina.util.URLEncoder;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author klq
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile(Versions.VERSION_PATTERN);

    private int apiVersion;

    public ApiVersionCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition apiVersionCondition) {
        return new ApiVersionCondition(apiVersionCondition.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest httpServletRequest) {
        String uri = httpServletRequest.getRequestURI();
        Matcher matcher = VERSION_PREFIX_PATTERN.matcher(uri);
        if(matcher.find()){
            Integer version = Integer.valueOf(matcher.group(Numbers.FIRST));
            if(version.intValue() == this.apiVersion){
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition apiVersionCondition, HttpServletRequest httpServletRequest) {
        return apiVersionCondition.getApiVersion() - this.apiVersion;
    }

    public int getApiVersion() {
        return apiVersion;
    }
}
