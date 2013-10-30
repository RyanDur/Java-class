public class CirclyLinkedList {
    private PatientCrc patientListStart = null;

    public void addPatient(PatientCrc patient) {
        if(patientListStart == null) {
            patientListStart = patient;
        } else {
            patientListStart.addPatient(patient);
        }
    }

    public void deletePatient(PatientCrc patient) {
        if(patient == patientListStart) {
            patientListStart = patient.getNextPatient();
        }

        patientListStart.deletePatient(patient);
    }


    public void printList() {
        patientListStart.print(patientListStart);
    }

    public static void main(String []args) {
        CirclyLinkedList manager = new CirclyLinkedList();
        PatientCrc patient1 = new PatientCrc("John", 33, "Tuberculosis");
        PatientCrc patient2 = new PatientCrc("Fliss", 21, "Video Game Addiction");
        PatientCrc patient3 = new PatientCrc("Keimi", 21, "Recursion");
        PatientCrc patient4 = new PatientCrc("David", 56, "Essixosis");
        PatientCrc patient5 = new PatientCrc("Joe", 3, "Governmental politics");
        PatientCrc patient6 = new PatientCrc("Ludovic", 99, "French");
        PatientCrc patient7 = new PatientCrc("Sergio", 10, "Teaching");
        PatientCrc patient8 = new PatientCrc("Kieth", 15, "Fell down");
        PatientCrc patient9 = new PatientCrc("Oded", 9, "Helping");
        PatientCrc patient10 = new PatientCrc("Sokratis", 12, "Java script");

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
