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
        Person p1 = new Person("Fliss");
        Person p2 = new Person("Keimi");
        Person p3 = new Person("David");
        Person p4 = new Person("Joe");
        Person p5 = new Person("Olly");

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
