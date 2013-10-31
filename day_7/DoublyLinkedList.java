public class DoublyLinkedList {

    public static void main(String []args) {
        DblyLinkedList manager = new DblyLinkedList();
        PatientNodeDbl patient1 = new PatientNodeDbl(new Patient("John", 33, "Tuberculosis"));
        PatientNodeDbl patient2 = new PatientNodeDbl(new Patient("Fliss", 21, "Video Game Addiction"));
        PatientNodeDbl patient3 = new PatientNodeDbl(new Patient("Keimi", 21, "Recursion"));
        PatientNodeDbl patient4 = new PatientNodeDbl(new Patient("David", 56, "Essixosis"));
        PatientNodeDbl patient5 = new PatientNodeDbl(new Patient("Joe", 3, "Governmental politics"));
        PatientNodeDbl patient6 = new PatientNodeDbl(new Patient("Ludovic", 99, "French"));
        PatientNodeDbl patient7 = new PatientNodeDbl(new Patient("Sergio", 10, "Teaching"));
        PatientNodeDbl patient8 = new PatientNodeDbl(new Patient("Kieth", 15, "Fell down"));
        PatientNodeDbl patient9 = new PatientNodeDbl(new Patient("Oded", 9, "Helping"));
        PatientNodeDbl patient10 = new PatientNodeDbl(new Patient("Sokratis", 12, "Java script"));

        System.out.println(manager.size());

        manager.add(patient1);
        manager.add(patient2);
        manager.add(patient3);
        manager.add(patient4);
        manager.add(patient5);
        manager.add(patient6);
        manager.add(patient7);
        manager.add(patient8);
        manager.add(patient9);
        manager.add(patient10);

        manager.printList();
        System.out.println(manager.size());

        manager.delete(patient2);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient6);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient3);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient10);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient1);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient4);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.delete(patient7);
        System.out.println(" ");
        manager.printList();

        System.out.println(manager.size());

        manager.add(new PatientNodeDbl(new Patient("Ryan", 34, "Too tall")));
        System.out.println(" ");
        manager.printList();
        System.out.println(manager.size());

    }
}
