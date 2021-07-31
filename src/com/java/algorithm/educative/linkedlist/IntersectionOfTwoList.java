package com.java.algorithm.educative.linkedlist;

public class IntersectionOfTwoList {


    public static void main(String[] args) {
        int [] a1 = {13,4};
        int [] a2 = {29, 23, 82, 11};
        LinkedListNode list_head_1 = LinkedListNode.create_linked_list(a1);
        LinkedListNode list_head_2 = LinkedListNode.create_linked_list(a2);
        LinkedListNode node1 = new LinkedListNode(12);
        LinkedListNode node2 = new LinkedListNode(27);

        LinkedListNode.insert_at_tail(list_head_1, node1);
        LinkedListNode.insert_at_tail(list_head_1, node2);

        LinkedListNode.insert_at_tail(list_head_2, node1);

        System.out.print("List 1: ");
        LinkedListNode.display(list_head_1);
        System.out.print("List 2: ");
        LinkedListNode.display(list_head_2);

        LinkedListNode intersect_node = intersect(list_head_1, list_head_2);
        System.out.println(String.format("Intersect at %d", intersect_node.data));
    }

    public static LinkedListNode intersect(LinkedListNode head1, LinkedListNode head2) {
        //TODO: Write - Your - Code
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        // 1-2-3-4-5
        // 7-4-5

        if(len1 == 0 || len2 == 0) {
            return null;
        }

        int diff = Math.abs(len1 - len2);

        if(diff > 0) {
            if(len1 > len2) {
                // move head1
                head1 = move(head1,diff);
            } else {
                // move head2
                head2 = move(head2,diff);
            }
        }

        while(head1 != null && head2 != null) {
            if(head1.data == head2.data) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null;
    }

    public static LinkedListNode move(LinkedListNode head, int n) {
        while(n > 0) {
            head = head.next;
            --n;
        }

        return head;
    }

    public static int getLength(LinkedListNode head) {
        int length = 0;
        LinkedListNode curr = head;
        while(curr != null) {
            ++length;
            curr = curr.next;
        }

        return length;
    }



}
