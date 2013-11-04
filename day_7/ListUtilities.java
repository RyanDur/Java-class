public class ListUtilities {
    public static SinglyLinkedList toList(int[] numbers) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 0; i < numbers.length; i++) {
            list.add(new IntegerNode(numbers[i]));
        }
        return list;
    }

    public static DoublyLinkedList bubbleSort(SortList list) {
        for(int i = 0; i < list.size()-1; i++) {
            NodeDbl head = list.getHead();
            for(int j = 0; j < list.size()-1; j++) {
                if((Integer) head.getValue() > (Integer) head.getNext().getValue()) {
                    list.insertBefore(head.getNext(), head);
                }
                head = head.getNext();
            }
        }
	return list;
    }
}
