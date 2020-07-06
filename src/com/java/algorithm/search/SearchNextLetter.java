package com.java.algorithm.search;

public class SearchNextLetter {


        public static char searchNextLetter(char[] letters, char key) {
            // TODO: Write your code here
            int n = letters.length;
            if( key <= letters[0] || key > letters[n - 1]) {
                return letters[0];
            }

            int start = 0;
            int end = n - 1;

            while(start <= end) {
                int mid = start + (end - start)/2;
                if(key < letters[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return letters[start % n];
        }

        public static void main(String[] args) {
            System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' , 'j'}, 'i'));
            System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
            System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
            System.out.println(searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
        }

}
