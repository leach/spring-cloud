package com.anythy.zkconfigserver.entity;

import com.anythy.base.common.base.BaseObjModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * profileVo
 * @author Leach
 */
public class ProfileVo extends BaseObjModel {

    private Integer id;
    @ApiModelProperty("项目")
    private String project;
    @ApiModelProperty("环境")
    private String profile;
    @ApiModelProperty("备注")
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
