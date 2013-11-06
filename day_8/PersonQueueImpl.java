public class PersonQueueImpl extends Queue implements PersonQueue {

    public void insert(Person person) {
	super.insert(person);
    }

    public Person retrieve() {
	return (Person) super.retrieve();
    }
}
