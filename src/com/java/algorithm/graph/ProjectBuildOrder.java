package com.java.algorithm.graph;

import com.java.algorithm.graph.base.Project;
import com.java.algorithm.graph.base.ProjectGraph;
import com.java.stdlib.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ProjectBuildOrder {

    public static Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        ProjectGraph graph = buildGraph(projects,dependencies);
        return orderProjects(graph.getProjects());
    }


    private static Project[] orderProjects(ArrayList<Project> projects) {
        Project[] order = new Project[projects.size()];

        // First find non dependent projects
        int offset = nonDependentProjects(order,projects,0);

        int toBeProcessed = 0;
        while(toBeProcessed < order.length) {
            Project current = order[toBeProcessed];

            if(current == null) {
                return null;
            }

            // Decrement dependencies of current from neighbor is same as removing the edge
            ArrayList<Project> children = current.getChildren();
            for(Project child : children) {
                child.decrementDependencies();
            }

            offset = nonDependentProjects(order,children,offset);

            toBeProcessed++;
        }


        return order;
    }

    private static int nonDependentProjects(Project[] order,ArrayList<Project> projects,int offset) {


        for(Project project : projects) {
            if(project.getDependencies() == 0) {
                order[offset] = project;
                offset++;
            }
        }

        return offset;
    }

    private static ProjectGraph buildGraph(String[] projects,String[][] dependencies) {

        ProjectGraph graph = new ProjectGraph();

        for(String project : projects) {
            graph.getOrCreateNode(project);
        }

        for(int i = 0; i < dependencies.length; i++) {
            graph.addEdge(dependencies[i][0] , dependencies[i][1]);
        }

        return graph;

    }

    public static void main(String[] args) {
        String[] projects = new String[] {"a","b","c","d", "e", "f"};
        // (a, d), (f, b), (b, d), (f, a), (d, c)
        String[][] dependencies  = new String[][] {{"f","c"} ,{"f","b"}, {"f","a"},
                                                    {"c","a"},{"b","a"},{"a","e"} ,{"b" , "e"},
                                                    {"d" , "g"}};
        Project[] order = findBuildOrder(projects, dependencies);

        if(order != null) {

            String output = Arrays.asList(order).stream().map(Project::getName).collect(Collectors.joining(","));
            StdOut.print(output);
        }
    }
}
