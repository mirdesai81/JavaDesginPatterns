package com.java.algorithm.graph.base;

import java.util.ArrayList;
import java.util.HashMap;

public class Project {
    private ArrayList<Project> children = new ArrayList<>();
    private HashMap<String, Project> map = new HashMap<>();
    private String name;
    private int dependencies = 0;

    public Project(String name) {
        this.name = name;
    }

    public void addNeighbor(Project node) {
        if(!map.containsKey(node.name)) {
            map.put(node.name,node);
            children.add(node);
            node.incrementDependencies();
        }
    }

    public void incrementDependencies() { ++dependencies;}

    public void decrementDependencies() {--dependencies;}

    public ArrayList<Project> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Project> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDependencies() {
        return dependencies;
    }

    public void setDependencies(int dependencies) {
        this.dependencies = dependencies;
    }

    @Override
    public String toString() {
        return "Project{" + name + '}';
    }
}
