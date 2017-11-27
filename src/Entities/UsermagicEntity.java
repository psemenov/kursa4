package Entities;

import javax.persistence.*;

@Entity
@Table(name = "usermagic", schema = "public", catalog = "postgres")
public class UsermagicEntity {
    private int userId;
    private UsersEntity usersByUserId;
    private MagicEntity magicByMagicId;

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

        UsermagicEntity that = (UsermagicEntity) o;

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
    @JoinColumn(name = "magic_id", referencedColumnName = "m_id")
    public MagicEntity getMagicByMagicId() {
        return magicByMagicId;
    }

    public void setMagicByMagicId(MagicEntity magicByMagicId) {
        this.magicByMagicId = magicByMagicId;
    }
}
