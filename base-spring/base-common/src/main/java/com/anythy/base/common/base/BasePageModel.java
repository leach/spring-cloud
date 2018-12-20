package com.anythy.base.common.base;

import java.util.Collections;
import java.util.List;

/**
 * 公共分页对象
 * @author Leach
 */
public class BasePageModel<T> extends BaseListModel {
    /**
     * 总记录数
     */
    private long totalCount;
    /**
     * 总页数
     */
    private long totalPages;

    private int pageIndex = Base.PAGEINDEX;

    private int pageSize = Base.PAGESIZE;

    private BasePageModel() {
    }

    public BasePageModel(long totalCount, int pageIndex, int pageSize, List<T> list) {
        this.totalCount = totalCount;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalPages = (totalCount + pageSize - 1) / pageSize;
        super.setList(list);
        if(null == super.getList()) {
            super.setList(Collections.EMPTY_LIST);
        }
    }


    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
