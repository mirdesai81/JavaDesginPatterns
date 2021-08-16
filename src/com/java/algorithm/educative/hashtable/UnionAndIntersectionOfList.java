package com.java.algorithm.educative.hashtable;

import com.java.algorithm.educative.linkedlist.SinglyLinkedList;

import java.util.HashSet;

public class UnionAndIntersectionOfList {


        //performs union of two lists
        public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
            SinglyLinkedList<T> result = new SinglyLinkedList<T>();
            HashSet<T> visited = new HashSet<>();
            SinglyLinkedList<T>.Node curr = null;
            if(!list1.isEmpty()) {
                curr = list1.getHeadNode();
                while(curr != null) {
                    result.insertAtEnd(curr.data);
                    visited.add(curr.data);
                    curr = curr.nextNode;
                }
            }

            if(!list2.isEmpty()) {
                curr = list2.getHeadNode();
                while(curr != null) {
                    if(!visited.contains(curr.data))
                        result.insertAtEnd(curr.data);

                    curr = curr.nextNode;
                }
            }

            // Write -- Your -- Code
            return result;
        }

        //performs intersection between list
        public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
            SinglyLinkedList<T> result = new SinglyLinkedList<T>();
            HashSet<T> visited = new HashSet<>();
            SinglyLinkedList<T>.Node curr = null;
            if(!list1.isEmpty()) {
                curr = list1.getHeadNode();
                while(curr != null) {
                    visited.add(curr.data);
                    curr = curr.nextNode;
                }
            }

            if(!list2.isEmpty()) {
                curr = list2.getHeadNode();
                while(curr != null) {
                    if(visited.contains(curr.data))
                        result.insertAtEnd(curr.data);

                    curr = curr.nextNode;
                }
            }

            // Write -- Your -- Code
            return result;
        }

    public static void main( String args[] ) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        for(int i=7; i>3; i--){
            list1.insertAtHead(i);
        }
        System.out.print("1st ");
        list1.printList();
        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        for(int i=0; i<5; i++){
            list2.insertAtHead(i);
        }
        System.out.print("2nd ");
        list2.printList();
        System.out.print("After Intersection ");
        intersectionWithHashing(list1, list2).printList();
        System.out.print("After Union ");
        unionWithHashing(list1, list2).printList();
    }
}
