package com.java.algorithm.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BoxStacking {

    private static class Box {
        public int width;
        public int height;
        public int depth;
        public Box(int w, int h, int d) {
            width = w;
            height = h;
            depth = d;
        }

        public boolean canBeUnder(Box b) {
            if (width > b.width && height > b.height && depth > b.depth) {
                return true;
            }
            return false;
        }

        public boolean canBeAbove(Box b) {
            if (b == null) {
                return true;
            }
            if (width < b.width && height < b.height && depth < b.depth) {
                return true;
            }
            return false;
        }

        public String toString() {
            return "Box(" + width + "," + height + "," + depth + ")";
        }
    }

    private static class BoxComparator implements Comparator<Box> {
        @Override
        public int compare(Box x, Box y){
            return y.height - x.height;
        }
    }


    public static int createStack(ArrayList<Box> boxes) {
        Collections.sort(boxes, new BoxComparator());
        int[] stackMap = new int[boxes.size()];
        return createStack(boxes, null, 0, stackMap);
    }

    public static int createStack(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap) {
        if (offset >= boxes.size()) {
            return 0;
        }

        /* height with this bottom */
        Box newBottom = boxes.get(offset);
        int heightWithBottom = 0;
        if (bottom == null || newBottom.canBeAbove(bottom)) {
            if (stackMap[offset] == 0) {
                stackMap[offset] = createStack(boxes, newBottom, offset + 1, stackMap);
                stackMap[offset] += newBottom.height;
            }
            heightWithBottom = stackMap[offset];
        }

        /* without this bottom */
        int heightWithoutBottom = createStack(boxes, bottom, offset + 1, stackMap);

        return Math.max(heightWithBottom, heightWithoutBottom);
    }


    public static void main(String[] args) {
        Box[] boxList = { new Box(6, 4, 4), new Box(8, 6, 2), new Box(5, 3, 3), new Box(7, 8, 3), new Box(4, 2, 2), new Box(9, 7, 3)};
        ArrayList<Box> boxes = new ArrayList<Box>();
        for (Box b : boxList) {
            boxes.add(b);
        }

        int height = createStack(boxes);
        System.out.println(height);
    }
}
