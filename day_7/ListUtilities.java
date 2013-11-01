public class ListUtilities {
    public static SinglyLinkedList toList(int[] numbers) {
	SinglyLinkedList list = new SinglyLinkedList();
	for(int i = 0; i < numbers.length; i++) {
	    list.add(new IntegerNode(numbers[i]));
	}
	return list;
    }
}
