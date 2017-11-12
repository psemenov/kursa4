package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "nation", schema = "public", catalog = "postgres")
public class NationEntity {
    private int nationId;
    private String nationName;
    private Integer placeId;
    private String regime;
    private String nDesc;
    private Collection<CharacterEntity> charactersByNationId;
    private Collection<MilitaryTechnologyEntity> militaryTechnologiesByNationId;
    private Collection<MtechnationEntity> mtechnationsByNationId;
    private MagicEntity magicByMId;
    private NationleaderEntity nationleaderByNationId;
    private Collection<PlaceAuthorityEntity> placeAuthoritiesByNationId;

    @Id
    @Column(name = "nation_id")
    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    @Basic
    @Column(name = "nation_name")
    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    @Basic
    @Column(name = "place_id")
    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "regime")
    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    @Basic
    @Column(name = "n_desc")
    public String getnDesc() {
        return nDesc;
    }

    public void setnDesc(String nDesc) {
        this.nDesc = nDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NationEntity that = (NationEntity) o;

        if (nationId != that.nationId) return false;
        if (nationName != null ? !nationName.equals(that.nationName) : that.nationName != null) return false;
        if (placeId != null ? !placeId.equals(that.placeId) : that.placeId != null) return false;
        if (regime != null ? !regime.equals(that.regime) : that.regime != null) return false;
        if (nDesc != null ? !nDesc.equals(that.nDesc) : that.nDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nationId;
        result = 31 * result + (nationName != null ? nationName.hashCode() : 0);
        result = 31 * result + (placeId != null ? placeId.hashCode() : 0);
        result = 31 * result + (regime != null ? regime.hashCode() : 0);
        result = 31 * result + (nDesc != null ? nDesc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "nationByNationId")
    public Collection<CharacterEntity> getCharactersByNationId() {
        return charactersByNationId;
    }

    public void setCharactersByNationId(Collection<CharacterEntity> charactersByNationId) {
        this.charactersByNationId = charactersByNationId;
    }

    @OneToMany(mappedBy = "nationByNationId")
    public Collection<MilitaryTechnologyEntity> getMilitaryTechnologiesByNationId() {
        return militaryTechnologiesByNationId;
    }

    public void setMilitaryTechnologiesByNationId(Collection<MilitaryTechnologyEntity> militaryTechnologiesByNationId) {
        this.militaryTechnologiesByNationId = militaryTechnologiesByNationId;
    }

    @OneToMany(mappedBy = "nationByNationId")
    public Collection<MtechnationEntity> getMtechnationsByNationId() {
        return mtechnationsByNationId;
    }

    public void setMtechnationsByNationId(Collection<MtechnationEntity> mtechnationsByNationId) {
        this.mtechnationsByNationId = mtechnationsByNationId;
    }

    @ManyToOne
    @JoinColumn(name = "m_id", referencedColumnName = "m_id", nullable = false)
    public MagicEntity getMagicByMId() {
        return magicByMId;
    }

    public void setMagicByMId(MagicEntity magicByMId) {
        this.magicByMId = magicByMId;
    }

    @OneToOne(mappedBy = "nationByNationId")
    public NationleaderEntity getNationleaderByNationId() {
        return nationleaderByNationId;
    }

    public void setNationleaderByNationId(NationleaderEntity nationleaderByNationId) {
        this.nationleaderByNationId = nationleaderByNationId;
    }

    @OneToMany(mappedBy = "nationByNationId")
    public Collection<PlaceAuthorityEntity> getPlaceAuthoritiesByNationId() {
        return placeAuthoritiesByNationId;
    }

    public void setPlaceAuthoritiesByNationId(Collection<PlaceAuthorityEntity> placeAuthoritiesByNationId) {
        this.placeAuthoritiesByNationId = placeAuthoritiesByNationId;
    }
}
