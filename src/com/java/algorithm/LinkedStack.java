package com.java.algorithm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Mihir.Desai on 3/23/2017.
 */
public class LinkedStack<T extends Comparable<T>> implements Iterable<T> {
    private Node head;
    private int n;
    private Node tail;

    public class Node {
        Node next;
        T item;

        public Node( T item,Node next) {
            this.next = next;
            this.item = item;
        }

        public Node() {
        }

        public Node(T item) {
            this.item = item;
            this.next = null;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node n) {
            this.next = n;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        @Override
        public String toString() {
            return "Node [" +
                    " item=" + item +
                    ']';
        }
    }

    public LinkedStack() {
        head = tail = null;
        n = 0;
        assert  assertCheck();
    }

    public boolean isEmpty() { return n == 0;}

    public int size() { return n;}

    /*public void pushAtEnd(T item) {
        Node n = new Node();
        n.item = item;

        if(first == null) {
            n.next = first;
            first = n;
        } else {
            Node curr = first;
            while(curr.next != null) {
                curr = curr.next;
            }
            curr.next = n;
        }
    }

    public void insertLoop(int index) {
        Node curr = first;
        while (curr.next != null) {
            curr = curr.next;
        }

        Node indexNode = first;
        while(index != 0) {
            indexNode = indexNode.next;
            index--;
        }

        curr.next = indexNode;
    }
*/

    public T addFirst(T item){
        Node newest = new Node(item,head);
        head = newest;
        if(isEmpty()) {
            tail = head;
        }
        n = n + 1;
        return First();
    }


    public T addLast(T item){
        Node newest = new Node(item,null);
        if(isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        n = n + 1;
        return Last();
    }


    public void remove(T item) {
        Node curr = head;
        Node prev = null;

        // check if curr item to remove is head
        if(curr != null && curr.getItem().compareTo(item) == 0) {
            this.removeFirst();
            return;
        }

        prev = curr;
        curr = curr.getNext();
        // move to next and keep track of prev untill element is not found
        while(curr != null && curr.getItem().compareTo(item) != 0) {
            prev = curr;
            curr = curr.getNext();
        }

        // return if we have reached end of list
        if(curr == null) {
            return;
        }

        // check if curr is equal to last element in the list
        // move tail to prev as new last element
        if(curr.getItem().compareTo(tail.getItem()) == 0) {
            tail = prev;
        }

        // set prev next to curr next which removes curr item from list
        prev.setNext(curr.getNext());
        n--;
        return;
    }

    public T removeFirst() {
        if(isEmpty()){
            throw new NoSuchElementException("list is emtpy");
        }

        T element = head.getItem();
        head = head.getNext(); // if only one element head will become null
        n--;
        if(n==0) {
            tail = null;
        }

        return element;
    }

    public T removeLast() {
        if(isEmpty()) {
            throw new NoSuchElementException("list is empty");
        }

        T element = tail.getItem();
        Node curr;
        n--;
        // if tail and head were same means only one element existed
        if(n == 0){
            head = tail = null;
        } else {
            curr = head;
            System.out.println("Before removing tail-"+this.toString());

            // while curr -> next is not equal to tail
            // move curr to next element
            while(curr.getNext() != tail) {
                curr = curr.getNext();
            }

            curr.setNext(null);
            tail = curr;
            System.out.println("After removing last -"+this.toString());
        }

        return element;
    }

    public Node getFirst() {
        return head;
    }

    public Node getLast() {
        return tail;
    }

   /* public T pop() {
        if(isEmpty()) {
            throw new NoSuchElementException("Stack underflow");
        }

        T item = first.item;
        first = first.next;
        n--;
        assert  assertCheck();
        return item;
    }
*/
    private boolean assertCheck() {
        if(n < 0) return false;

        if(n == 0) {
            // if no element and first is not null
            if(head != null) return false;
            if(tail != null) return false;
        } else if(n == 1) {
            // if only one element
            if(head == null) return false;
            if(head.next != null) return false;
            if(tail == null) return false;
            if(tail.next != null) return false;
        } else {
            // if more then one elements
            if(head == null) return false;
            if(head.next == null) return false;

            if(head == tail) return false;
            if(tail.next != null) return false;
        }

        // check nodes equal n
        int numOfNodes = 0;
        for(Node x = head; x != null && numOfNodes <= n;x = x.next){
            numOfNodes++;
        }

        if(numOfNodes != n) return false;

        return true;
    }

    public T First() {
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        return head.getItem();
    }

    public T Last() {
        if(tail == null) {
            throw new NoSuchElementException("Stack underflow");
        }

        return tail.getItem();
    }


    public boolean search(T key) {
        if(isEmpty()) {
           /* throw new NoSuchElementException("List is empty");*/
            return false;
        }

        Node curr = head;
        while(curr != null && curr.getItem().compareTo(key) != 0) {
            curr = curr.getNext();
        }

        if(curr == null) {
            return false;
        }

        return true;
    }


    public String toString() {
        StringBuilder s = new StringBuilder();
        for(T item : this) {
            s.append(item + " -> ");
        }

        s.append("NULL");
        return s.toString();


    }


    public void print(String... message) {

        if(message != null && message.length > 0){
            System.out.println(message[0] + " - " + this.toString());
        } else {
            System.out.println(this.toString());
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if(!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }



    public static void main(String args[]) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        linkedStack.addFirst(5);
        linkedStack.addFirst(4);
        linkedStack.addFirst(3);
        linkedStack.addFirst(2);
  /*      linkedStack.print("Before removing first");
        linkedStack.removeFirst();
        linkedStack.print("After removing first");
        linkedStack.removeLast();
        linkedStack.print("After removing last");*/
/*
        linkedStack.print("Before Reverse");
        linkedStack.reverse();
        linkedStack.print("After Reverse");
        System.out.println("New head - " + linkedStack.First());
        System.out.println("New tail - " + linkedStack.Last());
*/

        linkedStack.print("Before remove");
        linkedStack.remove(2);
        linkedStack.print("After remove");
        System.out.println("New head - " + linkedStack.First());
        System.out.println("New tail - " + linkedStack.Last());

        linkedStack.addFirst(6);
        linkedStack.print("Before remove");
        linkedStack.remove(4);
        linkedStack.print("After remove");
        System.out.println("New head - " + linkedStack.First());
        System.out.println("New tail - " + linkedStack.Last());


        linkedStack = new LinkedStack<>();
        linkedStack.addFirst(5);
        linkedStack.print("Before removing first");
        linkedStack.removeFirst();
        linkedStack.print("After removing first");

        linkedStack = new LinkedStack<>();
        linkedStack.addFirst(5);
        linkedStack.print("Before removing last");
        linkedStack.removeLast();
        linkedStack.print("After removing last" +
                "" +
                "");


        linkedStack = new LinkedStack<>();
        linkedStack.addFirst(5);
        linkedStack.addFirst(4);
        linkedStack.addFirst(3);
        linkedStack.addFirst(2);
        System.out.println(linkedStack.search(3));
    }

}
