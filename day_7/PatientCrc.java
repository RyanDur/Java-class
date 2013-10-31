public class PatientCrc {
    private String name;
    private int age;
    private String illness;
    private PatientCrc nextPatient;

    public PatientCrc(String name, int age, String illness) {
        this.name = name;
        this.age = age;
        this.illness = illness;
        this.nextPatient = this;
    }

    public void addPatient(PatientCrc newPatient) {
        PatientCrc lastPatient = last(this, nextPatient);
        newPatient.setNextPatient(lastPatient.getNextPatient());
        lastPatient.setNextPatient(newPatient);
    }

    public void deletePatient(PatientCrc patient) {
        if (nextPatient == patient) {
            PatientCrc temp = nextPatient.getNextPatient();
            nextPatient.setNextPatient(null);
            nextPatient = temp;
        } else {
            nextPatient.deletePatient(patient);
        }
    }

    public void print(PatientCrc patient) {
        System.out.print(name + ", ");
        System.out.print(age + ", ");
        System.out.println(illness);

        if(nextPatient != patient) {
            nextPatient.print(patient);
        }
    }

    public PatientCrc getNextPatient() {
        return nextPatient;
    }

    public void setNextPatient(PatientCrc patient) {
        nextPatient = patient;
    }

    private PatientCrc last(PatientCrc first, PatientCrc next) {
        if(next.nextPatient == first) {
            return next;
        }
        return last(first, next.nextPatient);
    }
}
