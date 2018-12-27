package com.anythy.usercenter.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * userVO
 * @author Leach
 */
@Getter
@Setter
@ToString
public class UserVO {
    private String username;
    private String password;
    private String roles;
}
