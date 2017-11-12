package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "character_type", schema = "public", catalog = "postgres")
public class CharacterTypeEntity {
    private int ctypeId;
    private String ctypeName;
    private String csubtypeName;
    private String ctypeDesc;
    private Collection<CharacterEntity> charactersByCtypeId;

    @Id
    @Column(name = "ctype_id")
    public int getCtypeId() {
        return ctypeId;
    }

    public void setCtypeId(int ctypeId) {
        this.ctypeId = ctypeId;
    }

    @Basic
    @Column(name = "ctype_name")
    public String getCtypeName() {
        return ctypeName;
    }

    public void setCtypeName(String ctypeName) {
        this.ctypeName = ctypeName;
    }

    @Basic
    @Column(name = "csubtype_name")
    public String getCsubtypeName() {
        return csubtypeName;
    }

    public void setCsubtypeName(String csubtypeName) {
        this.csubtypeName = csubtypeName;
    }

    @Basic
    @Column(name = "ctype_desc")
    public String getCtypeDesc() {
        return ctypeDesc;
    }

    public void setCtypeDesc(String ctypeDesc) {
        this.ctypeDesc = ctypeDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterTypeEntity that = (CharacterTypeEntity) o;

        if (ctypeId != that.ctypeId) return false;
        if (ctypeName != null ? !ctypeName.equals(that.ctypeName) : that.ctypeName != null) return false;
        if (csubtypeName != null ? !csubtypeName.equals(that.csubtypeName) : that.csubtypeName != null) return false;
        if (ctypeDesc != null ? !ctypeDesc.equals(that.ctypeDesc) : that.ctypeDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ctypeId;
        result = 31 * result + (ctypeName != null ? ctypeName.hashCode() : 0);
        result = 31 * result + (csubtypeName != null ? csubtypeName.hashCode() : 0);
        result = 31 * result + (ctypeDesc != null ? ctypeDesc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "characterTypeByCtypeId")
    public Collection<CharacterEntity> getCharactersByCtypeId() {
        return charactersByCtypeId;
    }

    public void setCharactersByCtypeId(Collection<CharacterEntity> charactersByCtypeId) {
        this.charactersByCtypeId = charactersByCtypeId;
    }
}
