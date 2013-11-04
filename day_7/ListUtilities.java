public class ListUtilities {
    public static SinglyLinkedList toList(int[] numbers) {
        SinglyLinkedList list = new SinglyLinkedList();
        for(int i = 0; i < numbers.length; i++) {
            list.add(new IntegerNode(numbers[i]));
        }
        return list;
    }

    public static DoublyLinkedList bubbleSort(SortList list) {
        NodeDbl start = list.getHead();
        NodeDbl head = null;
        for(int i = 0; i < list.size()-1; i++) {
            head = start;
            for(int j = 0; j < list.size()-1; j++) {
                if((Integer) head.getValue() > (Integer) head.getNext().getValue()) {
                    list.swap(head, head.getNext());
                }
                if(head.getNext() != null) {
                    head = head.getNext();
                }
            }
        }
        return list;
    }

    public static DoublyLinkedList cocktailSort(SortList list) {
        NodeDbl head = list.getHead();
        for(int i = 0; i < (list.size()-1)/2; i++) {
            for(int j = 0; j < list.size()-1; j++) {
                if((Integer) head.getValue() > (Integer) head.getNext().getValue()) {
                    list.swap(head, head.getNext());
                }
                if(head.getNext() != null) {
                    head = head.getNext();
                }
            }
            for(int k = list.size()-1; k >= 0; k--) {
                if(head.getLast() != null) {
                    head = head.getLast();
                }
                if((Integer) head.getValue() > (Integer) head.getNext().getValue()) {
                    list.swap(head, head.getNext());
                }
            }
        }
        return list;
    }
}
