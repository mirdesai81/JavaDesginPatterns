package com.java.algorithm.educative.linkedlist;

import com.java.algorithm.list.LinkedStack;

class ReverseK{
    static LinkedListNode reverseKNodes(LinkedListNode head, int k) {

        // if k is 0 or 1, then list is not changed
        if (k <= 1 || head == null) {
            return head;
        }

        LinkedListNode reversed = null;
        LinkedListNode prevTail = null;

        while (head != null && k > 0) {
            LinkedListNode currentHead = null;
            LinkedListNode currentTail = head;

            int n = k;
            while (head != null && n > 0) {
                LinkedListNode temp = head.next;
                head.next = currentHead;
                currentHead = head;

                head = temp;
                n--;
            }

            if (reversed == null) {
                reversed = currentHead;
            }

            if (prevTail != null) {
                prevTail.next = currentHead;
            }
            prevTail = currentTail;
        }

        return reversed;
    }

    private static LinkedListNode reverseAltKNodes(LinkedListNode first,int k) {
        LinkedListNode curr = first;
        LinkedListNode prev = null;
        LinkedListNode next = null;
        int count = 0;
        while(count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(first != null) {
            first.next = curr;
        }

        count = 0;
        while(count < k - 1 && curr != null) {
            curr = curr.next;
            count++;
        }

        if(curr != null) {
            curr.next = reverseAltKNodes(curr.next,k);
        }

        first = prev;
        /*  System.out.println(getItems(first));*/
        return first;
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        LinkedListNode listHead = LinkedListNode.create_linked_list(v1);
        System.out.print("Original list: ");
        LinkedListNode.display(listHead);

        listHead = reverseKNodes(listHead, 4);
        System.out.print("List reversed by 4: ");
        LinkedListNode.display(listHead);

        listHead = LinkedListNode.create_linked_list(v1);
        System.out.print("Original list: ");
        LinkedListNode.display(listHead);
        listHead = reverseAltKNodes(listHead, 4);
        System.out.print("List reversed by 4: ");
        LinkedListNode.display(listHead);
    }
}
