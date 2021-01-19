package wcci.campus.campus;

public class BookStorage {

    private BookRepository bookRepo;

    public BookStorage(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public void saveBook(Book tempBook) {
        bookRepo.save(tempBook);
    }

    public Book getByID(long inId) {
        bookRepo.findById(inId);
        return null;
    }
}
