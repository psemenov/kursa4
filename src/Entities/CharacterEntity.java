package Entities;

import javax.persistence.*;

@Entity
@Table(name = "character", schema = "public", catalog = "postgres")
public class CharacterEntity {

    @Id
    @Column(name = "character_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int characterId;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "gender")
    private String gender;


    @Basic
    @Column(name = "rating")
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "user_id" , nullable = false)
    private UsersEntity userByUserId;

    public UsersEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UsersEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CharacterEntity that = (CharacterEntity) o;

        if (characterId != that.characterId) return false;
        if (rating != that.rating) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = characterId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + rating;
        return result;
    }
}
