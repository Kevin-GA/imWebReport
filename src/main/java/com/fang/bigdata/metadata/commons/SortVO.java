package com.fang.bigdata.metadata.commons;

import com.fang.bigdata.metadata.utils.StringUtils;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.commons
 * @name: SortVO
 * @describe:
 * @author: niujiaxin
 * @create: 2018-10-20-17:41
 */
public class SortVO {
    private String sort;
    private String order;

    public SortVO() {
    }

    public String getSort() {
        return this.sort;
    }

    public void setSort(String sort) {
        if (sort != null) {
            String sortTemp = sort.replaceAll(",", "");
            sortTemp = StringUtils.checkValidSQL(sortTemp);
            if (sortTemp == null) {
                this.sort = null;
                return;
            }
        }

        this.sort = sort;
    }

    public String getOrder() {
        return this.order;
    }

    public void setOrder(String order) {
        if (order != null) {
            String orderTemp = order.replaceAll(",", "");
            orderTemp = StringUtils.checkValidSQL(orderTemp);
            if (orderTemp == null) {
                this.order = null;
                return;
            }
        }

        this.order = order;
    }
}