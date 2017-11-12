package Entities;

import javax.persistence.*;

@Entity
@Table(name = "magic_skills", schema = "public", catalog = "postgres")
public class MagicSkillsEntity {
    private int mskillId;
    private String mskillName;
    private String mskillLevel;
    private String mskillDesc;
    private MagicEntity magicByMId;

    @Id
    @Column(name = "mskill_id")
    public int getMskillId() {
        return mskillId;
    }

    public void setMskillId(int mskillId) {
        this.mskillId = mskillId;
    }

    @Basic
    @Column(name = "mskill_name")
    public String getMskillName() {
        return mskillName;
    }

    public void setMskillName(String mskillName) {
        this.mskillName = mskillName;
    }

    @Basic
    @Column(name = "mskill_level")
    public String getMskillLevel() {
        return mskillLevel;
    }

    public void setMskillLevel(String mskillLevel) {
        this.mskillLevel = mskillLevel;
    }

    @Basic
    @Column(name = "mskill_desc")
    public String getMskillDesc() {
        return mskillDesc;
    }

    public void setMskillDesc(String mskillDesc) {
        this.mskillDesc = mskillDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MagicSkillsEntity that = (MagicSkillsEntity) o;

        if (mskillId != that.mskillId) return false;
        if (mskillName != null ? !mskillName.equals(that.mskillName) : that.mskillName != null) return false;
        if (mskillLevel != null ? !mskillLevel.equals(that.mskillLevel) : that.mskillLevel != null) return false;
        if (mskillDesc != null ? !mskillDesc.equals(that.mskillDesc) : that.mskillDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mskillId;
        result = 31 * result + (mskillName != null ? mskillName.hashCode() : 0);
        result = 31 * result + (mskillLevel != null ? mskillLevel.hashCode() : 0);
        result = 31 * result + (mskillDesc != null ? mskillDesc.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "m_id", referencedColumnName = "m_id", nullable = false)
    public MagicEntity getMagicByMId() {
        return magicByMId;
    }

    public void setMagicByMId(MagicEntity magicByMId) {
        this.magicByMId = magicByMId;
    }
}
