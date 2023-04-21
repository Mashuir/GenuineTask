package com.example.genuinetask.model;

public class PageInfo {

    private int PageNo;
    private int PageSize;
    private int PageCount;
    private int TotalRecordCount;

    public int getPageNo() {
        return PageNo;
    }

    public void setPageNo(int pageNo) {
        PageNo = pageNo;
    }

    public int getPageSize() {
        return PageSize;
    }

    public void setPageSize(int pageSize) {
        PageSize = pageSize;
    }

    public int getPageCount() {
        return PageCount;
    }

    public void setPageCount(int pageCount) {
        PageCount = pageCount;
    }

    public int getTotalRecordCount() {
        return TotalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        TotalRecordCount = totalRecordCount;
    }
}
