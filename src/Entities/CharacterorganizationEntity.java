package Entities;

import javax.persistence.*;

@Entity
@Table(name = "characterorganization", schema = "public", catalog = "postgres")
public class CharacterorganizationEntity {
    private int member;
    private CharacterEntity characterByMember;
    private OrganizationEntity organizationByOrgName;

    @Id
    @Column(name = "member")
    public int getMember() {
        return member;
    }

    public void setMember(int member) {
        this.member = member;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterorganizationEntity that = (CharacterorganizationEntity) o;

        if (member != that.member) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return member;
    }

    @OneToOne
    @JoinColumn(name = "member", referencedColumnName = "character_id", nullable = false)
    public CharacterEntity getCharacterByMember() {
        return characterByMember;
    }

    public void setCharacterByMember(CharacterEntity characterByMember) {
        this.characterByMember = characterByMember;
    }

    @ManyToOne
    @JoinColumn(name = "org_name", referencedColumnName = "org_name")
    public OrganizationEntity getOrganizationByOrgName() {
        return organizationByOrgName;
    }

    public void setOrganizationByOrgName(OrganizationEntity organizationByOrgName) {
        this.organizationByOrgName = organizationByOrgName;
    }
}
