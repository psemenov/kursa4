package Entities;

import javax.persistence.*;

@Entity
@Table(name = "userorganization", schema = "public", catalog = "postgres")
public class UserorganizationEntity {
    private int userId;
    private UsersEntity usersByUserId;
    private OrganizationEntity organizationByOrgId;

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserorganizationEntity that = (UserorganizationEntity) o;

        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userId;
    }

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "org_id", referencedColumnName = "org_id")
    public OrganizationEntity getOrganizationByOrgId() {
        return organizationByOrgId;
    }

    public void setOrganizationByOrgId(OrganizationEntity organizationByOrgId) {
        this.organizationByOrgId = organizationByOrgId;
    }
}
