package com.java.algorithm.educative.linkedlist;

public class ReverseList {

    public static <T> void reverse(SinglyLinkedList<T> list){
        SinglyLinkedList<T>.Node prev = null; //To keep track of the previous element, will be used in swapping links
        SinglyLinkedList<T>.Node current = list.getHeadNode(); //firstElement
        SinglyLinkedList<T>.Node next = null;

        //While Traversing the list, swap links
        while (current != null) {
            next = current.nextNode;
            current.nextNode = prev;
            prev = current;
            current = next;
        }
        //Linking Head Node with the new First Element
        list.setHeadNode(prev);
    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList();
        for (int i = 1; i <= 10; i++) {
            sll.insertAtEnd(i);

        }

        sll.printList();
        reverse(sll);
        sll.printList();
    }
}
