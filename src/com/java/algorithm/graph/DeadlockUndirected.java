package com.java.algorithm.graph;

import com.java.stdlib.StdOut;

import java.util.*;

public class DeadlockUndirected {

    public static class Edge {
        Integer from;
        Integer to;

        public Edge(Integer from, Integer to) {
            this.from = from;
            this.to = to;
        }
    }

    public static Map<Integer,Set<Integer>> buildGraph(List<Edge> edges) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        for(Edge edge : edges) {
            Set<Integer> fromEdges = graph.computeIfAbsent(edge.from,k -> new HashSet<>());
            fromEdges.add(edge.to);

            Set<Integer> toEdges = graph.computeIfAbsent(edge.to,k -> new HashSet<>());
            toEdges.add(edge.from);
        }

        return graph;
    }

    public static boolean detectDeadlock(Map<Integer,Set<Integer>> graph) {
        Iterator<Integer> nodeIter = graph.keySet().iterator();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> nodesInStack = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        boolean isCycle = false;

        while(nodeIter.hasNext() && !isCycle) {
            Integer node = nodeIter.next();

            if(visited.contains(node)) continue;

            stack.push(node);
            nodesInStack.add(node);

            while(!stack.isEmpty() && !isCycle) {
                node = stack.pop();
                nodesInStack.remove(node);

                // prevent adjacent node being considered a cycle
                if(visited.contains(node)) continue;

                visited.add(node);

                for( Integer it : graph.get(node)) {
                    if(nodesInStack.contains(it)) {
                        isCycle = true;
                        break;
                    }

                    stack.push(it);
                    nodesInStack.add(it);
                }


            }
        }

        return isCycle;
    }


    public static void main(String[] args) {
        List<Edge> list = new ArrayList<>();
        list.add(new Edge(0,1));
        list.add(new Edge(0,2));
        list.add(new Edge(1,3));
        list.add(new Edge(1,4));
        list.add(new Edge(2,5));
        list.add(new Edge(2,6));
       // list.add(new Edge(4,6));
       // list.add(new Edge(6,1));
        Map<Integer,Set<Integer>> graph = buildGraph(list);
        StdOut.println(detectDeadlock(graph));

    }
}
