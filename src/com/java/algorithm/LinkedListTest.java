package com.java.algorithm;

/**
 * Created by Mihir.Desai on 3/24/2017.
 */

import com.java.algorithm.LinkedStack.Node;
public class LinkedListTest {

    public static void main(String args[]) {
        LinkedListTest test = new LinkedListTest();

   /*     LinkedStack<String> stack = new LinkedStack<>();
        String[] data = new String[]{"to","be","-","or","to","not","-","-","that","-"};
        for(String s : data) {
            if(!s.equals("-"))
                stack.addFirst(s);
            else if(!stack.isEmpty()) {
                System.out.println(stack.First());
            }
        }

        System.out.println("Size left on stack - "+stack.size());
        System.out.println(test.getItems(stack.getFirst()));*/

        /*Iterator<String> it = stack.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }*/

        //test.reverse(stack.getFirst());
        /*System.out.println(stack.toString());*/

        LinkedStack<Integer> stack1 = new LinkedStack<>();
     /*   for(int i = 1 ; i < 10;i++) {
            stack1.addFirst(i);
        }

        System.out.println("Before swap - "+test.getItems(stack1.getFirst()));
        Node newHead = test.swapNodes(stack1.getFirst());
        System.out.println("After swap - "+test.getItems(newHead));*/


        stack1 = new LinkedStack<>();
        stack1.addFirst(15);
        stack1.addFirst(10);
        stack1.addFirst(3);
        stack1.addFirst(4);
        stack1.addFirst(1);
        stack1.addFirst(11);

      /*  System.out.println("Before finding palindrome - "+test.getItems(stack1.getFirst()));
        System.out.println("Max palindrome - " + test.maxPalindrome(stack1.getFirst()));
*/
        System.out.println("Before Swap - "+test.getItems(stack1.getFirst()));
        test.swapKthNode(stack1.getFirst(),2);

        System.out.println("Before Swap - "+test.getItems(stack1.getFirst()));
        test.swapKthNode(stack1.getFirst(),1);

     /*   stack1 = new LinkedStack<>();
        stack1.push(1);
        stack1.push(3);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(6);
        stack1.push(7);
        stack1.push(8);
        stack1.push(9);
        stack1.push(10);

        System.out.println("Original List - "+test.getItems(stack1.getFirst()));
        Node head = test.reverseAltKNodes(stack1.getFirst(),2);
        System.out.println("After calling reverse alternate 2 nodes - " + test.getItems(head));

        Node sortedList = test.mergeSort(head);
        System.out.println("After calling merge sort - " + test.getItems(sortedList));

        stack1 = new LinkedStack<>();
        stack1.pushAtEnd(1);
        stack1.pushAtEnd(2);
        stack1.pushAtEnd(3);
        stack1.pushAtEnd(4);
        stack1.pushAtEnd(5);
        stack1.pushAtEnd(6);
        stack1.insertLoop(2);
        test.displayLoop(stack1.getFirst());
        test.findLoop(stack1.getFirst());*/

        stack1 = new LinkedStack<>();
        stack1.addFirst(10);
        stack1.addFirst(50);
        stack1.addFirst(70);
        stack1.addFirst(90);
        stack1.addFirst(100);

        LinkedStack<Integer> stack2 = new LinkedStack<>();
        stack2.addFirst(20);
        stack2.addFirst(30);
        stack2.addFirst(50);
        stack2.addFirst(60);
        stack2.addFirst(80);

        Node merge =  test.mergeList(test.mergeSort(stack1.getFirst()),test.mergeSort(stack2.getFirst()));
        System.out.print(test.getItems(merge));
    }

    /**
     * Swap Alternate Nodes in a list
     * @param first
     * @return
     */
    public Node swapNodes(Node first) {
        Node ptrOne_prev = null;
        Node newFirst = null;

        while(first != null && first.next != null) {
            Node ptrOne = first;
            Node ptrTwo = first.next;
            Node ptrTwoNext = ptrTwo.next;

            ptrOne.next = ptrTwoNext;

            if(ptrOne_prev != null) {
                ptrOne_prev.next = ptrTwo;
            } else {
                newFirst = ptrTwo;
            }

            ptrTwo.next = first;
            ptrOne_prev = ptrOne;
            first = ptrTwoNext;
        }

        return newFirst;
    }

    /**
     * Find the length of longest palindrome in a list
     * @param first
     * @return
     */
    public int maxPalindrome(Node first) {
        int result = 0;
        Node prev = null;
        Node curr = first;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            result = Math.max(result,2*countCommon(prev,next) + 1);
            result = Math.max(result,2*countCommon(curr,next));
            prev = curr;
            curr = next;

        }

