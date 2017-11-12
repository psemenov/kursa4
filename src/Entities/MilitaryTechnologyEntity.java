package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "military_technology", schema = "public", catalog = "postgres")
public class MilitaryTechnologyEntity {
    private int mtechId;
    private String mtechName;
    private String mtechType;
    private String mtechDesc;
    private CharacterEntity characterByCharacterId;
    private NationEntity nationByNationId;
    private Collection<MtechcharacterEntity> mtechcharactersByMtechId;
    private Collection<MtechnationEntity> mtechnationsByMtechId;

    @Id
    @Column(name = "mtech_id")
    public int getMtechId() {
        return mtechId;
    }

    public void setMtechId(int mtechId) {
        this.mtechId = mtechId;
    }

    @Basic
    @Column(name = "mtech_name")
    public String getMtechName() {
        return mtechName;
    }

    public void setMtechName(String mtechName) {
        this.mtechName = mtechName;
    }

    @Basic
    @Column(name = "mtech_type")
    public String getMtechType() {
        return mtechType;
    }

    public void setMtechType(String mtechType) {
        this.mtechType = mtechType;
    }

    @Basic
    @Column(name = "mtech_desc")
    public String getMtechDesc() {
        return mtechDesc;
    }

    public void setMtechDesc(String mtechDesc) {
        this.mtechDesc = mtechDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MilitaryTechnologyEntity that = (MilitaryTechnologyEntity) o;

        if (mtechId != that.mtechId) return false;
        if (mtechName != null ? !mtechName.equals(that.mtechName) : that.mtechName != null) return false;
        if (mtechType != null ? !mtechType.equals(that.mtechType) : that.mtechType != null) return false;
        if (mtechDesc != null ? !mtechDesc.equals(that.mtechDesc) : that.mtechDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mtechId;
        result = 31 * result + (mtechName != null ? mtechName.hashCode() : 0);
        result = 31 * result + (mtechType != null ? mtechType.hashCode() : 0);
        result = 31 * result + (mtechDesc != null ? mtechDesc.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "character_id", referencedColumnName = "character_id")
    public CharacterEntity getCharacterByCharacterId() {
        return characterByCharacterId;
    }

    public void setCharacterByCharacterId(CharacterEntity characterByCharacterId) {
        this.characterByCharacterId = characterByCharacterId;
    }

    @ManyToOne
    @JoinColumn(name = "nation_id", referencedColumnName = "nation_id")
    public NationEntity getNationByNationId() {
        return nationByNationId;
    }

    public void setNationByNationId(NationEntity nationByNationId) {
        this.nationByNationId = nationByNationId;
    }

    @OneToMany(mappedBy = "militaryTechnologyByMtechId")
    public Collection<MtechcharacterEntity> getMtechcharactersByMtechId() {
        return mtechcharactersByMtechId;
    }

    public void setMtechcharactersByMtechId(Collection<MtechcharacterEntity> mtechcharactersByMtechId) {
        this.mtechcharactersByMtechId = mtechcharactersByMtechId;
    }

    @OneToMany(mappedBy = "militaryTechnologyByMtechId")
    public Collection<MtechnationEntity> getMtechnationsByMtechId() {
        return mtechnationsByMtechId;
    }

    public void setMtechnationsByMtechId(Collection<MtechnationEntity> mtechnationsByMtechId) {
        this.mtechnationsByMtechId = mtechnationsByMtechId;
    }
}
