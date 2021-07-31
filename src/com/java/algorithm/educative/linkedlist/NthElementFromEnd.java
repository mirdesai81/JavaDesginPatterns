package com.java.algorithm.educative.linkedlist;

public class NthElementFromEnd {

        public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
            // Write -- Your -- Code

            int length = findLength(list);

            if(length < n){
                return null;
            }

            int elem = length - n;
            SinglyLinkedList<T>.Node curr =  list.getHeadNode();
            while(elem > 0 && curr != null) {
                curr = curr.nextNode;
                elem--;
            }


            return curr.data;
        }

        public static <T> int findLength(SinglyLinkedList<T> list) {
            SinglyLinkedList<T>.Node curr =  list.getHeadNode();
            int length = 0;
            while(curr != null) {
                ++length;
                curr = curr.nextNode;
            }

            return length;
        }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList(); //list is empty
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return null
        for(int i=0; i<15; i+=2){
            sll.insertAtHead(i);
        }
        sll.printList(); // List is 14 -> 12 -> 10 -> 8 -> 6 -> 4 -> 2 -> 0 -> null
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return 4
        System.out.println("10th element from end : " + nthElementFromEnd(sll, 10));//will return null
    }

}
