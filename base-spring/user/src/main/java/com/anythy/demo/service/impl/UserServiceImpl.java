package com.anythy.demo.service.impl;

import com.anythy.demo.entity.UserVO;
import com.anythy.demo.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户业务处理实现类
 * @author Leach
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserVO findUser(String username, String password) {
        if(!"123".equals(password)){
            return null;
        }
        UserVO userVO = new UserVO();
        userVO.setUsername("admin");
        userVO.setRoles("admin,test");
        return userVO;
    }

    @Override
    public UserVO findUser(String username) {
        UserVO userVO = new UserVO();
        userVO.setUsername("admin");
        userVO.setRoles("admin,test");
        return userVO;
    }
}
