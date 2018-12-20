package com.anythy.zkconfigserver.mapper;

import com.anythy.zkconfigserver.entity.ProfileVo;
import com.anythy.zkconfigserver.provider.ProfileProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目Mapper
 * @author Leach
 */
@Repository
public interface ProfileMapper {
    /**
     * 查询profile列表
     * @param project
     * @return
     */
    @SelectProvider(type = ProfileProvider.class, method = "listProfile")
    List<ProfileVo> listProfile(String project);

    /**
     *
     * @param profileVo
     * @return
     */
    @Insert("insert into profile(project, profile, remark) values (#{project}, #{profile}, #{remark})")
    @SelectKey(before = false, keyProperty = "id", resultType = Integer.class, statement = "select last_insert_rowid() as id", statementType = StatementType.STATEMENT)
    int insertProfile(ProfileVo profileVo);

}
