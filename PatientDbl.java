public class PatientDbl {
    private String name;
    private int age;
    private String illness;
    private PatientDbl nextPatient;
    private PatientDbl lastPatient;

    public PatientDbl(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.nextPatient = null;
        this.lastPatient = null;
    }


    public void addPatient(PatientDbl newPatient) {
        if(this.nextPatient == null) {
            this.nextPatient = newPatient;
            newPatient.setLastPatient(this);
        } else {
            this.nextPatient.addPatient(newPatient);
        }
    }

    public void delete() {
        if(nextPatient != null) {
            nextPatient.lastPatient = lastPatient;
        }
        if(lastPatient != null) {
            lastPatient.nextPatient = nextPatient;
        }
        lastPatient = null;
        nextPatient = null;
    }

    public void setLastPatient(PatientDbl patient) {
        if(patient != null) {
            lastPatient = patient;
        }
    }

    public PatientDbl getNextPatient() {
	return nextPatient;
    }

    public void print() {
        System.out.print(name + ", ");
        System.out.print(age + ", ");
        System.out.println(illness);

        if(nextPatient != null) {
            nextPatient.print();
        }
    }

}
