package com.java.algorithm.graph.base;

import java.util.LinkedList;
import java.util.List;

public class Node {
    private Integer vertex;
    private List<Node> adjacent = new LinkedList<>();
    private State state;

    public Node(Integer vertex) {
        this.vertex = vertex;
    }

    public Integer getVertex() {
        return vertex;
    }

    public void setVertex(Integer vertex) {
        this.vertex = vertex;
    }

    public List<Node> getAdjacentList() {
        return adjacent;
    }

    public void setAdjacentList(List<Node> adjacent) {
        this.adjacent = adjacent;
    }

    public void addAdjacent(Node adj) {
        adjacent.add(adj);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertex=" + vertex +
                ", state=" + state +
                '}';
    }
}
