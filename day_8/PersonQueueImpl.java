public class PersonQueueImpl extends Queue implements PersonQueue {

    public void insert(Person person) {
        super.insert(person);
    }

    public Person retrieve() {
        return (Person) super.retrieve();
    }

    public Person retrieve(int age) {
        Person head = (Person) getHead();
        if(head == null) {
            return null;
        } else {
            while(head != null && head.getAge() < age) {
                head = head.getNext();
            }
            delete(head);
            return head;
        }
    }

}
