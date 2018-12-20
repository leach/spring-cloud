package com.anythy.zkconfigserver.service;

import com.anythy.zkconfigserver.entity.ProfileVo;
import sun.java2d.cmm.Profile;

import java.util.List;

/**
 * @author Leach
 */
public interface ProfileService {

    List<ProfileVo> listProfile(String project);
    ProfileVo addProfile(ProfileVo profileVo);
}
