import java.util.*;

public class LibraryImpl implements Library {
    private String name;
    private int maxBooksPerUser;
    private IdGenerator ids;
    private ArrayList<LibraryUser> libraryUsers = new ArrayList<>();

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
        LibraryUser libraryUser = getUser(user);
        if(libraryUser != null) {
	    int id = libraryUser.getId();
            if(id <= 0) {
		id = generateUserId();
                libraryUser.setId(id);
            }
            result = id;
        }
        return result;
    }

    @Override
    public void addUser(LibraryUser user) {
        libraryUsers.add(user);
    }

    private LibraryUser getUser(String name) {
        LibraryUser result = null;
        int i = 0;
        while(i < libraryUsers.size() && result == null) {
            if(libraryUsers.get(i).getName().equals(name)) {
                result = libraryUsers.get(i);
            } else {
                i++;
            }
        }
        return result;
    }
}
