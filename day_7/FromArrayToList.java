public class FromArrayToList {

    public static void main(String []args) {
        int[] foo = {5,2,3,6,15,1,9,20,19,7,14,4,16,18,8,10,15,11,12,13,17,1};

        SinglyLinkedList list = ListUtilities.toList(foo);

	System.out.println("toList");
        list.printList();

        SortList bar = new SortList();
        for(int i = 0; i < foo.length; i++) {
            bar.add(new NodeDbl(foo[i]));
        }

        DoublyLinkedList dblList = ListUtilities.bubbleSort(bar);

        System.out.println(" ");
	System.out.println("Bubble Sort");
        dblList.printList();

        SortList car = new SortList();
        for(int i = 0; i < foo.length; i++) {
            car.add(new NodeDbl(foo[i]));
        }

        DoublyLinkedList anotherDblList = ListUtilities.cocktailSort(car);

        System.out.println(" ");
	System.out.println("Cocktial Sort");
        anotherDblList.printList();

        SortList mar = new SortList();
        for(int i = 0; i < foo.length; i++) {
            mar.add(new NodeDbl(foo[i]));
        }

        SortList yetAnotherDblList = ListUtilities.quicksort(mar);

        System.out.println(" ");
	System.out.println("Quick Sort");
        yetAnotherDblList.printList();
    }
}
