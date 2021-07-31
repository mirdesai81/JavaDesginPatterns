package com.java.algorithm.educative.linkedlist;

public class IsPalindromeDoublyLinkedList {

    public static <T> boolean isPalindrome(DoublyLinkedList<T> list) {
        //Write Your Code Here
        if(list.isEmpty()) {
            return true;
        }
        DoublyLinkedList<T>.Node start = list.getHeadNode();
        DoublyLinkedList<T>.Node last = list.getTailNode();
        int size = list.getSize();
        int count = 0;
        int mid = size / 2;
        while(start != null && last != null && count <= mid) {
            if(!start.data.equals(last.data)) {
                return false;
            }
            ++count;
            start = start.nextNode;
            last = last.prevNode;
        }

        return true;
    }

    public static void main( String args[] ) {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<Integer>();
        list1.insertAtEnd(1);
        list1.insertAtEnd(2);
        list1.insertAtEnd(2);
        list1.insertAtEnd(1);
        System.out.print("1st ");
        list1.printList();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<Integer>();
        list2.insertAtEnd(6);
        list2.insertAtEnd(8);
        list2.insertAtEnd(6);
        list2.insertAtEnd(6);
        System.out.print("2nd ");
        list2.printList();
        System.out.println("Is 1st list a palindrome?  " + isPalindrome(list1));
        System.out.println("Is 2nd list a palindrome?  " + isPalindrome(list2));

    }
}
