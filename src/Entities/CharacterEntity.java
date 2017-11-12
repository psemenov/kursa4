package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "character", schema = "public", catalog = "postgres")
public class CharacterEntity {
    private int characterId;
    private String name;
    private String gender;
    private CharacterTypeEntity characterTypeByCtypeId;
    private MagicEntity magicByMId;
    private NationEntity nationByNationId;
    private EpisodeEntity episodeByEpisodeId;
    private CharacterorganizationEntity characterorganizationByCharacterId;
    private Collection<MilitaryTechnologyEntity> militaryTechnologiesByCharacterId;
    private Collection<MtechcharacterEntity> mtechcharactersByCharacterId;
    private Collection<NationleaderEntity> nationleadersByCharacterId;
    private Collection<OrganizationEntity> organizationsByCharacterId;
    private Collection<OrganizationEntity> organizationsByCharacterId_0;
    private Collection<PlaceAuthorityEntity> placeAuthoritiesByCharacterId;
    private Collection<UniqueSkillsEntity> uniqueSkillsByCharacterId;

    @Id
    @Column(name = "character_id")
    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterEntity that = (CharacterEntity) o;

        if (characterId != that.characterId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = characterId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ctype_id", referencedColumnName = "ctype_id", nullable = false)
    public CharacterTypeEntity getCharacterTypeByCtypeId() {
        return characterTypeByCtypeId;
    }

    public void setCharacterTypeByCtypeId(CharacterTypeEntity characterTypeByCtypeId) {
        this.characterTypeByCtypeId = characterTypeByCtypeId;
    }

    @ManyToOne
    @JoinColumn(name = "m_id", referencedColumnName = "m_id")
    public MagicEntity getMagicByMId() {
        return magicByMId;
    }

    public void setMagicByMId(MagicEntity magicByMId) {
        this.magicByMId = magicByMId;
    }

    @ManyToOne
    @JoinColumn(name = "nation_id", referencedColumnName = "nation_id")
    public NationEntity getNationByNationId() {
        return nationByNationId;
    }

    public void setNationByNationId(NationEntity nationByNationId) {
        this.nationByNationId = nationByNationId;
    }

    @ManyToOne
    @JoinColumn(name = "episode_id", referencedColumnName = "episode_id", nullable = false)
    public EpisodeEntity getEpisodeByEpisodeId() {
        return episodeByEpisodeId;
    }

    public void setEpisodeByEpisodeId(EpisodeEntity episodeByEpisodeId) {
        this.episodeByEpisodeId = episodeByEpisodeId;
    }

    @OneToOne(mappedBy = "characterByMember")
    public CharacterorganizationEntity getCharacterorganizationByCharacterId() {
        return characterorganizationByCharacterId;
    }

    public void setCharacterorganizationByCharacterId(CharacterorganizationEntity characterorganizationByCharacterId) {
        this.characterorganizationByCharacterId = characterorganizationByCharacterId;
    }

    @OneToMany(mappedBy = "characterByCharacterId")
    public Collection<MilitaryTechnologyEntity> getMilitaryTechnologiesByCharacterId() {
        return militaryTechnologiesByCharacterId;
    }

    public void setMilitaryTechnologiesByCharacterId(Collection<MilitaryTechnologyEntity> militaryTechnologiesByCharacterId) {
        this.militaryTechnologiesByCharacterId = militaryTechnologiesByCharacterId;
    }

    @OneToMany(mappedBy = "characterByCharacterId")
    public Collection<MtechcharacterEntity> getMtechcharactersByCharacterId() {
        return mtechcharactersByCharacterId;
    }

    public void setMtechcharactersByCharacterId(Collection<MtechcharacterEntity> mtechcharactersByCharacterId) {
        this.mtechcharactersByCharacterId = mtechcharactersByCharacterId;
    }

    @OneToMany(mappedBy = "characterByLeader")
    public Collection<NationleaderEntity> getNationleadersByCharacterId() {
        return nationleadersByCharacterId;
    }

    public void setNationleadersByCharacterId(Collection<NationleaderEntity> nationleadersByCharacterId) {
        this.nationleadersByCharacterId = nationleadersByCharacterId;
    }

    @OneToMany(mappedBy = "characterByFounder")
    public Collection<OrganizationEntity> getOrganizationsByCharacterId() {
        return organizationsByCharacterId;
    }

    public void setOrganizationsByCharacterId(Collection<OrganizationEntity> organizationsByCharacterId) {
        this.organizationsByCharacterId = organizationsByCharacterId;
    }

    @OneToMany(mappedBy = "characterByLeader")
    public Collection<OrganizationEntity> getOrganizationsByCharacterId_0() {
        return organizationsByCharacterId_0;
    }

    public void setOrganizationsByCharacterId_0(Collection<OrganizationEntity> organizationsByCharacterId_0) {
        this.organizationsByCharacterId_0 = organizationsByCharacterId_0;
    }

    @OneToMany(mappedBy = "characterByHead")
    public Collection<PlaceAuthorityEntity> getPlaceAuthoritiesByCharacterId() {
        return placeAuthoritiesByCharacterId;
    }

    public void setPlaceAuthoritiesByCharacterId(Collection<PlaceAuthorityEntity> placeAuthoritiesByCharacterId) {
        this.placeAuthoritiesByCharacterId = placeAuthoritiesByCharacterId;
    }

    @OneToMany(mappedBy = "characterByCharacterId")
    public Collection<UniqueSkillsEntity> getUniqueSkillsByCharacterId() {
        return uniqueSkillsByCharacterId;
    }

    public void setUniqueSkillsByCharacterId(Collection<UniqueSkillsEntity> uniqueSkillsByCharacterId) {
        this.uniqueSkillsByCharacterId = uniqueSkillsByCharacterId;
    }
}
