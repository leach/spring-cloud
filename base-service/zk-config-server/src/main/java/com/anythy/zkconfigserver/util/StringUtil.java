package com.anythy.zkconfigserver.util;

import org.springframework.util.StringUtils;

/**
 * 字符预处理
 * @author Leach
 */
public class StringUtil {

    /**
     * 处理模糊查询
     * @param v
     * @return
     */
    public static String preHandle(String v){
        if(!StringUtils.isEmpty(v)){
            StringBuffer builder = new StringBuffer("%");
            v = builder.append(v).append("%").toString();
        }
        return v;
    }
}
