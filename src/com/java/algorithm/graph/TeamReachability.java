package com.java.algorithm.graph;

import com.java.stdlib.StdOut;

import java.util.*;

public class TeamReachability {

    public static class MatchResult {
        public String winningTeam;
        public String loosingTeam;

        public MatchResult(String winningTeam,String loosingTeam) {
            this.winningTeam = winningTeam;
            this.loosingTeam = loosingTeam;
        }
    }

    public static boolean canTeamABeatTeamB(List<MatchResult> matches,String teamA,String teamB) {
        Set<String> visited = new HashSet<>();
        return isReachableDFS(buildGraph(matches),teamA,teamB, visited);
    }

    public static Map<String,Set<String>> buildGraph(List<MatchResult> matches) {
        Map<String,Set<String>> graph = new HashMap<>();
        for(MatchResult matchResult : matches) {
            Set<String> edges = graph.computeIfAbsent(matchResult.winningTeam,k -> new HashSet<>());
            edges.add(matchResult.loosingTeam);
        }

        return graph;
    }


    public static boolean isReachableDFS(Map<String,Set<String>> graph,String teamA,String teamB,Set<String> visited) {
        Stack<String> stack = new Stack<>();
        stack.push(teamA);
        visited.add(teamA);
        String curr;
        while(!stack.isEmpty()) {
            curr = stack.pop();
            if(curr.equals(teamB)) {
                return true;
            } else if(graph.get(curr) != null) {
                for(String team : graph.get(curr)) {
                    if(!visited.contains(team)) {
                        stack.push(team);
                        visited.add(team);
                    }
                }
            }
        }

        return false;
    }


    private static boolean isReachableBFS(Map<String, Set<String>> graph,
                                          String curr, String dest,
                                          Set<String> visited) {
        Queue<String> frontier = new LinkedList<>();
        visited.add(curr);
        frontier.add(curr);
        while (!frontier.isEmpty()) {
            String justReached = frontier.poll();
            if (justReached != null && justReached.equals(dest)) {
                return true;
            } else if (graph.get(justReached) != null) {
                for (String team : graph.get(justReached)) {
                    if (!visited.contains(team)) {
                        visited.add(team);
                        frontier.add(team);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<MatchResult> matches = Arrays.asList(
                new MatchResult("Texas", "Cal"), new MatchResult("Cal", "Stanford"),
                new MatchResult("Stanford", "Texas"),
                new MatchResult("Stanford", "MIT"), new MatchResult("Stanford", "CIT"),
                new MatchResult("UCLA", "USC"));

        StdOut.println(canTeamABeatTeamB(matches, "Texas", "MIT"));

        StdOut.println(
        canTeamABeatTeamB(matches, "Cal", "UCLA"));
    }


}
