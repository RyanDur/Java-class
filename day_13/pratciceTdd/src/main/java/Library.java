public interface Library {

    String getName();

    int generateUserId();

    void setIdGenerator(IdGenerator generator);

    int getMaxBooksPerUser();

    void setMaxBooksPerUser(int maxBooksPerUser);

    int getId(String user);

    void addUser(LibraryUser user);
}
