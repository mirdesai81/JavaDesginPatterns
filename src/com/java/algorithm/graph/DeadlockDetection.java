package com.java.algorithm.graph;

import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DeadlockDetection {
    private static class GraphVertex {
        public static enum Color {WHITE , GRAY, BLACK}
        public Integer node;
        public Color color;
        public List<GraphVertex> edges;

        public GraphVertex(Integer node) {

            this.color = Color.WHITE;
            this.node = node;
            this.edges = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "GraphVertex{" +
                    "node=" + node +
                    ", color=" + color +
                    '}';
        }
    }

    public static boolean isDeadlocked(List<GraphVertex> G) {
        for(GraphVertex vertex : G) {
            if(vertex.color == GraphVertex.Color.WHITE && hasCycle(vertex)) {
                return true;
            }
        }

        return false;
    }

    public static boolean hasCycle(GraphVertex vertex) {
        Stack<GraphVertex> stack = new Stack<>();
        stack.push(vertex);
        GraphVertex curr;
        while(!stack.isEmpty()) {
            curr = stack.pop();
            System.out.println(curr);
            if(curr.color == GraphVertex.Color.GRAY) {
                return true;
            }
            curr.color = GraphVertex.Color.GRAY;
            if(curr.edges != null) {
                for (GraphVertex next : curr.edges) {
                    stack.push(next);
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        /*

           [[0, 1], [0, 2], [1, 3], [1, 4], [2, 5], [2, 6]]	false	A binary tree
 	       [[0, 1], [0, 2], [1, 3], [1, 4], [2, 5], [2, 6], [4, 6], [6, 1]]	true	Make it not a tree

         */

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(new ArrayList<>(Arrays.asList(0,1)));
        edges.add(new ArrayList<>(Arrays.asList(0,2)));
        edges.add(new ArrayList<>(Arrays.asList(1,3)));
        edges.add(new ArrayList<>(Arrays.asList(1,4)));
        edges.add(new ArrayList<>(Arrays.asList(2,5)));
        edges.add(new ArrayList<>(Arrays.asList(2,6)));
        edges.add(new ArrayList<>(Arrays.asList(4,6)));
        edges.add(new ArrayList<>(Arrays.asList(6,1)));
        int numModes = 7;
        List<GraphVertex> graph = new ArrayList<>();
        for (int i = 0; i < numModes; i++) {
            graph.add(new GraphVertex(i));
        }
        for (List<Integer> e : edges) {
            if (e.get(0) < 0 || e.get(0) >= numModes || e.get(1) < 0 || e.get(1) >= numModes) {
                throw new RuntimeException("Invalid vertex index");
            }
            graph.get(e.get(0)).edges.add(graph.get(e.get(1)));
        }

        StdOut.println(isDeadlocked(graph));
    }

}
