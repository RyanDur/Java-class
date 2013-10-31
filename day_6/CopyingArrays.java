public class CopyingArrays {

    public void copy(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++) {
            if(i < arr2.length) {
                arr2[i] = arr1[i];
            }
        }
    }

    public void printArrays(int[] arr1, int[] arr2) {
	int larger = larger(arr1, arr2);
        System.out.print("array 1   ");
        System.out.println(":   array 2");
        for(int i = 0; i < larger; i++) {
            System.out.print("   " + print(arr1, i) + "      ");
            System.out.println("       " + print(arr2, i));
        }
    }

    private String print(int[] arr, int num) {
        if(arr.length > num) {
            return Integer.toString(arr[num]);
        }
        return " ";
    }

    private int larger(int[] arr1, int[] arr2) {
	if(arr1.length > arr2.length) {
	    return arr1.length;
	}
	return arr2.length;
    }

    public static void main(String []args) {
        int[] first = {1,2,3,4,5};
        int[] sameSize = new int[5];
        int[] smaller = new int[2];
        int[] larger = new int[10];

        CopyingArrays ca = new CopyingArrays();

        ca.copy(first, sameSize);
        ca.printArrays(first, sameSize);

        ca.copy(first, smaller);
        ca.printArrays(first, smaller);

        ca.copy(first, larger);
        ca.printArrays(first, larger);
    }
}
