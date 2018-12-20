package com.anythy.zkconfigserver.service;

import com.anythy.zkconfigserver.entity.ProfileVo;
import com.anythy.zkconfigserver.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Leach
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileMapper profileMapper;

    @Override
    public List<ProfileVo> listProfile(String project) {
        if(!StringUtils.isEmpty(project)){
            StringBuilder builder = new StringBuilder("%");
            project = builder.append(project).append("%").toString();
        }
        return profileMapper.listProfile(project);
    }

    @Override
    public ProfileVo addProfile(ProfileVo profileVo) {
        int n = profileMapper.insertProfile(profileVo);
        if(n == 1){
            return profileVo;
        }
        return null;
    }
}