        return result;
    }

    private int countCommon(Node a, Node b) {
        int count = 0;
        for(;a!=null && b!= null;a=a.next,b=b.next) {
            /*System.out.println("A : "+a.item+", B: "+b.item);*/
            if(a.item instanceof String) {
                if(((String) a.item).equalsIgnoreCase((String)b.item)) {
                    ++count;
                } else {
                    return count;
                }
            } else {
                if(a.item == b.item) {
                    ++count;
                }
                else return count;
            }
        }

        return count;
    }

    /**
     * Reverse the complete linked list
     * @param first
     */
    public void reverse(Node first) {
        Node curr = first;
        Node prev = null;
        Node next = null;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        first = prev;
        System.out.println(getItems(first));
    }

    /**
     * Get Linked List as string
     * @param first
     * @return
     */
    public String getItems(Node first) {
        StringBuilder s = new StringBuilder();
        Node curr = first;
        while(curr != null) {
            s.append(curr.item + " -> ");
            curr = curr.next;
        }

        s.append("NULL");
        return s.toString();
    }


    /**
     * Reverse K nodes alternatively
     * @param first
     * @param k
     * @return
     */
    public Node reverseAltKNodes(Node first,int k) {
        Node curr = first;
        Node prev = null;
        Node next = null;
        int count = 0;

        // reverse 1st K nodes of list;
        while(count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // now move the head which is cur to k+1 node
        if(first != null) {
            first.next = curr;
        }

        count = 0;
        while(count < k-1 && curr != null) {
            curr = curr.next;
            count++;
        }

        // recursive call from curr.next node
        if(curr != null) {
            curr.next = reverseAltKNodes(curr.next,k);
        }

        first = prev;
        System.out.println(getItems(first));
        return first;
    }



    public void swapNodes(Comparable x, Comparable y, Node first) {
        // x and y are same do not swap
        if(x.compareTo(y) == 0) {
            return;
        }

        Node currX = first;
        Node prevX = null;

        // store prevX and currX till we find 1st item
        while(currX != null && currX.getItem().compareTo(x) != 0){
            prevX = currX;
            currX = currX.getNext();
        }

        Node currY = first;
        Node prevY = null;

        // store prevY and currY till we find 2nd item
        while(currY != null && currY.getItem().compareTo(y) != 0){
            prevY = currY;
            currY = currY.getNext();
        }

        // if either of currX or cuurY is null then cannot swap
        if(currX == null || currY == null) {
            return;
        }

        // if prevX is null then make currY is the new head
        // if prevX is not null then set prevX.next to currY
        if(prevX != null) {
            prevX.setNext(currY);
        } else {
            first = currY;
        }

        // if prevY is empty then it is head node so make currX as new head
        // if prevY is not empty then set prevY.next to currX
        if(prevY != null) {
            prevY.setNext(currX);
        } else {
            first = currX;
        }

        // swap currY.next with currX.next
        Node temp = currY.getNext();
        currY.setNext(currX.getNext());
        currX.setNext(temp);
        System.out.println(getItems(first));
    }

    /**
     * Swap Kth node from both end of list ( 1st kth node with kth node from last)
     * @param first
     * @param k
     */
    public void swapKthNode(Node first,int k) {
        int length = getLength(first);
        if(length < k) {
            return;
        }
        
        if(2*k - 1 == length) {
            return;
        }
        
        Node currX = first;
        Node prevX = null;

        for(int i = 1; i < k;i++) {
            prevX = currX;
            currX = currX.getNext();
        }

        Node currY = first;
        Node prevY = null;

        for(int i = 1; i < length - k + 1;i++) {
            prevY = currY;
            currY = currY.getNext();
        }

      /*  if(currX == null || currY == null){
            return;
        }*/

        if(prevX != null) {
          prevX.setNext(currY);
        } else {
            first = currY;
        }

        if(prevY != null) {
            prevY.setNext(currX);
        } else {
            first = currX;
        }

        Node temp = currX.getNext();
        currX.setNext(currY.getNext());
        currY.setNext(temp);
        /*System.out.println("First Node - "+first.getItem());*/
        System.out.println(getItems(first));
    }

    public int getLength(Node a) {
        int count = 0;
        Node h = a;
        while (h != null) {
            count++;
            h = h.next;
        }
        return count;
    }

    /**
     * Merge Sort a linked list
     * @param first
     * @return
     */
    public Node mergeSort(Node first) {
        Node oldFirst = first;
        int mid = getLength(first)/2;
        if(first.next == null) {
            return first;
        }

        //find new head for second sublist
        while(mid-1 > 0) {
            oldFirst = oldFirst.next;
            mid--;
        }

        Node newFirst = oldFirst.next;
        // break 1st list
        oldFirst.next = null;
        //move back pointer to first node
        oldFirst = first;
        Node t1 = mergeSort(oldFirst);
        Node t2 = mergeSort(newFirst);
        return mergeList(t1,t2);
    }

    public Node mergeList(Node a, Node b) {
        Node result = null;

        if(a == null) {
            return b;
        }

        if(b == null) {
            return a;
        }

        if(((Integer)a.item) > ((Integer)b.item)) {
            result = b;
            result.next = mergeList(a,b.next);
        } else {
            result = a;
            result.next = mergeList(a.next,b);
        }

        return result;
    }

    /**
     * Find loop in a linked list , loop length and break the loop
     */
    public void findLoop(Node first) {
        Node a = first;
        Node b = first.next.next;

        while(a != null) {
            if(a != b) {
                a = a.next;
                b = b.next.next;
            } else {
                System.out.println("loop starts at - "+a.item);
                int length = findLoopLength(a,b);
                System.out.println("length of loop - "+length);
                breakLoop(a,b);
                break;
            }
        }
    }

    private int findLoopLength(Node a, Node b) {
        int loopLength = 1;
        a = a.next;
        while(a != b) {
            a = a.next;
            loopLength++;
        }

        return loopLength;
    }

    private void breakLoop(Node a, Node b){
        a = a.next;
        while(a.next !=b) {
            a = a.next;
        }
        a.next = null;
    }

    public void displayLoop(Node first){
        System.out.println("");
        Node currNode = first;
        int cnt = 15;
        while(cnt!=0){
            System.out.print("->" + currNode.item);
            currNode=currNode.next;
            cnt--;
        }
    }
}
