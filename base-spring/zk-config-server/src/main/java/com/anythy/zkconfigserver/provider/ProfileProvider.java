package com.anythy.zkconfigserver.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @author Leach
 */
public class ProfileProvider {

    /**
     * 查询profile sql
     * @param project
     * @return
     */
    public String listProfile(@Param("project") String project){
        SQL sql = new SQL(){
            {
                SELECT("id, project, profile, remark");
                FROM("profile");
                if(!StringUtils.isEmpty(project)){
                    WHERE("project like #{project}");
                }
            }
        };
        return sql.toString();
    }
}
