package Entities;

import javax.persistence.*;

@Entity
@Table(name = "mtechcharacter", schema = "public", catalog = "postgres")
@IdClass(MtechcharacterEntityPK.class)
public class MtechcharacterEntity {
    private int mtechId;
    private int characterId;
    private MilitaryTechnologyEntity militaryTechnologyByMtechId;
    private CharacterEntity characterByCharacterId;

    @Id
    @Column(name = "mtech_id")
    public int getMtechId() {
        return mtechId;
    }

    public void setMtechId(int mtechId) {
        this.mtechId = mtechId;
    }

    @Id
    @Column(name = "character_id")
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

        MtechcharacterEntity that = (MtechcharacterEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "mtech_id", referencedColumnName = "mtech_id", nullable = false, insertable = false, updatable = false)
    public MilitaryTechnologyEntity getMilitaryTechnologyByMtechId() {
        return militaryTechnologyByMtechId;
    }

    public void setMilitaryTechnologyByMtechId(MilitaryTechnologyEntity militaryTechnologyByMtechId) {
        this.militaryTechnologyByMtechId = militaryTechnologyByMtechId;
    }

    @ManyToOne
    @JoinColumn(name = "character_id", referencedColumnName = "character_id", nullable = false, insertable = false, updatable = false)
    public CharacterEntity getCharacterByCharacterId() {
        return characterByCharacterId;
    }

    public void setCharacterByCharacterId(CharacterEntity characterByCharacterId) {
        this.characterByCharacterId = characterByCharacterId;
    }
}
