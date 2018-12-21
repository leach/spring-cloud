package com.anythy.zkconfigserver.service;

import com.anythy.base.common.base.BusinessException;
import com.anythy.zkconfigserver.entity.ProfileVo;
import com.anythy.zkconfigserver.entity.PropertiesVo;
import com.anythy.zkconfigserver.mapper.PropsMapper;
import com.anythy.zkconfigserver.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anythy.base.common.base.BusinessException.Errors;

import java.util.List;

/**
 * @author Leach
 */
@Service
public class PropsServiceImpl implements PropsService {

    @Autowired
    private PropsMapper propsMapper;

    @Override
    public List<ProfileVo> listProfile(String project) {
        return propsMapper.listProfile(StringUtil.preHandle(project));
    }

    @Override
    public ProfileVo addProfile(ProfileVo profileVo) {
        ProfileVo check = propsMapper.getProfile(profileVo.getProject(), profileVo.getName());
        if(check != null){
            throw new BusinessException(Errors.DATA_EXISTS);
        }
        int n = propsMapper.insertProfile(profileVo);
        return n == 1 ? profileVo : null;
    }

    @Override
    public int updateProfile(ProfileVo profileVo) {
        return propsMapper.updateProfile(profileVo);
    }

    @Override
    public List<PropertiesVo> listProperties(String key) {
        return propsMapper.listProperties(StringUtil.preHandle(key));
    }

    @Override
    public PropertiesVo addProperties(PropertiesVo propertiesVo) {
        PropertiesVo check = propsMapper.getProperties(propertiesVo.getProfileId(), propertiesVo.getKey());
        if(check != null){
            throw new BusinessException(Errors.DATA_EXISTS);
        }
        int n = propsMapper.insertProperties(propertiesVo);
        return n == 1 ? propertiesVo : null;
    }

    @Override
    public int updateProperties(PropertiesVo propertiesVo) {
        return propsMapper.updateProperties(propertiesVo);
    }
}
