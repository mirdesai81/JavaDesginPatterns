package com.java.algorithm.educative.graph;

import com.java.algorithm.educative.graph.base.Graph;
import com.java.algorithm.educative.linkedlist.DoublyLinkedList;
import com.java.algorithm.educative.stackAndQueue.Stack;

public class FindPath {



        public static boolean checkPath(Graph g, int source, int destination) {
            // Write - Your - Code
            if(source == destination) return true;
            boolean[] visited = new boolean[g.vertices];

            Stack<Integer> stack = new Stack<>(g.vertices);
            stack.push(source);
            visited[source] = true;
            DoublyLinkedList<Integer>.Node temp = null;
            while(!stack.isEmpty()) {
                int curr = stack.pop();
                if(g.adjacencyList[curr] != null) {
                    temp = g.adjacencyList[curr].headNode;
                }


                while(temp != null) {
                    if(!visited[temp.data]) {
                        if(temp.data == destination) {
                            return true;
                        }
                        stack.push(temp.data);
                        visited[temp.data] = true;
                    }

                    temp = temp.nextNode;
                }
            }

            return false;
        }


    public static void main(String args[]) {

        Graph g1 = new Graph(9);
        g1.addEdge(0,2);
        g1.addEdge(0,5);
        g1.addEdge(2,3);
        g1.addEdge(2,4);
        g1.addEdge(5,3);
        g1.addEdge(5,6);
        g1.addEdge(3,6);
        g1.addEdge(6,7);
        g1.addEdge(6,8);
        g1.addEdge(6,4);
        g1.addEdge(7,8);
        g1.printGraph();
        System.out.println("Path exists: " + checkPath(g1, 0, 7));
        System.out.println();
        Graph g2 = new Graph(4);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(2,3);

        g2.printGraph();
        System.out.println("Path exists: " + checkPath(g2, 3, 0));
    }

}
