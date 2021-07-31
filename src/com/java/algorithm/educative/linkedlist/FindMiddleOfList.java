package com.java.algorithm.educative.linkedlist;

public class FindMiddleOfList {

    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        // Write -- Your -- Code
        SinglyLinkedList<T>.Node slow = list.getHeadNode();
        SinglyLinkedList<T>.Node fast = list.getHeadNode();
        SinglyLinkedList<T>.Node prev = null;

        while(slow != null && fast != null && fast.nextNode != null) {
            prev = slow;
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
        }

        if(fast == null) {
            return prev.data;
        }
        return slow.data;
    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList();
        for (int i = 1; i <= 10; i++) {
            sll.insertAtEnd(i);

        }

        sll.printList();
        Integer data = (Integer) findMiddle(sll);
        System.out.println(data);
    }
}
