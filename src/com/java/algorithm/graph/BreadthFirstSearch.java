package com.java.algorithm.graph;

import com.java.algorithm.graph.base.Graph;
import com.java.algorithm.graph.base.Node;
import com.java.algorithm.graph.base.State;
import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {
    public static void main(String[] args) {
       Graph g = setGraphData();

       Node start = g.getNodes().get(2);
       Node end = g.getNodes().get(1);

       StdOut.println(Search(g,start,end));
    }

    public static Graph setGraphData() {
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
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < numModes; i++) {
            nodes.add(new Node(i));
        }
        for (List<Integer> e : edges) {
            if (e.get(0) < 0 || e.get(0) >= numModes || e.get(1) < 0 || e.get(1) >= numModes) {
                throw new RuntimeException("Invalid vertex index");
            }
            nodes.get(e.get(0)).getAdjacentList().add(nodes.get(e.get(1)));
        }


        return new Graph(nodes);
    }

    public static boolean Search(Graph g, Node start, Node end) {

        for(Node n : g.getNodes()) {
            n.setState(State.Unvisited);
        }

        LinkedList<Node> queue = new LinkedList<>();
        start.setState(State.Visiting);
        queue.add(start);
        Node curr;
        while(!queue.isEmpty()) {
            curr = queue.removeFirst();
            if(curr != null) {
                for(Node adj : curr.getAdjacentList()) {
                    if(adj.getState() == State.Unvisited) {
                        if(adj == end) {
                            return true;
                        } else {
                            adj.setState(State.Visiting);
                            queue.add(adj);
                        }
                    }
                }
                curr.setState(State.Visited);
            }
        }

        return false;
    }
}
