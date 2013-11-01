public class ASortedList {

    public static void main(String []args) {
        int [] ints = {5,2,3,6,15,1,9,20,19,7,14,4,16,18,8,10,15,11,12,13,17,1};
	SortedLinkedList list = new SortedLinkedList();

	for(int i = 0; i < ints.length; i++) {
	    list.insert(new IntegerNode(ints[i]));
	}

	list.printList();
    }
}
