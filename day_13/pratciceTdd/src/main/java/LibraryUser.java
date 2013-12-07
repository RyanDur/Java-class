public class LibraryUser extends User {
    private Library library;

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
}
