public class KeyValuePair {
    private String name;
    private int key;

    public KeyValuePair(int key, String name) {
	this.key = key;
	this.name = name;
    }

    public int getKey() {
	return key;
    }

    public String getName() {
	return name;
    }
}
