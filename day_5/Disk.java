public class Disk {
    private String disk = "";
    private int size;

    public Disk(int size) {
	this.size = size;
	build(size);
    }

    public void print() {
	System.out.println(disk);
    }

    public int size() {
	return size;
    }

    private void build(int toSize) {
	for(int i = 0; i < toSize; i++) {
	    disk += "-";
	}
    }
}
