package com.fang.bigdata.metadata.entity.imstatics;

/**
 * @project:metadata
 * @packname:com.fang.bigdata.metadata.entity
 * @name: ProjnameImEntity
 * @describe:
 * @author: niujiaxin
 * @create: 2018-12-26-19:35
 */
public class ProjnameImEntity {
    private String city;
    private String projname;
    private Integer imchats;

    public ProjnameImEntity() {
    }

    public String getCity() {
        return this.city;
    }

    public String getProjname() {
        return this.projname;
    }

    public Integer getImchats() {
        return this.imchats;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProjname(String projname) {
        this.projname = projname;
    }

    public void setImchats(Integer imchats) {
        this.imchats = imchats;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ProjnameImEntity)) return false;
        final ProjnameImEntity other = (ProjnameImEntity) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$city = this.getCity();
        final Object other$city = other.getCity();
        if (this$city == null ? other$city != null : !this$city.equals(other$city)) return false;
        final Object this$projname = this.getProjname();
        final Object other$projname = other.getProjname();
        if (this$projname == null ? other$projname != null : !this$projname.equals(other$projname)) return false;
        final Object this$imchats = this.getImchats();
        final Object other$imchats = other.getImchats();
        if (this$imchats == null ? other$imchats != null : !this$imchats.equals(other$imchats)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $city = this.getCity();
        result = result * PRIME + ($city == null ? 43 : $city.hashCode());
        final Object $projname = this.getProjname();
        result = result * PRIME + ($projname == null ? 43 : $projname.hashCode());
        final Object $imchats = this.getImchats();
        result = result * PRIME + ($imchats == null ? 43 : $imchats.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ProjnameImEntity;
    }

    public String toString() {
        return "ProjnameImEntity(city=" + this.getCity() + ", projname=" + this.getProjname() + ", imchats=" + this.getImchats() + ")";
    }
}
