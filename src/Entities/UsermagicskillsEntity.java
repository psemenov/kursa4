package Entities;

import javax.persistence.*;

@Entity
@Table(name = "usermagicskills", schema = "public", catalog = "postgres")
public class UsermagicskillsEntity {
    private int userId;
    private UsersEntity usersByUserId;
    private MagicSkillsEntity magicSkillsBySkillId;

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

        UsermagicskillsEntity that = (UsermagicskillsEntity) o;

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
    @JoinColumn(name = "skill_id", referencedColumnName = "mskill_id")
    public MagicSkillsEntity getMagicSkillsBySkillId() {
        return magicSkillsBySkillId;
    }

    public void setMagicSkillsBySkillId(MagicSkillsEntity magicSkillsBySkillId) {
        this.magicSkillsBySkillId = magicSkillsBySkillId;
    }
}
