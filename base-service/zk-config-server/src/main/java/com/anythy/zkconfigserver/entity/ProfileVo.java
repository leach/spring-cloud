package com.anythy.zkconfigserver.entity;

import com.anythy.base.common.base.model.BaseObjModel;
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
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
