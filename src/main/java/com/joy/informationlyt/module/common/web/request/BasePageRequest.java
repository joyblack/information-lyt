package com.joy.informationlyt.module.common.web.request;

public class BasePageRequest {

    private int page = 1;

    private int size = 10;
    /**
     * 模糊搜索字段
     */
    private String search;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
