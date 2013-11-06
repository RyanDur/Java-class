public class Supermarket {
    PersonQueue pq = null;
    public Supermarket() {
        pq = new PersonQueueImpl();
    }

    public void addPerson(Person person) {
        pq.insert(person);
    }

    public Person servePerson() {
        return pq.retrieve();
    }

    public static void main(String []args) {
        Supermarket sm = new Supermarket();
        Person p1 = new Person("Fliss", 14);
        Person p2 = new Person("Keimi", 21);
        Person p3 = new Person("David", 90);
        Person p4 = new Person("Joe", 64);
        Person p5 = new Person("Olly", 65);

        sm.addPerson(p1);
        sm.addPerson(p2);
        sm.addPerson(p3);
        sm.addPerson(p4);
        sm.addPerson(p5);

        System.out.println(sm.servePerson());
        System.out.println(sm.servePerson());
        System.out.println(sm.servePerson());
        System.out.println(sm.servePerson());
        System.out.println(sm.servePerson());
    }
}
