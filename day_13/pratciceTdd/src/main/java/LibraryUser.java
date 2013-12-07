public class LibraryUser {
    private Library library;

    public LibraryUser(String name) {
	super(name);
    }

    public void registerLibrary(Library library) {
	this.library = library;
    }

    public Library getLibrary() {
	return library;
    }
}
