public class User {
    private final String name;
    private int id;

    public User(String name) {
	this.name = name;
	id = 0;
    }

    public String getName() {
	return name;
    }

    public void setId(int id) {
	this.id = id;
    }

    public int getId() {
	return id;
    }
}
