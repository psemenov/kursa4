package Entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "episode", schema = "public", catalog = "postgres")
public class EpisodeEntity {
    private int episodeId;
    private String eName;
    private Date releaseDate;
    private int eNumber;
    private String eDesc;
    private Collection<CharacterEntity> charactersByEpisodeId;
    private BookEntity bookByBookId;
    private Collection<OrganizationEntity> organizationsByEpisodeId;
    private Collection<PlaceEntity> placesByEpisodeId;
    private Collection<PlaceAuthorityEntity> placeAuthoritiesByEpisodeId;
    private Collection<PlaceAuthorityEntity> placeAuthoritiesByEpisodeId_0;

    @Id
    @Column(name = "episode_id")
    public int getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(int episodeId) {
        this.episodeId = episodeId;
    }

    @Basic
    @Column(name = "e_name")
    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    @Basic
    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Basic
    @Column(name = "e_number")
    public int geteNumber() {
        return eNumber;
    }

    public void seteNumber(int eNumber) {
        this.eNumber = eNumber;
    }

    @Basic
    @Column(name = "e_desc")
    public String geteDesc() {
        return eDesc;
    }

    public void seteDesc(String eDesc) {
        this.eDesc = eDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EpisodeEntity that = (EpisodeEntity) o;

        if (episodeId != that.episodeId) return false;
        if (eNumber != that.eNumber) return false;
        if (eName != null ? !eName.equals(that.eName) : that.eName != null) return false;
        if (releaseDate != null ? !releaseDate.equals(that.releaseDate) : that.releaseDate != null) return false;
        if (eDesc != null ? !eDesc.equals(that.eDesc) : that.eDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = episodeId;
        result = 31 * result + (eName != null ? eName.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + eNumber;
        result = 31 * result + (eDesc != null ? eDesc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "episodeByEpisodeId")
    public Collection<CharacterEntity> getCharactersByEpisodeId() {
        return charactersByEpisodeId;
    }

    public void setCharactersByEpisodeId(Collection<CharacterEntity> charactersByEpisodeId) {
        this.charactersByEpisodeId = charactersByEpisodeId;
    }

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "book_id", nullable = false)
    public BookEntity getBookByBookId() {
        return bookByBookId;
    }

    public void setBookByBookId(BookEntity bookByBookId) {
        this.bookByBookId = bookByBookId;
    }

    @OneToMany(mappedBy = "episodeByEpisodeId")
    public Collection<OrganizationEntity> getOrganizationsByEpisodeId() {
        return organizationsByEpisodeId;
    }

    public void setOrganizationsByEpisodeId(Collection<OrganizationEntity> organizationsByEpisodeId) {
        this.organizationsByEpisodeId = organizationsByEpisodeId;
    }

    @OneToMany(mappedBy = "episodeByEpisodeId")
    public Collection<PlaceEntity> getPlacesByEpisodeId() {
        return placesByEpisodeId;
    }

    public void setPlacesByEpisodeId(Collection<PlaceEntity> placesByEpisodeId) {
        this.placesByEpisodeId = placesByEpisodeId;
    }

    @OneToMany(mappedBy = "episodeByStart")
    public Collection<PlaceAuthorityEntity> getPlaceAuthoritiesByEpisodeId() {
        return placeAuthoritiesByEpisodeId;
    }

    public void setPlaceAuthoritiesByEpisodeId(Collection<PlaceAuthorityEntity> placeAuthoritiesByEpisodeId) {
        this.placeAuthoritiesByEpisodeId = placeAuthoritiesByEpisodeId;
    }

    @OneToMany(mappedBy = "episodeByFinish")
    public Collection<PlaceAuthorityEntity> getPlaceAuthoritiesByEpisodeId_0() {
        return placeAuthoritiesByEpisodeId_0;
    }

    public void setPlaceAuthoritiesByEpisodeId_0(Collection<PlaceAuthorityEntity> placeAuthoritiesByEpisodeId_0) {
        this.placeAuthoritiesByEpisodeId_0 = placeAuthoritiesByEpisodeId_0;
    }
}
