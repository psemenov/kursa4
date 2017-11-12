package Entities;

import javax.persistence.*;

@Entity
@Table(name = "magic_basic", schema = "public", catalog = "postgres")
public class MagicBasicEntity {
    private int mbasicId;
    private String mbasicName;
    private String mbasicDesc;
    private MagicEntity magicByMId;

    @Id
    @Column(name = "mbasic_id")
    public int getMbasicId() {
        return mbasicId;
    }

    public void setMbasicId(int mbasicId) {
        this.mbasicId = mbasicId;
    }

    @Basic
    @Column(name = "mbasic_name")
    public String getMbasicName() {
        return mbasicName;
    }

    public void setMbasicName(String mbasicName) {
        this.mbasicName = mbasicName;
    }

    @Basic
    @Column(name = "mbasic_desc")
    public String getMbasicDesc() {
        return mbasicDesc;
    }

    public void setMbasicDesc(String mbasicDesc) {
        this.mbasicDesc = mbasicDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MagicBasicEntity that = (MagicBasicEntity) o;

        if (mbasicId != that.mbasicId) return false;
        if (mbasicName != null ? !mbasicName.equals(that.mbasicName) : that.mbasicName != null) return false;
        if (mbasicDesc != null ? !mbasicDesc.equals(that.mbasicDesc) : that.mbasicDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mbasicId;
        result = 31 * result + (mbasicName != null ? mbasicName.hashCode() : 0);
        result = 31 * result + (mbasicDesc != null ? mbasicDesc.hashCode() : 0);
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
}
