package com.java.algorithm.graph.base;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectGraph {
    ArrayList<Project> projects = new ArrayList<>();
    HashMap<String,Project> map = new HashMap<>();

    public Project getOrCreateNode(String name) {
        if(!map.containsKey(name)) {
            Project p = new Project(name);
            projects.add(p);
            map.put(name,p);
        }

        return map.get(name);
    }

    public void addEdge(String start,String end) {
        Project s = getOrCreateNode(start);
        Project e = getOrCreateNode(end);
        s.addNeighbor(e);
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }
}
