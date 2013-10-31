public class PatientNodeDbl extends NodeDbl {

    public PatientNodeDbl(Patient patient) {
	super(patient);
    }

    public PatientNodeDbl getNext() {
	return (PatientNodeDbl) super.getNext();
    }

    public void setNext(PatientNodeDbl patient) {
        super.setNext(patient);
    }

    public PatientNodeDbl getLast() {
	return (PatientNodeDbl) super.getLast();
    }

    public void setLast(PatientNodeDbl node) {
	super.setLast(node);
    }

    public Patient getNode() {
        return (Patient) super.getNode();
    }
}
