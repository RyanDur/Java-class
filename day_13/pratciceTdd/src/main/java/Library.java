public interface Library {

    String getName();

    int generateUserId();

    void setIdGenerator(IdGenerator generator);

    int getMaxBooksPerUser();

    LibraryUser[] setMaxBooksPerUser(int maxBooksPerUser);

    int getId(String user);

    void addUser(LibraryUser user);

    void addBook(Book book);

    Book takeBook(String title);

    void returnBook(Book book);

    int getReaderCount();

    int getBookCount();

    int getBookBorrowedCount();

    LibraryUser[] getUsersBorrowingBooks();

    LibraryUser[] getUsers();
}
