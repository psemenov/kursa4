package Entities;

import javax.persistence.*;

@Entity
@Table(name = "unique_skills", schema = "public", catalog = "postgres")
public class UniqueSkillsEntity {
    private int uskillId;
    private String uskillName;
    private String uskillDesc;
    private MagicEntity magicByMId;
    private CharacterEntity characterByCharacterId;

    @Id
    @Column(name = "uskill_id")
    public int getUskillId() {
        return uskillId;
    }

    public void setUskillId(int uskillId) {
        this.uskillId = uskillId;
    }

    @Basic
    @Column(name = "uskill_name")
    public String getUskillName() {
        return uskillName;
    }

    public void setUskillName(String uskillName) {
        this.uskillName = uskillName;
    }

    @Basic
    @Column(name = "uskill_desc")
    public String getUskillDesc() {
        return uskillDesc;
    }

    public void setUskillDesc(String uskillDesc) {
        this.uskillDesc = uskillDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UniqueSkillsEntity that = (UniqueSkillsEntity) o;

        if (uskillId != that.uskillId) return false;
        if (uskillName != null ? !uskillName.equals(that.uskillName) : that.uskillName != null) return false;
        if (uskillDesc != null ? !uskillDesc.equals(that.uskillDesc) : that.uskillDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uskillId;
        result = 31 * result + (uskillName != null ? uskillName.hashCode() : 0);
        result = 31 * result + (uskillDesc != null ? uskillDesc.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "m_id", referencedColumnName = "m_id")
    public MagicEntity getMagicByMId() {
        return magicByMId;
    }

    public void setMagicByMId(MagicEntity magicByMId) {
        this.magicByMId = magicByMId;
    }

    @ManyToOne
    @JoinColumn(name = "character_id", referencedColumnName = "character_id")
    public CharacterEntity getCharacterByCharacterId() {
        return characterByCharacterId;
    }

    public void setCharacterByCharacterId(CharacterEntity characterByCharacterId) {
        this.characterByCharacterId = characterByCharacterId;
    }
}
