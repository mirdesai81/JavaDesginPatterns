package com.java.algorithm.array;

public class MatrixRotationKTimes {

    private int size;
    private int[][] m;

    public MatrixRotationKTimes(int size) {
        this.size = size;
        m = new int[size][size];
        initialize();
    }

    public void rotateKTimes(int k) {
        while(k > 0) {
            rotate();
            --k;
        }
    }

    public void rotateKTimesAntiClockwise(int k) {
        while(k > 0) {
            rotateAnticlockwise();
            --k;
        }
    }

    private void rotate() {

        int endIndex = size;
        int col = 0;
        int row = 0;

        // Start with m[0][0] , m[1][1], m[2,2]
        while(col < size/2) {
            row = col;
            int temp = m[row][col];
            int start = col;

            // always starts from 1st element of each cycle and end at 2nd last element
            while(row < endIndex - 1) {
                m[row][col] = m[++row][col];
             } // row = size - 1


            while(col < endIndex - 1) {
                m[row][col] = m[row][++col];
            } // col = size - 1

            // go up
           /* int offset = size - endIndex;*/

            // move from size - 1 to initial
            while(row > start) {
                m[row][col] = m[--row][col];
            }


            // move from size - 1 to initial + 1
            while(col > start + 1) {
                m[row][col] = m[row][--col];
            } // col = 1

            m[row][col] = temp;
            --endIndex;
        }

    }

    private void rotateAnticlockwise() {
        int endIndex= size,col = 0, row = 0;

        while(row < size/2) {
            col = row;
            int temp = m[row][col];
            int start = row;
            while(col < endIndex - 1) {
                m[row][col] = m[row][++col];
            } // col = size - 1

            while(row < endIndex - 1) {
                m[row][col] = m[++row][col];
            } // row = size - 1



            while(col > start ) {
                m[row][col] = m[row][--col];
            }

            while(row > start + 1) {
                m[row][col] = m[--row][col];
            }

            m[row][col] = temp;
            endIndex--;
        }

    }

    public void initialize() {
        int val = 1;
        for(int i = 0 ; i <= size -1; ++i) {
            for(int j = 0; j <= size - 1; ++j) {
                m[i][j] = val++;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <= size -1; ++i) {
            for(int j = 0; j <= size - 1; ++j) {
                sb.append(m[i][j] + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {


            MatrixRotationKTimes m = new MatrixRotationKTimes(4);
            System.out.println("Before");
            System.out.println(m.toString());
            m.rotateKTimes(1);
            System.out.println("After");
            System.out.println(m.toString());

            m = new MatrixRotationKTimes(4);
            System.out.println("Before");
            System.out.println(m.toString());
            m.rotateKTimesAntiClockwise(1);
            System.out.println("After");
            System.out.println(m.toString());

    }
}
