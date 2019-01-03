package com.fang.bigdata.metadata.entity.imstatics;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.entity
 * @name: ImEntity
 * @describe:
 * @author: niujiaxin
 * @create: 2018-12-26-14:28
 */
public class ImEntity {
    private Integer indexPageUv; // 房app首页uv
    private Integer listPageUv; // 房app列表页uv
    private Integer detailPageUv; // 房app详情页uv
    private Integer imCount; // im聊天数
    private Integer sessionCount; // 会话总数
    private Integer validSessionCount; // 有效会话数
    private Integer invalidSessionCount; // 无效会话数

    public ImEntity() {
    }

    public Integer getIndexPageUv() {
        return this.indexPageUv;
    }

    public Integer getListPageUv() {
        return this.listPageUv;
    }

    public Integer getDetailPageUv() {
        return this.detailPageUv;
    }

    public Integer getImCount() {
        return this.imCount;
    }

    public Integer getSessionCount() {
        return this.sessionCount;
    }

    public Integer getValidSessionCount() {
        return this.validSessionCount;
    }

    public Integer getInvalidSessionCount() {
        return this.invalidSessionCount;
    }

    public void setIndexPageUv(Integer indexPageUv) {
        this.indexPageUv = indexPageUv;
    }

    public void setListPageUv(Integer listPageUv) {
        this.listPageUv = listPageUv;
    }

    public void setDetailPageUv(Integer detailPageUv) {
        this.detailPageUv = detailPageUv;
    }

    public void setImCount(Integer imCount) {
        this.imCount = imCount;
    }

    public void setSessionCount(Integer sessionCount) {
        this.sessionCount = sessionCount;
    }

    public void setValidSessionCount(Integer validSessionCount) {
        this.validSessionCount = validSessionCount;
    }

    public void setInvalidSessionCount(Integer invalidSessionCount) {
        this.invalidSessionCount = invalidSessionCount;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ImEntity)) return false;
        final ImEntity other = (ImEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$indexPageUv = this.getIndexPageUv();
        final Object other$indexPageUv = other.getIndexPageUv();
        if (this$indexPageUv == null ? other$indexPageUv != null : !this$indexPageUv.equals(other$indexPageUv))
            return false;
        final Object this$listPageUv = this.getListPageUv();
        final Object other$listPageUv = other.getListPageUv();
        if (this$listPageUv == null ? other$listPageUv != null : !this$listPageUv.equals(other$listPageUv))
            return false;
        final Object this$detailPageUv = this.getDetailPageUv();
        final Object other$detailPageUv = other.getDetailPageUv();
        if (this$detailPageUv == null ? other$detailPageUv != null : !this$detailPageUv.equals(other$detailPageUv))
            return false;
        final Object this$imCount = this.getImCount();
        final Object other$imCount = other.getImCount();
        if (this$imCount == null ? other$imCount != null : !this$imCount.equals(other$imCount)) return false;
        final Object this$sessionCount = this.getSessionCount();
        final Object other$sessionCount = other.getSessionCount();
        if (this$sessionCount == null ? other$sessionCount != null : !this$sessionCount.equals(other$sessionCount))
            return false;
        final Object this$validSessionCount = this.getValidSessionCount();
        final Object other$validSessionCount = other.getValidSessionCount();
        if (this$validSessionCount == null ? other$validSessionCount != null : !this$validSessionCount.equals(other$validSessionCount))
            return false;
        final Object this$invalidSessionCount = this.getInvalidSessionCount();
        final Object other$invalidSessionCount = other.getInvalidSessionCount();
        if (this$invalidSessionCount == null ? other$invalidSessionCount != null : !this$invalidSessionCount.equals(other$invalidSessionCount))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $indexPageUv = this.getIndexPageUv();
        result = result * PRIME + ($indexPageUv == null ? 43 : $indexPageUv.hashCode());
        final Object $listPageUv = this.getListPageUv();
        result = result * PRIME + ($listPageUv == null ? 43 : $listPageUv.hashCode());
        final Object $detailPageUv = this.getDetailPageUv();
        result = result * PRIME + ($detailPageUv == null ? 43 : $detailPageUv.hashCode());
        final Object $imCount = this.getImCount();
        result = result * PRIME + ($imCount == null ? 43 : $imCount.hashCode());
        final Object $sessionCount = this.getSessionCount();
        result = result * PRIME + ($sessionCount == null ? 43 : $sessionCount.hashCode());
        final Object $validSessionCount = this.getValidSessionCount();
        result = result * PRIME + ($validSessionCount == null ? 43 : $validSessionCount.hashCode());
        final Object $invalidSessionCount = this.getInvalidSessionCount();
        result = result * PRIME + ($invalidSessionCount == null ? 43 : $invalidSessionCount.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ImEntity;
    }

    public String toString() {
        return "ImEntity(indexPageUv=" + this.getIndexPageUv() + ", listPageUv=" + this.getListPageUv() + ", detailPageUv=" + this.getDetailPageUv() + ", imCount=" + this.getImCount() + ", sessionCount=" + this.getSessionCount() + ", validSessionCount=" + this.getValidSessionCount() + ", invalidSessionCount=" + this.getInvalidSessionCount() + ")";
    }
}
