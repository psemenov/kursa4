package Entities;

import javax.persistence.*;

@Entity
@Table(name = "mtechnation", schema = "public", catalog = "postgres")
@IdClass(MtechnationEntityPK.class)
public class MtechnationEntity {
    private int mtechId;
    private int nationId;
    private MilitaryTechnologyEntity militaryTechnologyByMtechId;
    private NationEntity nationByNationId;

    @Id
    @Column(name = "mtech_id")
    public int getMtechId() {
        return mtechId;
    }

    public void setMtechId(int mtechId) {
        this.mtechId = mtechId;
    }

    @Id
    @Column(name = "nation_id")
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

        MtechnationEntity that = (MtechnationEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "mtech_id", referencedColumnName = "mtech_id", nullable = false)
    public MilitaryTechnologyEntity getMilitaryTechnologyByMtechId() {
        return militaryTechnologyByMtechId;
    }

    public void setMilitaryTechnologyByMtechId(MilitaryTechnologyEntity militaryTechnologyByMtechId) {
        this.militaryTechnologyByMtechId = militaryTechnologyByMtechId;
    }

    @ManyToOne
    @JoinColumn(name = "nation_id", referencedColumnName = "nation_id", nullable = false)
    public NationEntity getNationByNationId() {
        return nationByNationId;
    }

    public void setNationByNationId(NationEntity nationByNationId) {
        this.nationByNationId = nationByNationId;
    }
}
