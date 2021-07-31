package com.java.algorithm.educative.strings;

class PalindromeSubStrings{
    public static boolean isPalindrome(String input, int i, int j) {
        while(j > i){
            if(input.charAt(i) != input.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int findAllPalindromeSubstrings(String input) {
        int count = 0;
        for(int i = 0 ; i < input.length() ; i++) {
            for(int j = i + 1 ; j < input.length() ; j++) {
                if(isPalindrome(input,i,j)){
                    System.out.println(input.substring(i,j+1));
                    count++;
                }
            }
        }

        return count;
    }
    public static void main(String[] args) {
        String str = "aabbbaa";
        int count = findAllPalindromeSubstrings(str);
        System.out.println("Total palindrome substrings: " + count);
    }
}
