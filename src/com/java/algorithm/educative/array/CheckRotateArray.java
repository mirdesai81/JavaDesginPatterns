package com.java.algorithm.educative.array;

class CheckRotateArray
{
    //Rotates given Array by 1 position
    public static void rotateArray(int[] arr) {

        //Store last element of Array.
        //Start from the Second last and Right Shift the Array by one.
        //Store the last element saved on the first index of the Array.
        int lastElement = arr[arr.length - 1];

        for (int i = arr.length - 1; i > 0; i--) {

            arr[i] = arr[i - 1];
        }

        arr[0] = lastElement;
    } //end of rotateArray

    public static void main(String args[]) {

        int[] arr = {3, 6, 1, 8, 4, 2};

        System.out.print("Array before rotation: ");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        rotateArray(arr);

        System.out.print("Array after rotation: ");
        print(arr);

        int[] arr1 = {3, 6, 1, 8, 4, 2};
        rotate(arr1,3);
        print(arr1);
    }
    public static void reverse(int[] a,int low,int high) {
        while(low < high) {
            swap(a,low,high);
            low++;
            high--;
        }
    }

    private static void print(int a[]) {
        for(int i = 0; i < a.length;++i) {
            if(i == a.length - 1) {
                System.out.print(a[i]);
            } else {
                System.out.print(a[i] + " --> ");
            }
        }

        System.out.println("");
    }

    private static void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void rotate(int[] a,int num) {
        int length = a.length;
        if(length == 0) {
            return;
        }

        num = num % length;

        if(num == 0) {
            return;
        }

        reverse(a,0,length - 1);
        /*print(a);*/
        reverse(a,0,num - 1);
        /*print(a);*/
        reverse(a,num,length - 1);
        /*print(a);*/
    }

}