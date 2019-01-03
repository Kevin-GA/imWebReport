package com.fang.bigdata.metadata.commons;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.commons
 * @name: PageVO
 * @describe:
 * @author: niujiaxin
 * @create: 2018-10-20-17:39
 */
public class PageVO {
    private int limit;
    private int offset;

    public PageVO() {
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String toString() {
        return this.limit == 0 ? "" : " limit " + this.offset + "," + this.limit;
    }
}
