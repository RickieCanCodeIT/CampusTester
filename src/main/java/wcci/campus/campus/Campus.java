package wcci.campus.campus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
@Entity
public class Campus {
    private String name;
    private String description;

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "campus")
    private Collection<Book> ownedBooks;


    public Campus(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Campus() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Collection<Book> getBooks() {
        return ownedBooks;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Campus{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Campus campus = (Campus) o;

        if (id != campus.id) return false;
        if (name != null ? !name.equals(campus.name) : campus.name != null) return false;
        return description != null ? description.equals(campus.description) : campus.description == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
