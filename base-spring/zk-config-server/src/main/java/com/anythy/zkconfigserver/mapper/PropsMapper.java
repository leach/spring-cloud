package com.anythy.zkconfigserver.mapper;

import com.anythy.zkconfigserver.entity.ProfileVo;
import com.anythy.zkconfigserver.entity.PropertiesVo;
import com.anythy.zkconfigserver.provider.PropsProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目Mapper
 * @author Leach
 */
@Repository
public interface PropsMapper {
    /**
     * 查询profile列表
     * @param project
     * @return
     */
    @SelectProvider(type = PropsProvider.class, method = "listProfile")
    List<ProfileVo> listProfile(String project);

    /**
     * 插入profile
     * @param profileVo
     * @return
     */
    @Insert("insert into profile(project, name, remark) values (#{project}, #{name}, #{remark})")
    @SelectKey(before = false, keyProperty = "id", resultType = Integer.class, statement = "select last_insert_rowid() as id", statementType = StatementType.STATEMENT)
    int insertProfile(ProfileVo profileVo);

    /**
     * 根据project、name查询
     * @param project
     * @param name
     * @return
     */
    @Select("SELECT id, project, name FROM profile WHERE project = #{project} and name = #{name}")
    ProfileVo getProfile(@Param("project") String project, @Param("name") String name);

    /**
     * 更新
     * @param profileVo
     * @return
     */
    @UpdateProvider(type = PropsProvider.class, method = "updateProfile")
    int updateProfile(ProfileVo profileVo);

    /**
     * 插入properties
     * @param propertiesVo
     * @return
     */
    @Insert("insert into properties (profileId, key, value, status, remark) values (#{profileId}, #{key}, #{value}, #{status}, #{remark})")
    @SelectKey(before = false, keyProperty = "id", resultType = Integer.class, statement = "select last_insert_rowid() as id", statementType = StatementType.STATEMENT)
    int insertProperties(PropertiesVo propertiesVo);


    /**
     * 更新 Properties
     * @param propertiesVo
     * @return
     */
    @UpdateProvider(type = PropsProvider.class, method = "updateProperties")
    int updateProperties(PropertiesVo propertiesVo);

    /**
     * 查询 Properties
     * @param key
     * @return
     */
    @SelectProvider(type = PropsProvider.class, method = "listProperties")
    List<PropertiesVo> listProperties(String key);


    /**
     * 根据projectId、key查询
     * @param projectId
     * @param key
     * @return
     */
    @Select("SELECT id, project, name FROM properties WHERE projectId = #{projectId} and key = #{key}")
    PropertiesVo getProperties(@Param("projectId") int projectId, @Param("key") String key);
}
