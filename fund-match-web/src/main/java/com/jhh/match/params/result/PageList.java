package com.jhh.match.params.result;

import java.io.Serializable;
import java.util.List;

/**
 * 信息列表
 *
 * @author tianweichang
 * @create 2017-10-23 19:18
 **/
public class PageList<T> implements Serializable {
    private static final long serialVersionUID = -1010649898020554911L;
    private Long page;
    private Long size;
    private Long total;
    private Long totalPages;
    private List<T> list;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPage() {
        return page;
    }

    public void setPage(Long page) {
        this.page = page;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Long totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
