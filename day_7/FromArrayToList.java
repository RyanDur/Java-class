public class FromArrayToList {

    public static void main(String []args) {
        int[] foo = {5,2,3,6,15,1,9,20,19,7,14,4,16,18,8,10,15,11,12,13,17,1};
        int[] doo = {5,2,3,6,15,1,9,20,19,7,14,4,16,18,8,10,15,11,12,13,17,1};

        SinglyLinkedList list = ListUtilities.toList(foo);

	//        list.printList();

        SortList bar = new SortList();
        for(int i = 0; i < foo.length; i++) {
            bar.add(new NodeDbl(foo[i]));
        }

        DoublyLinkedList dblList = ListUtilities.bubbleSort(bar);

        System.out.println(" ");
	//        dblList.printList();

        SortList car = new SortList();
        for(int i = 0; i < doo.length; i++) {
            car.add(new NodeDbl(doo[i]));
        }

        DoublyLinkedList anotherDblList = ListUtilities.cocktailSort(car);

        System.out.println(" ");
        anotherDblList.printList();
    }
}
