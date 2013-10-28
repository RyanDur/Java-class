public class MyArrays {
    int[] ids;
    String[] names;

    public MyArrays() {
        ids = new int[1];
        names = new String[1];
    }

    public void add(int id, String name) {
	System.out.println(firstZero());
	int first = firstZero();
        if(first != -1) {
            ids[first] = id;
            names[first] = name;
        } else {
            grow();
            add(id,name);
        }
    }

    public String[] get(int num) {
	return (ids[num] +","+ names[num]).split(",");
    }

    public int size() {
	return ids.length;
    }

    private void grow() {
        int[] newIds = new int[ids.length*2];
        String[] newNames = new String[names.length*2];

        copyInt(ids, newIds);
        copyString(names, newNames);

        ids = newIds;
        names = newNames;
    }

    private void copyInt(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++) {
            if(i < arr2.length) {
                arr2[i] = arr1[i];
            }
        }
    }

    private void copyString(String[] arr1, String[] arr2) {
	for(int i = 0; i < arr1.length; i++) {
            if(i < arr2.length) {
                arr2[i] = arr1[i];
            }
        }
    }

    private int firstZero() {
        for(int i = 0; i < ids.length; i++) {
            if(ids[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
