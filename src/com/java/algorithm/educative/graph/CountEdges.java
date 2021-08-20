package com.java.algorithm.educative.graph;

import com.java.algorithm.educative.graph.base.Graph;
import com.java.algorithm.educative.linkedlist.DoublyLinkedList;

public class CountEdges {

    public static int numEdges(Graph g) {
        // Write -- Your -- Code
        int count = 0;
        for(int i = 0; i < g.vertices; i++) {
            count +=  vertexEdges(g,i);
        }
        return count > 0 ? count/2 : -1;
    }

    public static int vertexEdges(Graph g, int v) {
        DoublyLinkedList<Integer>.Node curr = g.adjacencyList[v].headNode;
        int count = 0;
        while(curr != null) {
            ++count;
            curr = curr.nextNode;
        }

        System.out.println("Vertex "+v+" has "+count+" edges.");
        return count;
    }

    public static void main(String args[]) {

        Graph g = new Graph(9);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(5,3);
        g.addEdge(5,6);
        g.addEdge(3,6);
        g.addEdge(6,7);
        g.addEdge(6,8);
        g.addEdge(6,4);
        g.addEdge(7,8);


        g.printGraph();
        System.out.println("Number of edges: " + numEdges(g));
        System.out.println();

        Graph g2 = new Graph(7);
        g2.addEdge(1,2);
        g2.addEdge(1,3);
        g2.addEdge(3,4);
        g2.addEdge(3,5);
        g2.addEdge(2,5);
        g2.addEdge(2,4);
        g2.addEdge(4,6);
        g2.addEdge(4,5);
        g2.addEdge(6,5);


        g2.printGraph();
        System.out.println("Number of edges: " + numEdges(g2));
    }
}
