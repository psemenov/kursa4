package Entities;

import javax.persistence.*;

@Entity
@Table(name = "usercharactertype", schema = "public", catalog = "postgres")
public class UsercharactertypeEntity {
    private int userId;
    private UsersEntity usersByUserId;
    private CharacterTypeEntity characterTypeByCtypeId;

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

        UsercharactertypeEntity that = (UsercharactertypeEntity) o;

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
    @JoinColumn(name = "ctype_id", referencedColumnName = "ctype_id")
    public CharacterTypeEntity getCharacterTypeByCtypeId() {
        return characterTypeByCtypeId;
    }

    public void setCharacterTypeByCtypeId(CharacterTypeEntity characterTypeByCtypeId) {
        this.characterTypeByCtypeId = characterTypeByCtypeId;
    }
}
