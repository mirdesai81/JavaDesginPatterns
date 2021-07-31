package com.java.algorithm.educative.linkedlist;

public class Main {

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList();
        for (int i = 1; i <= 10; i++) {
            sll.insertAtEnd(i);
            sll.printList();
        }

        System.out.println("Searching for 9 in list "+sll.searchNode(9));

        //delete node
        sll.deleteByValue(9);
        sll.printList();
    }
}
