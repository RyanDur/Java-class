public class DoublyLinkedList {
    private PatientDbl patientListStart = null;

    public void addPatient(PatientDbl patient) {
        if(patientListStart == null) {
            patientListStart = patient;
        } else {
            patientListStart.addPatient(patient);
        }
    }

    public void deletePatient(PatientDbl patient) {
	if(patient == patientListStart) {
	    patientListStart = patient.getNextPatient();
	}
        patient.delete();
    }

    public void printList() {
        patientListStart.print();
    }


    public static void main(String []args) {
        DoublyLinkedList manager = new DoublyLinkedList();
        PatientDbl patient1 = new PatientDbl("John", 33, "Tuberculosis");
        PatientDbl patient2 = new PatientDbl("Fliss", 21, "Video Game Addiction");
        PatientDbl patient3 = new PatientDbl("Keimi", 21, "Recursion");
        PatientDbl patient4 = new PatientDbl("David", 56, "Essixosis");
        PatientDbl patient5 = new PatientDbl("Joe", 3, "Governmental politics");
        PatientDbl patient6 = new PatientDbl("Ludovic", 99, "French");
        PatientDbl patient7 = new PatientDbl("Sergio", 10, "Teaching");
        PatientDbl patient8 = new PatientDbl("Kieth", 15, "Fell down");
        PatientDbl patient9 = new PatientDbl("Oded", 9, "Helping");
        PatientDbl patient10 = new PatientDbl("Sokratis", 12, "Java script");

	PatientDbl patient11 = new PatientDbl("Ryan", 34, "To tall");

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

	manager.deletePatient(patient11);
    }
}
