package com.java.algorithm.educative.linkedlist;

public class InterectionAndUnion {

        //performs union of two lists
        public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
            if(list1.isEmpty()) return list2;

            if(list2.isEmpty()) return list1;

            SinglyLinkedList<T>.Node curr = list1.getHeadNode();

            while(curr.nextNode != null) {
                curr = curr.nextNode;
            }

            curr.nextNode = list2.getHeadNode();

            list1.removeDuplicatesWithHashing();

            return list1;
        }

        public static <T> boolean contains(SinglyLinkedList<T> list,T data) {
            SinglyLinkedList<T>.Node curr = list.getHeadNode();
            while(curr != null) {
                if(curr.data.equals(data)) {
                    return true;
                }
                curr = curr.nextNode;
            }

            return false;
        }

        //performs intersection between list
        public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
            SinglyLinkedList<T> result = new SinglyLinkedList<T>();
            // Write -- Your -- Code
            SinglyLinkedList<T>.Node curr = list1.getHeadNode();
            while(curr != null) {
                if(contains(list2,curr.data)) {
                    result.insertAtHead(curr.data);
                }
                curr = curr.nextNode;
            }
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
        intersection(list1, list2).printList();
        System.out.print("After Union ");
        union(list1, list2).printList();
    }

}
