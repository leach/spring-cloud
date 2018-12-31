package com.anythy.zkconfigserver.provider;

import com.anythy.zkconfigserver.entity.ProfileVo;
import com.anythy.zkconfigserver.entity.PropertiesVo;
import com.anythy.zkconfigserver.util.StringUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @author Leach
 */
public class PropsProvider {

    /**
     * 查询profile sql
     * @param project
     * @return
     */
    public String listProfile(@Param("project") String project){
        SQL sql = new SQL(){
            {
                SELECT("id, project, name, remark");
                FROM("profile");
                if(!StringUtils.isEmpty(project)){
                    WHERE("project like #{project}");
                }
            }
        };
        return sql.toString();
    }

    /**
     * 查询Properties sql
     * @param key
     * @return
     */
    public String listProperties(@Param("key") String key){
        SQL sql = new SQL(){
            {
                SELECT("id, profileId, key, value, status, remark");
                FROM("properties");
                if(!StringUtils.isEmpty(key)){
                    WHERE("key like #{key}");
                }
            }
        };
        return sql.toString();
    }

    /**
     * 更新
     * @param profileVo
     * @return
     */
    public String updateProfile(ProfileVo profileVo){
        SQL sql = new SQL(){
            {
                UPDATE("profile");
                if(!StringUtils.isEmpty(profileVo.getName())){
                    SET("name = #{name}");
                }
                if(!StringUtils.isEmpty(profileVo.getProject())){
                    SET("project = #{project}");
                }
                if(!StringUtils.isEmpty(profileVo.getRemark())){
                    SET("remark = #{remark}");
                }
                WHERE("id = #{id}");
            }
        };
        return sql.toString();
    }

    /**
     * 更新
     * @param propertiesVo
     * @return
     */
    public String updateProperties(PropertiesVo propertiesVo){
        SQL sql = new SQL(){
            {
                UPDATE("properties");
                if(!StringUtils.isEmpty(propertiesVo.getKey())){
                    SET("key = #{key}");
                }
                if(!StringUtils.isEmpty(propertiesVo.getValue())){
                    SET("value = #{value}");
                }
                if(!StringUtils.isEmpty(propertiesVo.getRemark())){
                    SET("remark = #{remark}");
                }
                if(propertiesVo.getStatus() != null){
                    SET("status = #{status}");
                }
                WHERE("id = #{id}");
            }
        };
        return sql.toString();
    }
}
