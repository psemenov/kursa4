package Entities;

import javax.persistence.*;

@Entity
@Table(name = "nationleader", schema = "public", catalog = "postgres")
public class NationleaderEntity {
    private int nationId;
    private NationEntity nationByNationId;
    private CharacterEntity characterByLeader;

    @Id
    @Column(name = "nation_id")
    public int getNationId() {
        return nationId;
    }

    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NationleaderEntity that = (NationleaderEntity) o;

        if (nationId != that.nationId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nationId;
    }

    @OneToOne
    @JoinColumn(name = "nation_id", referencedColumnName = "nation_id", nullable = false)
    public NationEntity getNationByNationId() {
        return nationByNationId;
    }

    public void setNationByNationId(NationEntity nationByNationId) {
        this.nationByNationId = nationByNationId;
    }

    @ManyToOne
    @JoinColumn(name = "leader", referencedColumnName = "character_id")
    public CharacterEntity getCharacterByLeader() {
        return characterByLeader;
    }

    public void setCharacterByLeader(CharacterEntity characterByLeader) {
        this.characterByLeader = characterByLeader;
    }
}
