package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "organization", schema = "public", catalog = "postgres")
public class OrganizationEntity {
    private String orgName;
    private String orgDesc;
    private Collection<CharacterorganizationEntity> characterorganizationsByOrgName;
    private CharacterEntity characterByFounder;
    private CharacterEntity characterByLeader;
    private PlaceEntity placeByHq;
    private EpisodeEntity episodeByEpisodeId;

    @Id
    @Column(name = "org_name")
    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "org_desc")
    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationEntity that = (OrganizationEntity) o;

        if (orgName != null ? !orgName.equals(that.orgName) : that.orgName != null) return false;
        if (orgDesc != null ? !orgDesc.equals(that.orgDesc) : that.orgDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orgName != null ? orgName.hashCode() : 0;
        result = 31 * result + (orgDesc != null ? orgDesc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "organizationByOrgName")
    public Collection<CharacterorganizationEntity> getCharacterorganizationsByOrgName() {
        return characterorganizationsByOrgName;
    }

    public void setCharacterorganizationsByOrgName(Collection<CharacterorganizationEntity> characterorganizationsByOrgName) {
        this.characterorganizationsByOrgName = characterorganizationsByOrgName;
    }

    @ManyToOne
    @JoinColumn(name = "founder", referencedColumnName = "character_id", nullable = false)
    public CharacterEntity getCharacterByFounder() {
        return characterByFounder;
    }

    public void setCharacterByFounder(CharacterEntity characterByFounder) {
        this.characterByFounder = characterByFounder;
    }

    @ManyToOne
    @JoinColumn(name = "leader", referencedColumnName = "character_id", nullable = false)
    public CharacterEntity getCharacterByLeader() {
        return characterByLeader;
    }

    public void setCharacterByLeader(CharacterEntity characterByLeader) {
        this.characterByLeader = characterByLeader;
    }

    @ManyToOne
    @JoinColumn(name = "hq", referencedColumnName = "place_id")
    public PlaceEntity getPlaceByHq() {
        return placeByHq;
    }

    public void setPlaceByHq(PlaceEntity placeByHq) {
        this.placeByHq = placeByHq;
    }

    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "episode_id", nullable = false)
    public EpisodeEntity getEpisodeByEpisodeId() {
        return episodeByEpisodeId;
    }

    public void setEpisodeByEpisodeId(EpisodeEntity episodeByEpisodeId) {
        this.episodeByEpisodeId = episodeByEpisodeId;
    }
}
