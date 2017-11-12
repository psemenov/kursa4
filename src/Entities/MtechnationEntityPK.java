package Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MtechnationEntityPK implements Serializable {
    private int mtechId;
    private int nationId;

    @Column(name = "mtech_id")
    @Id
    public int getMtechId() {
        return mtechId;
    }

    public void setMtechId(int mtechId) {
        this.mtechId = mtechId;
    }

    @Column(name = "nation_id")
    @Id
    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MtechnationEntityPK that = (MtechnationEntityPK) o;

        if (mtechId != that.mtechId) return false;
        if (nationId != that.nationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mtechId;
        result = 31 * result + nationId;
        return result;
    }
}
