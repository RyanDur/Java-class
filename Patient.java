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
        if (this.nextPatient == null) {
            this.nextPatient = newPatient;
        } else {
            this.nextPatient.addPatient(newPatient);
        }
    }

    public boolean deletePatient(Patient patient) {
        if (this.nextPatient == null) {
            return false;
        }  else if (this.nextPatient.name.equals(patient.name)) {
            Patient temp = nextPatient.nextPatient;
            nextPatient.nextPatient = null;
            this.nextPatient = temp;
            return true;
        } else {
            return this.nextPatient.deletePatient(patient);
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

    public String getName() {
        return name;
    }

    public int size() {
        if(nextPatient == null) {
            return 1;
        }
        return 1 + nextPatient.size();
    }
}
