package com.java.algorithm.stack;

import java.util.*;

public class ExamineBuildingsWithSunset {

    private static class BuildingWithHeight {
        public Integer id;
        public Integer height;

        public BuildingWithHeight(Integer id, Integer height) {
            this.id = id;
            this.height = height;
        }

        @Override
        public String toString() {
            return "BuildingWithHeight [" +
                    "id=" + id +
                    ", height=" + height +
                    ']';
        }
    }

    public static Stack<BuildingWithHeight> examineBuildingsWithSunset(Iterator<Integer> sequence) {
        int id = 0;
        Stack<BuildingWithHeight> buildingWithSunsetView = new Stack<>();

        while(sequence.hasNext()) {
            Integer height = sequence.next();
            // compare the height with exisiting in stack and if current height is greater than keep removing smaller height from stack
            // since it blocks the building
            while(!buildingWithSunsetView.isEmpty() &&
                    Integer.compare(height,buildingWithSunsetView.peek().height) >= 0) {
                // keep removing
                buildingWithSunsetView.pop();
            }

            buildingWithSunsetView.push(new BuildingWithHeight(id++,height));
        }



        return buildingWithSunsetView;
    }

    public static Stack<BuildingWithHeight> examineBuildingsWithSunsetWestToEast(Iterator<Integer> sequence) {
        int id = 0;
        Stack<BuildingWithHeight> buildingWithSunsetView = new Stack<>();

        while(sequence.hasNext()) {
            Integer height = sequence.next();
            // if stack is empty or curr height is greater than first element of stack then push
            if(buildingWithSunsetView.isEmpty() ||
                    Integer.compare(height,buildingWithSunsetView.peek().height) > 0) {
                buildingWithSunsetView.push(new BuildingWithHeight(id++,height));
            }


        }

        return buildingWithSunsetView;
    }

    public static void main(String[] args) {
        LinkedList<Integer> eastToWestBuildings = new LinkedList<>(Arrays.asList(10,20,5,9,4,2));

        System.out.println(examineBuildingsWithSunset(eastToWestBuildings.iterator()));

        LinkedList<Integer> westToEast = new LinkedList<>(Arrays.asList(2,4,9,5,20,10));
        System.out.println(examineBuildingsWithSunsetWestToEast(westToEast.iterator()));
    }
}
