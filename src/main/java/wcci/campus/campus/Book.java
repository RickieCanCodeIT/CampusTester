package wcci.campus.campus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    private String name;
    private String synopsis;
    @ManyToOne
    private Campus campus;

    @Id
    @GeneratedValue
    public long id;

    public Book(String name, String synopsis, Campus campus) {
        this.name = name;
        this.synopsis = synopsis;
        this.campus = campus;
    }

    public Book() {

    }

    public String getName() {
        return name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Campus getCampus() {
        return campus;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", campus=" + campus +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (synopsis != null ? !synopsis.equals(book.synopsis) : book.synopsis != null) return false;
        return campus != null ? campus.equals(book.campus) : book.campus == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (synopsis != null ? synopsis.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
