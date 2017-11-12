package Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "book", schema = "public", catalog = "postgres")
public class BookEntity {
    private int bookId;
    private String bName;
    private String bDesc;
    private Collection<EpisodeEntity> episodesByBookId;

    @Id
    @Column(name = "book_id")
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "b_name")
    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    @Basic
    @Column(name = "b_desc")
    public String getbDesc() {
        return bDesc;
    }

    public void setbDesc(String bDesc) {
        this.bDesc = bDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (bookId != that.bookId) return false;
        if (bName != null ? !bName.equals(that.bName) : that.bName != null) return false;
        if (bDesc != null ? !bDesc.equals(that.bDesc) : that.bDesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bookId;
        result = 31 * result + (bName != null ? bName.hashCode() : 0);
        result = 31 * result + (bDesc != null ? bDesc.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bookByBookId")
    public Collection<EpisodeEntity> getEpisodesByBookId() {
        return episodesByBookId;
    }

    public void setEpisodesByBookId(Collection<EpisodeEntity> episodesByBookId) {
        this.episodesByBookId = episodesByBookId;
    }
}
