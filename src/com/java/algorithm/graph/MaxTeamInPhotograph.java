package com.java.algorithm.graph;

import com.java.stdlib.StdOut;

import java.util.*;

public class MaxTeamInPhotograph {

    public static class GraphVertex {
        public List<GraphVertex> edges = new ArrayList<>();
        public int maxDistance = 1;
        public boolean visited = false;

    }

    public static class Edge {
        public int from;
        public int to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static int findLargestNumberTeams(List<GraphVertex> graph) {
       /* int maxLevel = 0;

        for(GraphVertex g : graph) {
            if(g.maxDistance == 0) {
                maxLevel = Math.max(maxLevel, DFS(g));
            }
        }

        return maxLevel;*/

        Deque<GraphVertex> orderedVertices = buildTopologicalOrdering(graph);
        return findLongestPath(orderedVertices);
    }

    private static int findLongestPath(Deque <GraphVertex> orderedVertices) {
        int maxDistance = 0;
        while (!orderedVertices.isEmpty()){
            GraphVertex u = orderedVertices.peekFirst();
            maxDistance = Math.max(maxDistance , u.maxDistance);
            for (GraphVertex v : u.edges) {
                v.maxDistance = Math.max(v.maxDistance , u.maxDistance + 1);
            }
            orderedVertices.removeFirst();
        }
        return maxDistance;
    }

    private static Deque<GraphVertex> buildTopologicalOrdering(List<GraphVertex> G) {
        Deque<GraphVertex> orderedVertices = new LinkedList<>();
        for (GraphVertex g : G){
            if(!g .visited) {
                DFS(g, orderedVertices);
            }
        }
        return orderedVertices;
    }


    private static void DFS(GraphVertex curr, Deque<GraphVertex> orderedVertices) {
       /* curr.visited = true;
        Queue<GraphVertex> s = new LinkedList<>();
        s.add(curr);

        while(!s.isEmpty()) {
            GraphVertex next = s.poll();
            for(GraphVertex e : next.edges) {
                if(!e.visited) {
                    e.visited = true;
                    s.add(e);

                }
            }

            orderedVertices.addFirst(next);
        }*/

        curr.visited = true;
        for (GraphVertex next : curr.edges) {
            if (!next.visited) {
                DFS(next, orderedVertices);
            }
        }

        orderedVertices.addFirst(curr);
    }

 /*   private static int DFS(GraphVertex curr) {
        curr.maxDistance = 1;

        for(GraphVertex v : curr.edges) {
            curr.maxDistance = Math.max(
                    curr.maxDistance ,
                    (v.maxDistance != 0 ? v.maxDistance : DFS(v)) + 1
                    );
        }



        return curr.maxDistance;
    }*/

    public static void main(String[] args) {
        // [[0, 2], [2, 3], [0, 3], [1, 4]]
        List<List<Integer>> edges = new ArrayList<>();

        edges.add(new ArrayList<>(Arrays.asList(0,2)));
        edges.add(new ArrayList<>(Arrays.asList(2,3)));
        edges.add(new ArrayList<>(Arrays.asList(0,3)));
        edges.add(new ArrayList<>(Arrays.asList(1,4)));

        int numModes = 5;
        List<GraphVertex> graph = new ArrayList<>();
        for (int i = 0; i < numModes; i++) {
            graph.add(new GraphVertex());
        }

        for (List<Integer> e : edges) {
            if (e.get(0) < 0 || e.get(0) >= numModes || e.get(1) < 0 || e.get(1) >= numModes) {
                throw new RuntimeException("Invalid vertex index");
            }
            graph.get(e.get(0)).edges.add(graph.get(e.get(1)));
        }

        StdOut.println(findLargestNumberTeams(graph));
    }

}
