package Entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class MtechcharacterEntityPK implements Serializable {
    private int mtechId;
    private int characterId;

    @Column(name = "mtech_id")
    @Id
    public int getMtechId() {
        return mtechId;
    }

    public void setMtechId(int mtechId) {
        this.mtechId = mtechId;
    }

    @Column(name = "character_id")
    @Id
    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MtechcharacterEntityPK that = (MtechcharacterEntityPK) o;

        if (mtechId != that.mtechId) return false;
        if (characterId != that.characterId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mtechId;
        result = 31 * result + characterId;
        return result;
    }
}
