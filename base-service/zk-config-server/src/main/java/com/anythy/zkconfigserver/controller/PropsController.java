package com.anythy.zkconfigserver.controller;

import com.anythy.base.common.base.model.BaseListModel;
import com.anythy.base.common.base.CommonResult;
import com.anythy.zkconfigserver.entity.ProfileVo;
import com.anythy.zkconfigserver.entity.PropertiesVo;
import com.anythy.zkconfigserver.service.PropsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    PropsService propsService;

    @GetMapping("/profile/list")
    public CommonResult<BaseListModel> listProfile(@RequestParam(value = "project", required = false) String project){
        List<ProfileVo> list = propsService.listProfile(project);
        return CommonResult.success(list);
    }

    @PostMapping("/profile/add")
    public CommonResult<ProfileVo> addProfile(@RequestBody ProfileVo profileVo){
        ProfileVo result = propsService.addProfile(profileVo);
        return CommonResult.success(result);
    }

    @GetMapping("/properties/list")
    public CommonResult<BaseListModel> listProperties(@RequestParam(value = "key", required = false) String key){
        List<PropertiesVo> list = propsService.listProperties(key);
        return CommonResult.success(list);
    }

    @PostMapping("/properties/add")
    public CommonResult<PropertiesVo> addProperties(@RequestBody PropertiesVo propertiesVo){
        PropertiesVo result = propsService.addProperties(propertiesVo);
        return CommonResult.success(result);
    }

    @PostMapping("/profile/update")
    public CommonResult<Integer> updateProfile(@RequestBody ProfileVo profileVo){
        int result = propsService.updateProfile(profileVo);
        return CommonResult.success(result);
    }

    @PostMapping("/properties/update")
    public CommonResult<Integer> updateProperties(@RequestBody PropertiesVo propertiesVo){
        int result = propsService.updateProperties(propertiesVo);
        return CommonResult.success(result);
    }
}
