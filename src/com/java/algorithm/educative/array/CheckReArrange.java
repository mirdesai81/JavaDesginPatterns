package com.java.algorithm.educative.array;

class CheckReArrange {


    //Re-Arrange Positive and Negative Values of Given Array
    public static void reArrange(int[] arr)
    {
        int writeIdx = 0;
        for (int readIdx = 0; readIdx < arr.length; readIdx++) {
            if (arr[readIdx] < 0) {   // if negative number found
                if (readIdx != writeIdx) {
                    int temp = arr[readIdx];
                    arr[readIdx] = arr[writeIdx]; // swapping with leftmost positive
                    arr[writeIdx] = temp;
                }
                writeIdx++;
            }
        }
    } //end of reArrange()

    public static void main(String args[]) {

        int[] arr = {2, 4, -6, 8, -5, -10};

        System.out.print("Array before re-arranging: ");
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        reArrange(arr);

        System.out.print("Array after rearranging: ");
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}