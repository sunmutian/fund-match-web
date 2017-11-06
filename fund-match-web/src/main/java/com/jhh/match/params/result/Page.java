package com.jhh.match.params.result;

import java.io.Serializable;

/**
 * 分页
 *
 * @author tianweichang
 * @create 2017-11-04 14:12
 **/
public class Page implements Serializable {
    private static final long serialVersionUID = -853064276270126401L;
    /**
     * 页码
     */
    private Integer pageIndex;
    /**
     * 每页条数
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Integer total;
    /**
     * 总页数
     */
    private Integer pageCount;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
