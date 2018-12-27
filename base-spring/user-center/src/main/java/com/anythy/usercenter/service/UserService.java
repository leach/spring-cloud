package com.anythy.usercenter.service;

import com.anythy.usercenter.entity.UserVO;

/**
 * 用户业务处理接口
 * @author Leach
 */
public interface UserService {
    /**
     * 查找用户
     * 根据用户名、密码
     * @param username
     * @param password
     * @return
     */
    UserVO findUser(String username, String password);
    /**
     * 查找用户
     * 根据用户名
     * @param username
     * @return
     */
    UserVO findUser(String username);
}
