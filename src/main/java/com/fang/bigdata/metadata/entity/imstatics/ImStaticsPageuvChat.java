package com.fang.bigdata.metadata.entity.imstatics;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.entity.imstatics
 * @name: ImStaticsPageuvChat
 * @describe:
 * @author: niujiaxin
 * @create: 2018-12-27-14:43
 */
public class ImStaticsPageuvChat {

    private String actionday;
    private String pagetype;
    private String producttype;
    private String uvtype;
    private String city;
    private Integer uv;

    public ImStaticsPageuvChat() {
    }


    public String getActionday() {
        return this.actionday;
    }

    public String getPagetype() {
        return this.pagetype;
    }

    public String getProducttype() {
        return this.producttype;
    }

    public String getUvtype() {
        return this.uvtype;
    }

    public String getCity() {
        return this.city;
    }

    public Integer getUv() {
        return this.uv;
    }

    public void setActionday(String actionday) {
        this.actionday = actionday;
    }

    public void setPagetype(String pagetype) {
        this.pagetype = pagetype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public void setUvtype(String uvtype) {
        this.uvtype = uvtype;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUv(Integer uv) {
        this.uv = uv;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ImStaticsPageuvChat)) return false;
        final ImStaticsPageuvChat other = (ImStaticsPageuvChat) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$actionday = this.getActionday();
        final Object other$actionday = other.getActionday();
        if (this$actionday == null ? other$actionday != null : !this$actionday.equals(other$actionday)) return false;
        final Object this$pagetype = this.getPagetype();
        final Object other$pagetype = other.getPagetype();
        if (this$pagetype == null ? other$pagetype != null : !this$pagetype.equals(other$pagetype)) return false;
        final Object this$producttype = this.getProducttype();
        final Object other$producttype = other.getProducttype();
        if (this$producttype == null ? other$producttype != null : !this$producttype.equals(other$producttype))
            return false;
        final Object this$uvtype = this.getUvtype();
        final Object other$uvtype = other.getUvtype();
        if (this$uvtype == null ? other$uvtype != null : !this$uvtype.equals(other$uvtype)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$uv = this.getUv();
        final Object other$uv = other.getUv();
        if (this$uv == null ? other$uv != null : !this$uv.equals(other$uv)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $actionday = this.getActionday();
        result = result * PRIME + ($actionday == null ? 43 : $actionday.hashCode());
        final Object $pagetype = this.getPagetype();
        result = result * PRIME + ($pagetype == null ? 43 : $pagetype.hashCode());
        final Object $producttype = this.getProducttype();
        result = result * PRIME + ($producttype == null ? 43 : $producttype.hashCode());
        final Object $uvtype = this.getUvtype();
        result = result * PRIME + ($uvtype == null ? 43 : $uvtype.hashCode());
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $uv = this.getUv();
        result = result * PRIME + ($uv == null ? 43 : $uv.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ImStaticsPageuvChat;
    }

    public String toString() {
        return "ImStaticsPageuvChat(actionday=" + this.getActionday() + ", pagetype=" + this.getPagetype() + ", producttype=" + this.getProducttype() + ", uvtype=" + this.getUvtype() + ", city=" + this.getCity() + ", uv=" + this.getUv() + ")";
    }
}
