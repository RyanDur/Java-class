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

    public Person servePerson(int n) {
        return pq.retrieve(n);
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

	System.out.println(" ");

        sm.addPerson(p1);
        sm.addPerson(p2);
        sm.addPerson(p5);
        sm.addPerson(p4);
        sm.addPerson(p3);

        int[] ages = {65,18,0};
        for(int i = 0; i < ages.length; i++) {
            int age = ages[i];
            Person p = sm.servePerson(age);
            while(p != null) {
                System.out.println(p);
                p = sm.servePerson(age);
            }
        }
    }
}
