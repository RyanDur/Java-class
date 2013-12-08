import java.util.*;

public class LibraryUser extends User {
    private Library library;
    private Map<String, Book> borrowedBooks = new HashMap<String, Book>();

    public LibraryUser(String name) {
        super(name);
    }

    public void registerLibrary(Library library) {
        setId(library.generateUserId());
        this.library = library;
    }

    public Library getLibrary() {
        return library;
    }

    public void borrowBook(String title) {
        Book book = getLibrary().takeBook(title);
        borrowedBooks.put(book.getTitle(), book);
    }

    public String[] getBorrowedBookTitles() {
        return borrowedBooks.keySet().toArray(new String[0]);
    }
}
