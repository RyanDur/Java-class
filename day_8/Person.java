public class Person extends Node {
    private int age;

    public Person(String name, int age) {
	super(name);
	this.age = age;
    }

    public String getName() {
	return (String) super.getValue();
    }

    public void setName(String name) {
	super.setValue(name);
    }

    public void setAge(int age) {
	this.age = age;
    }

    public int getAge() {
	return age;
    }

    public Person getNext() {
	return (Person) super.getNext();
    }

    public void setNext(Person node) {
	super.setNext(node);
    }

    public String toString() {
	return "Name: " + getName() + ", Age: " + getAge();
    }
}
