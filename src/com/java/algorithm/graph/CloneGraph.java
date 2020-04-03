package com.java.algorithm.graph;

import com.java.stdlib.StdOut;

import java.util.*;
import java.util.stream.Collectors;

public class CloneGraph {

    private static class GraphVertex {

        public Integer label;

        public List<GraphVertex> edges;

        public GraphVertex(Integer label) {
            this.label = label;
            this.edges = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "GraphVertex{" +
                    "label=" + label +
                    '}';
        }
    }

    static void printGraph(GraphVertex graph)
    {
        Stack<GraphVertex> s = new Stack<>();
        Set<Integer> set = new HashSet<>();
        s.push(graph);


        while(!s.isEmpty()) {
            GraphVertex v = s.pop();
            set.add(v.label);
            System.out.print("Vertex - "+v.label);
            if(v.edges != null && !v.edges.isEmpty()) {
                System.out.print(", Edges - ");
                for(GraphVertex e : v.edges) {
                    if(!set.contains(e.label))
                       s.push(e);
                }

                String edges = v.edges.stream().map(e -> String.valueOf(e.label)).collect(Collectors.joining(","));
                System.out.print(edges);
            }
            System.out.println();
        }
    }

    public static GraphVertex cloneGraph(GraphVertex g) {
        if(g == null) {
            return null;
        }

        Map<GraphVertex,GraphVertex> vertexMap = new HashMap<>();
        Queue<GraphVertex> q = new LinkedList<>();
        q.add(g);
        vertexMap.put(g, new GraphVertex(g.label));
        while(!q.isEmpty()) {
            GraphVertex curr = q.remove();

            for(GraphVertex e : curr.edges) {

                // Copy current edges
                if(!vertexMap.containsKey(e)) {
                    vertexMap.put(e, new GraphVertex(e.label));
                    q.add(e);
                }

                // Copy the edge to curr
                vertexMap.get(curr).edges.add(vertexMap.get(e));
            }


        }

        return vertexMap.get(g);
    }

    public static void main(String[] args) {
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

        GraphVertex clone = cloneGraph(graph.get(0));
        printGraph(clone);
    }
}
