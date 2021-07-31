package com.java.algorithm.educative.linkedlist;

import java.util.*;



class ReverseEveryKSubList {

    public static ListNode reverse(ListNode head, int k) {
        // TODO: Write your code here
        if(k <= 1 || head == null) {
            return head;
        }

        ListNode lastNodeOfFirst = null;
        ListNode curr = head;
        ListNode prev = null;

        while(true) {
            // prev will become last node of previous subList
            ListNode lastNodeOfPreviousPart = prev;
            // curr will become last node of current sublist
            ListNode lastNodeOfSubList = curr;
            ListNode next = null;
            for(int i = 0; curr != null && i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // if last node of previous part is not null then connect it to current subList
            // head
            if(lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = prev;
            } else {
                head = prev;
            }

            //connect last node of current sublist with curr
            lastNodeOfSubList.next = curr;

            if(curr == null) {
                break;
            }

            // move prev to lastNode of current sublist
            prev = lastNodeOfSubList;

        }


        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKSubList.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}