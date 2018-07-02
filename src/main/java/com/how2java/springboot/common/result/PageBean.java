package com.how2java.springboot.common.result;

public class PageBean {
    // 一页条数
    private int pageSize = 10;

    // 页码
    private int pageNumber = 1;

    // 总条数
    private int totalRow;

    // 开始条数
    private int startRow = 1;

    // 当前条数
    private int currentRow = 10;

    @SuppressWarnings("unused")
    private int totalPage = 0;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize <= 1) {
            pageSize = 1;
        }
        startRow = pageSize * (pageNumber - 1);
        currentRow = pageNumber * pageSize;
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getTotalPage() {
        return (int) Math.ceil((float) totalRow / pageSize);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

}
