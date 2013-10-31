public class PatientNode extends Node {

    public PatientNode(Patient patient) {
	super(patient);
    }

    public PatientNode getNext() {
	return (PatientNode) super.getNext();
    }

    public void setNext(PatientNode patient) {
        super.setNext(patient);
    }

    public Patient getNode() {
        return (Patient) super.getNode();
    }
}
