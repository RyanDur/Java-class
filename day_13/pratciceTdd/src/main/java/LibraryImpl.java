import java.util.*;

public class LibraryImpl implements Library {
    private String name;
    private int maxBooksPerUser;
    private IdGenerator ids;
    private Map<String, LibraryUser> libraryUsers = new HashMap<String, LibraryUser>();

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
}
