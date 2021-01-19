package wcci.campus.campus;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class jpaWiringTest {

    @Autowired
    CampusRepository campusRepo;
    @Autowired
    BookRepository bookRepo;
    @Autowired
    TestEntityManager entityManager;

    @Test
    public void campusShouldHaveBooks_BooksShouldHaveCampus() {
        Campus underTest = new Campus("Name", "Description");
        campusRepo.save(underTest);
        Book testBook1 = new Book("Name", "Synopsis", underTest);
        Book testBook2 = new Book("Name2", "Synopsis2", underTest);
        bookRepo.save(testBook1);
        bookRepo.save(testBook2);

        entityManager.flush();
        entityManager.clear();

        Campus retrievedCampus = campusRepo.findById(1l).get();
        assertThat(retrievedCampus.getBooks()).contains(testBook1, testBook2);
    }
}
