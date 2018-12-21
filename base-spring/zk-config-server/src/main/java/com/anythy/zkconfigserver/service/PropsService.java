package com.anythy.zkconfigserver.service;

import com.anythy.zkconfigserver.entity.ProfileVo;
import com.anythy.zkconfigserver.entity.PropertiesVo;
import sun.java2d.cmm.Profile;

import java.util.List;

/**
 * @author Leach
 */
public interface PropsService {

    List<ProfileVo> listProfile(String project);
    ProfileVo addProfile(ProfileVo profileVo);
    int updateProfile(ProfileVo profileVo);

    List<PropertiesVo> listProperties(String key);
    PropertiesVo addProperties(PropertiesVo propertiesVo);
    int updateProperties(PropertiesVo propertiesVo);
}
