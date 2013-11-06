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

    public static SortList quicksort(SortList list) {
        if(list.size() <= 1) {
            return list;
        }

        NodeDbl head = list.getHead();
        int pivot = (Integer) head.getValue();

        SortList less = new SortList();
        SortList pivotList = new SortList();
        SortList more = new SortList();

        while(head != null) {
            int val = (Integer) head.getValue();
            if(val < pivot) {
                less.add(new NodeDbl(val));
            } else if(val > pivot) {
                more.add(new NodeDbl(val));
            } else {
                pivotList.add(new NodeDbl(val));
            }
            head = head.getNext();
        }

        less = quicksort(less);
        more = quicksort(more);

        less.addAll(pivotList);
        less.addAll(more);

        return less;
    }
}
