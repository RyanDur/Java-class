public class SinglyLinkedLists {

    public static void main(String []args) {
        SinglyLinkedList manager = new SinglyLinkedList();
        PatientNode patient1 = new PatientNode(new Patient("John", 33, "Tuberculosis"));
        PatientNode patient2 = new PatientNode(new Patient("Fliss", 21, "Video Game Addiction"));
        PatientNode patient3 = new PatientNode(new Patient("Keimi", 21, "Recursion"));
        PatientNode patient4 = new PatientNode(new Patient("David", 56, "Essixosis"));
        PatientNode patient5 = new PatientNode(new Patient("Joe", 3, "Governmental politics"));
        PatientNode patient6 = new PatientNode(new Patient("Ludovic", 99, "French"));
        PatientNode patient7 = new PatientNode(new Patient("Sergio", 10, "Teaching"));
        PatientNode patient8 = new PatientNode(new Patient("Kieth", 15, "Fell down"));
        PatientNode patient9 = new PatientNode(new Patient("Oded", 9, "Helping"));
        PatientNode patient10 = new PatientNode(new Patient("Sokratis", 12, "Java script"));

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
        manager.delete(patient2);
        System.out.println(" ");
        manager.printList();

        manager.delete(patient6);
        System.out.println(" ");
        manager.printList();

        manager.delete(patient3);
        System.out.println(" ");
        manager.printList();

        manager.delete(patient10);
        System.out.println(" ");
        manager.printList();

        manager.delete(patient1);
        System.out.println(" ");
        manager.printList();

        manager.delete(patient4);
        System.out.println(" ");
        manager.printList();

        manager.add(new PatientNode(new Patient("Ryan", 34, "Too tall")));
        manager.delete(patient7);
        System.out.println(" ");
        manager.printList();
    }
}
