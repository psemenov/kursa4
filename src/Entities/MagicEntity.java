package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "magic", schema = "public", catalog = "postgres")
public class MagicEntity {
    private int mId;
    private String mType;
    private String mDesc;
    private Collection<CharacterEntity> charactersByMId;
    private MagicBaseEntity magicBaseByMBase;
    private Collection<MagicBasicEntity> magicBasicsByMId;
    private Collection<MagicSkillsEntity> magicSkillsByMId;
    private Collection<NationEntity> nationsByMId;
    private Collection<UniqueSkillsEntity> uniqueSkillsByMId;

    @Id
    @Column(name = "m_id")
    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    @Basic
    @Column(name = "m_type")
    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    @Basic
    @Column(name = "m_desc")
    public String getmDesc() {
        return mDesc;
    }

    public void setmDesc(String mDesc) {
        this.mDesc = mDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MagicEntity that = (MagicEntity) o;

        if (mId != that.mId) return false;
        if (mType != null ? !mType.equals(that.mType) : that.mType != null) return false;
        if (mDesc != null ? !mDesc.equals(that.mDesc) : that.mDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mId;
        result = 31 * result + (mType != null ? mType.hashCode() : 0);
        result = 31 * result + (mDesc != null ? mDesc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "magicByMId")
    public Collection<CharacterEntity> getCharactersByMId() {
        return charactersByMId;
    }

    public void setCharactersByMId(Collection<CharacterEntity> charactersByMId) {
        this.charactersByMId = charactersByMId;
    }

    @ManyToOne
    @JoinColumn(name = "m_base", referencedColumnName = "m_base_id")
    public MagicBaseEntity getMagicBaseByMBase() {
        return magicBaseByMBase;
    }

    public void setMagicBaseByMBase(MagicBaseEntity magicBaseByMBase) {
        this.magicBaseByMBase = magicBaseByMBase;
    }

    @OneToMany(mappedBy = "magicByMId")
    public Collection<MagicBasicEntity> getMagicBasicsByMId() {
        return magicBasicsByMId;
    }

    public void setMagicBasicsByMId(Collection<MagicBasicEntity> magicBasicsByMId) {
        this.magicBasicsByMId = magicBasicsByMId;
    }

    @OneToMany(mappedBy = "magicByMId")
    public Collection<MagicSkillsEntity> getMagicSkillsByMId() {
        return magicSkillsByMId;
    }

    public void setMagicSkillsByMId(Collection<MagicSkillsEntity> magicSkillsByMId) {
        this.magicSkillsByMId = magicSkillsByMId;
    }

    @OneToMany(mappedBy = "magicByMId")
    public Collection<NationEntity> getNationsByMId() {
        return nationsByMId;
    }

    public void setNationsByMId(Collection<NationEntity> nationsByMId) {
        this.nationsByMId = nationsByMId;
    }

    @OneToMany(mappedBy = "magicByMId")
    public Collection<UniqueSkillsEntity> getUniqueSkillsByMId() {
        return uniqueSkillsByMId;
    }

    public void setUniqueSkillsByMId(Collection<UniqueSkillsEntity> uniqueSkillsByMId) {
        this.uniqueSkillsByMId = uniqueSkillsByMId;
    }
}
