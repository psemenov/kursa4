package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "place", schema = "public", catalog = "postgres")
public class PlaceEntity {
    private int placeId;
    private String placeName;
    private String details;
    private boolean status;
    private String regime;
    private Collection<OrganizationEntity> organizationsByPlaceId;
    private PlaceEntity placeByLocationId;
    private Collection<PlaceEntity> placesByPlaceId;
    private EpisodeEntity episodeByEpisodeId;
    private Collection<PlaceAuthorityEntity> placeAuthoritiesByPlaceId;

    @Id
    @Column(name = "place_id")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "place_name")
    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Basic
    @Column(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Basic
    @Column(name = "status")
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "regime")
    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceEntity that = (PlaceEntity) o;

        if (placeId != that.placeId) return false;
        if (status != that.status) return false;
        if (placeName != null ? !placeName.equals(that.placeName) : that.placeName != null) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;
        if (regime != null ? !regime.equals(that.regime) : that.regime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = placeId;
        result = 31 * result + (placeName != null ? placeName.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        result = 31 * result + (status ? 1 : 0);
        result = 31 * result + (regime != null ? regime.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "placeByHq")
    public Collection<OrganizationEntity> getOrganizationsByPlaceId() {
        return organizationsByPlaceId;
    }

    public void setOrganizationsByPlaceId(Collection<OrganizationEntity> organizationsByPlaceId) {
        this.organizationsByPlaceId = organizationsByPlaceId;
    }

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "place_id")
    public PlaceEntity getPlaceByLocationId() {
        return placeByLocationId;
    }

    public void setPlaceByLocationId(PlaceEntity placeByLocationId) {
        this.placeByLocationId = placeByLocationId;
    }

    @OneToMany(mappedBy = "placeByLocationId")
    public Collection<PlaceEntity> getPlacesByPlaceId() {
        return placesByPlaceId;
    }

    public void setPlacesByPlaceId(Collection<PlaceEntity> placesByPlaceId) {
        this.placesByPlaceId = placesByPlaceId;
    }

    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "episode_id")
    public EpisodeEntity getEpisodeByEpisodeId() {
        return episodeByEpisodeId;
    }

    public void setEpisodeByEpisodeId(EpisodeEntity episodeByEpisodeId) {
        this.episodeByEpisodeId = episodeByEpisodeId;
    }

    @OneToMany(mappedBy = "placeByPlaceId")
    public Collection<PlaceAuthorityEntity> getPlaceAuthoritiesByPlaceId() {
        return placeAuthoritiesByPlaceId;
    }

    public void setPlaceAuthoritiesByPlaceId(Collection<PlaceAuthorityEntity> placeAuthoritiesByPlaceId) {
        this.placeAuthoritiesByPlaceId = placeAuthoritiesByPlaceId;
    }
}
