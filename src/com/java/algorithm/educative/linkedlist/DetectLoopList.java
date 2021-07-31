package com.java.algorithm.educative.linkedlist;

public class DetectLoopList {

    //Detects loop in the given linked list
    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        //Write -- Your -- Code
        SinglyLinkedList<T>.Node fast = list.getHeadNode();
        SinglyLinkedList<T>.Node slow = list.getHeadNode();

        while(slow != null && fast != null && fast.nextNode != null) {
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;

            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(4);
        System.out.println("Before adding loop: " + detectLoop(list));
        list.getHeadNode().nextNode.nextNode.nextNode = list.getHeadNode().nextNode;
        System.out.println("After adding loop: " + detectLoop(list));
    }
}
