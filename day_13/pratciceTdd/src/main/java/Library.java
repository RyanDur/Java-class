public interface Library {

    String getName();

    int generateUserId();

    void setIdGenerator(IdGenerator generator);

    int getMaxBooksPerUser();

    void setMaxBooksPerUser(int maxBooksPerUser);

    int getId(String user);

    void addUser(LibraryUser user);

    void addBook(Book book);

    Book takeBook(String title);

    void returnBook(Book book);
}
