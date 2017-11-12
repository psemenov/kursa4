package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "magic_base", schema = "public", catalog = "postgres")
public class MagicBaseEntity {
    private int mBaseId;
    private String mbaseName;
    private String mbaseDesc;
    private Collection<MagicEntity> magicsByMBaseId;

    @Id
    @Column(name = "m_base_id")
    public int getmBaseId() {
        return mBaseId;
    }

    public void setmBaseId(int mBaseId) {
        this.mBaseId = mBaseId;
    }

    @Basic
    @Column(name = "mbase_name")
    public String getMbaseName() {
        return mbaseName;
    }

    public void setMbaseName(String mbaseName) {
        this.mbaseName = mbaseName;
    }

    @Basic
    @Column(name = "mbase_desc")
    public String getMbaseDesc() {
        return mbaseDesc;
    }

    public void setMbaseDesc(String mbaseDesc) {
        this.mbaseDesc = mbaseDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MagicBaseEntity that = (MagicBaseEntity) o;

        if (mBaseId != that.mBaseId) return false;
        if (mbaseName != null ? !mbaseName.equals(that.mbaseName) : that.mbaseName != null) return false;
        if (mbaseDesc != null ? !mbaseDesc.equals(that.mbaseDesc) : that.mbaseDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mBaseId;
        result = 31 * result + (mbaseName != null ? mbaseName.hashCode() : 0);
        result = 31 * result + (mbaseDesc != null ? mbaseDesc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "magicBaseByMBase")
    public Collection<MagicEntity> getMagicsByMBaseId() {
        return magicsByMBaseId;
    }

    public void setMagicsByMBaseId(Collection<MagicEntity> magicsByMBaseId) {
        this.magicsByMBaseId = magicsByMBaseId;
    }
}
