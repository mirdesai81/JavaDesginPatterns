package com.java.algorithm.educative.graph;

import com.java.algorithm.educative.graph.base.Graph;
import com.java.algorithm.educative.linkedlist.DoublyLinkedList;
import com.java.algorithm.educative.stackAndQueue.Stack;

public class CycleDetection {

        public static boolean detectCycle(Graph g){
            // Write -- Your -- Code
            boolean[] visited = new boolean[g.vertices];
            for(int i = 0; i < g.adjacencyList.length; i++) {

                if(!visited[i] && hasCycle(g,i,visited)) {
                    return true;
                }
            }
            return false;
        }

    public static boolean hasCycle(Graph g,int v,boolean[] visited) {

        Stack<Integer> stack = new Stack<>(visited.length);
        stack.push(v);
        int vertex = 0;
        while(!stack.isEmpty()) {
            vertex = stack.pop();
            System.out.println("before vertex: "+vertex+", visited: "+visited[vertex]);
            if(visited[vertex]) {
                System.out.println("visited: "+vertex);
                return true;
            }

            visited[vertex] = true;
            System.out.println("after vertex: "+vertex+", visited: "+visited[vertex]);
            DoublyLinkedList<Integer>.Node curr =  g.adjacencyList[vertex].headNode;
            while(curr != null) {
                stack.push(curr.data);
                curr = curr.nextNode;
            }
        }

        return false;

    }

      /*  public static boolean hasCycle(DoublyLinkedList<Integer> vertex, int v, boolean[] visited) {
            if(vertex.headNode == null) return false;

            Stack<DoublyLinkedList<Integer>.Node> stack = new Stack<>(visited.length);
            stack.push(vertex.headNode);
            DoublyLinkedList<Integer>.Node curr = null;

            visited[v] = true;
            System.out.println("Current vertex:"+v);


            while(!stack.isEmpty()) {
                curr = stack.pop();
                if(visited[curr.data]) {
                    System.out.println("Visited:"+curr.data);
                    return true;
                }

                System.out.println("Next vertex:"+curr.data);
                visited[curr.data] = true;
                curr = curr.nextNode;
                while(curr != null) {
                    System.out.println("push vertex:"+curr.data);
                    stack.push(curr);
                    curr = curr.nextNode;
                }
            }

            return false;

        }
*/
    public static void main(String args[]) {
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }

}
