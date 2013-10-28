public class SinglyLinkedLists {
    private Patient patientListStart = null;

    public void addPatient(Patient patient) {
        if(patientListStart == null) {
            patientListStart = patient;
        } else {
            patientListStart.addPatient(patient);
        }
    }

    public void deletePatient(Patient patient) {
        if(patientListStart.getName().equals(patient.getName())) {
	    Patient temp = patientListStart.getNextPatient();
	    patientListStart.setNextPatient(null);
	    patientListStart = temp;
        } else {
            patientListStart.deletePatient(patient);
        }
    }

    public void printList() {
        patientListStart.print();
        System.out.println(patientListStart.size());
    }

    public static void main(String []args) {
        SinglyLinkedLists manager = new SinglyLinkedLists();
        Patient patient1 = new Patient("John", 33, "Tuberculosis");
        Patient patient2 = new Patient("Fliss", 21, "Video Game Addiction");
        Patient patient3 = new Patient("Keimi", 21, "Recursion");
        Patient patient4 = new Patient("David", 56, "Essixosis");
        Patient patient5 = new Patient("Joe", 3, "Governmental politics");
        Patient patient6 = new Patient("Ludovic", 99, "French");
        Patient patient7 = new Patient("Sergio", 10, "Teaching");
        Patient patient8 = new Patient("Kieth", 15, "Fell down");
        Patient patient9 = new Patient("Oded", 9, "Helping");
        Patient patient10 = new Patient("Sokratis", 12, "Java script");

        manager.addPatient(patient1);
        manager.addPatient(patient2);
        manager.addPatient(patient3);
        manager.addPatient(patient4);
        manager.addPatient(patient5);
        manager.addPatient(patient6);
        manager.addPatient(patient7);
        manager.addPatient(patient8);
        manager.addPatient(patient9);
        manager.addPatient(patient10);

        manager.printList();
        manager.deletePatient(patient2);
        System.out.println(" ");
        manager.printList();

        manager.deletePatient(patient6);
        System.out.println(" ");
        manager.printList();

        manager.deletePatient(patient3);
        System.out.println(" ");
        manager.printList();

        manager.deletePatient(patient10);
        System.out.println(" ");
        manager.printList();

        manager.deletePatient(patient1);
        System.out.println(" ");
        manager.printList();
    }
}
