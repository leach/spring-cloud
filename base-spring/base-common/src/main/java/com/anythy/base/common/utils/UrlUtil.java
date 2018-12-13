package com.anythy.base.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Url工具类 encode/decode
 * @author Leach
 */
public class UrlUtil {

    /**
     * Url encode
     * default Charset: utf-8
     * @param url
     * @return
     */
    public static String encode(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url, StandardCharsets.UTF_8.name());
    }
}
