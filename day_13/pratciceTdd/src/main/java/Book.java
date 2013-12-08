public class Book {
    private final String title;
    private final String author;
    public boolean taken;

    public Book(String title, String author) {
	this.title = title;
	this.author = author;
	taken = false;
    }

    public String getTitle() {
	return title;
    }

    public String getAuthor() {
	return author;
    }

    public boolean isTaken() {
	return taken;
    }

    public void setTaken(boolean taken) {
	this.taken = taken;
    }
}
