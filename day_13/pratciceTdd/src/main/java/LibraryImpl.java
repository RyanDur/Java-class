import java.util.*;

public class LibraryImpl implements Library {
    private String name;
    private int maxBooksPerUser;
    private IdGenerator ids;
    private Map<String, LibraryUser> libraryUsers = new HashMap<String, LibraryUser>();
    private Map<String, Book> shelves = new HashMap<String, Book>();

    public LibraryImpl(String name) {
        this.name = name;
        maxBooksPerUser = 3;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int generateUserId() {
        return ids.generateId();
    }

    @Override
    public void setIdGenerator(IdGenerator generator) {
        ids = generator.getInstance();
    }

    @Override
    public int getMaxBooksPerUser() {
        return maxBooksPerUser;
    }

    @Override
    public void setMaxBooksPerUser(int maxBooksPerUser) {
        this.maxBooksPerUser = maxBooksPerUser;
    }

    @Override
    public int getId(String user) {
        int result = 0;
        if(libraryUsers.containsKey(user)) {
            result = libraryUsers.get(user).getId();
            if(result <= 0) {
                result = generateUserId();
                libraryUsers.get(user).setId(result);
            }
        }
        return result;
    }

    @Override
    public void addUser(LibraryUser user) {
        libraryUsers.put(user.getName(), user);
    }

    @Override
    public void addBook(Book book) {
        shelves.put(book.getTitle(), book);
    }

    @Override
    public Book takeBook(String title) {
        Book result = null;
        if(shelves.containsKey(title) && !shelves.get(title).isTaken()) {
            result = shelves.get(title);
            result.setTaken(true);
        }
        return result;
    }

    @Override
    public void returnBook(Book book) {
        book.setTaken(false);
    }

    @Override
    public int getReaderCount() {
        return libraryUsers.size();
    }

    @Override
    public int getBookCount() {
        return shelves.size();
    }

    @Override
    public int getBookBorrowedCount() {
        int result = 0;
        for(Book book : shelves.values()) {
            if(book.isTaken()) {
                result++;
            }
        }
        return result;
    }
}
