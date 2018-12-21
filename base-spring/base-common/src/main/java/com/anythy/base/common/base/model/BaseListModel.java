package com.anythy.base.common.base.model;

import java.util.List;

/**
 * 公共列表对象
 * @author Leach
 */
public class BaseListModel<T> extends BaseObjModel {

    /**
     * 列表数据
     */
    private List<T> list;

    public BaseListModel() {
    }

    public BaseListModel(List<T> list) {
        this.list = list;
    }

    public BaseListModel(List<T> list, long count) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
