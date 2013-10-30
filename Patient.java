public class Patient {
    private String name;
    private int age;
    private String illness;
    private Patient nextPatient;

    public Patient(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.nextPatient = null;
    }

    public void addPatient(Patient newPatient) {
        if (nextPatient == null) {
            nextPatient = newPatient;
        } else {
            nextPatient.addPatient(newPatient);
        }
    }

    public void deletePatient(Patient patient) {
        if (nextPatient == patient) {
            Patient temp = patient.getNextPatient();
            patient.setNextPatient(null);
            nextPatient = temp;
        } else {
            nextPatient.deletePatient(patient);
        }
    }

    public void print() {
        System.out.print(name + ", ");
        System.out.print(age + ", ");
        System.out.println(illness);

        if(nextPatient != null) {
            nextPatient.print();
	}
    }

    public Patient getNextPatient() {
        return nextPatient;
    }

    public void setNextPatient(Patient patient) {
        nextPatient = patient;
    }

    public int size() {
        if(nextPatient == null) {
            return 1;
        }
        return 1 + nextPatient.size();
    }
}
