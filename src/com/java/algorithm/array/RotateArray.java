package com.java.algorithm.array;

/**
 * Created by mihir.desai on 4/12/2018.
 */
public class RotateArray {

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

    public static int maxSum(int[] a) {
        int low = 0;
        int high = a.length - 1;
        int temp = a.length - 1;
        int total = 0;
        do {
            total = a[low] + a[low + 1];

            int rotation = (high - low + 1) - 2;
            rotate(a,rotation);

            if(a[low] == Integer.MIN_VALUE && a[low+1] == Integer.MIN_VALUE ) {
                return total;
            }

            a[high] = Integer.MIN_VALUE;
            a[high - 1] = Integer.MIN_VALUE;
            System.out.println("After rotation");
            print(a);
            temp = temp - 2;
            int pos = binarySearch(a,low,temp,total);
            System.out.println("total = "+total+" ,pos = "+pos+" temp = "+temp);
            for(int k = temp + 1;k > pos; --k) {
                a[k] = a[k - 1];
            }
            print(a);
            a[pos] = total;
            temp = temp + 1;
            System.out.println("After adding total = "+total);
            print(a);
        } while(a[low] != Integer.MIN_VALUE || a[low+1] != Integer.MIN_VALUE);

        return total;
    }

    public static int binarySearch(int a[],int low,int high,int total) {
        int mid = 0;
        if(total > a[high]) {
            return high + 1;
        }

        if(total < a[low]) {
            return low;
        }

        while(low <= high) {
            mid = (low + high)/2;
            if(a[mid] < total) {
                low = mid + 1;
            } else if(a[mid] > total) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return mid;
    }

    public static void main(String[] args) {
        int[] A = new int[] {-2, -1,7, 22, 24, 25, 30, 32, 37};
        print(A);
        System.out.println(maxSum(A));
       /* rotate(A,4);
        print(A);*/
    }
}
