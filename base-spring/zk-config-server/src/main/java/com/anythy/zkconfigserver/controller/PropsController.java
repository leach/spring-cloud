package com.anythy.zkconfigserver.controller;

import com.anythy.base.common.base.BaseListModel;
import com.anythy.base.common.base.CommonResult;
import com.anythy.zkconfigserver.entity.ProfileVo;
import com.anythy.zkconfigserver.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.java2d.cmm.Profile;

import java.util.List;

/**
 * 配置Controller
 * @author Leach
 */
@RestController
@RequestMapping("/props")
@CrossOrigin
public class PropsController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/profile/list")
    public CommonResult<BaseListModel> listProfile(@RequestParam(value = "project", required = false) String project){
        List<ProfileVo> list = profileService.listProfile(project);
        return CommonResult.success(list);
    }

    @PostMapping("/profile/add")
    public CommonResult<ProfileVo> addProfile(@RequestBody ProfileVo profileVo){
        ProfileVo result = profileService.addProfile(profileVo);
        return CommonResult.success(result);
    }


}
