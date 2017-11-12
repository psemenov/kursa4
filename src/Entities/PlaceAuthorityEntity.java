package Entities;

import javax.persistence.*;

@Entity
@Table(name = "place_authority", schema = "public", catalog = "postgres")
public class PlaceAuthorityEntity {
    private int paId;
    private CharacterEntity characterByHead;
    private PlaceEntity placeByPlaceId;
    private NationEntity nationByNationId;
    private EpisodeEntity episodeByStart;
    private EpisodeEntity episodeByFinish;

    @Id
    @Column(name = "pa_id")
    public int getPaId() {
        return paId;
    }

    public void setPaId(int paId) {
        this.paId = paId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceAuthorityEntity that = (PlaceAuthorityEntity) o;

        if (paId != that.paId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return paId;
    }

    @ManyToOne
    @JoinColumn(name = "head", referencedColumnName = "character_id", nullable = false)
    public CharacterEntity getCharacterByHead() {
        return characterByHead;
    }

    public void setCharacterByHead(CharacterEntity characterByHead) {
        this.characterByHead = characterByHead;
    }

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "place_id", nullable = false)
    public PlaceEntity getPlaceByPlaceId() {
        return placeByPlaceId;
    }

    public void setPlaceByPlaceId(PlaceEntity placeByPlaceId) {
        this.placeByPlaceId = placeByPlaceId;
    }

    @ManyToOne
    @JoinColumn(name = "nation_id", referencedColumnName = "nation_id", nullable = false)
    public NationEntity getNationByNationId() {
        return nationByNationId;
    }

    public void setNationByNationId(NationEntity nationByNationId) {
        this.nationByNationId = nationByNationId;
    }

    @ManyToOne
    @JoinColumn(name = "start", referencedColumnName = "episode_id", nullable = false)
    public EpisodeEntity getEpisodeByStart() {
        return episodeByStart;
    }

    public void setEpisodeByStart(EpisodeEntity episodeByStart) {
        this.episodeByStart = episodeByStart;
    }

    @ManyToOne
    @JoinColumn(name = "finish", referencedColumnName = "episode_id")
    public EpisodeEntity getEpisodeByFinish() {
        return episodeByFinish;
    }

    public void setEpisodeByFinish(EpisodeEntity episodeByFinish) {
        this.episodeByFinish = episodeByFinish;
    }
}
