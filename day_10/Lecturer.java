public class Lecturer extends Teacher {

    public Lecturer(String name) {
	super(name);
    }

    public void doResearch(String topic) {
	System.out.println("Doing research on: " + topic);
    }

    public static void main(String []args) {
	Lecturer l = new Lecturer("Harold");
	l.doResearch("Underwater basket weaving.");
	l.teach("Mormonism");
    }
}
