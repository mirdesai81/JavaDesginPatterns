package com.java.algorithm.tree.trie;

import com.java.stdlib.StdOut;

import java.util.*;

public class SearchWordsInMatrix {
    private static int M,N;


    private static int row[] = {-1,-1,-1, 0, 0,1,1,1};
    private static int col[] = {-1,0,1,-1,1,-1,0,1};

    private static boolean canMove(char[][] matrix,int i, int j, boolean[][] visited,char ch) {
        return i >= 0 && i < M
                && j >= 0 && j < N
                && !visited[i][j]
                 && matrix[i][j] == ch;
    }

    private static void searchMatrix(Trie root,char[][] matrix, int i , int j, boolean[][] visited, String path, Set<String> result) {
        if(root.isLaaf()) {
            result.add(path);
            return;
        }

        visited[i][j] = true;

        for(Map.Entry<Character,Trie> entry : root.getChildren().entrySet()) {
            for(int k = 0; k < 8; k++) {
                if(canMove(matrix,i + row[k], j + col[k],visited,entry.getKey())){
                    searchMatrix(entry.getValue(),matrix,i + row[k], j + col[k],visited,path + entry.getKey(),result);
                }
            }
        }

        visited[i][j] = false;
    }

    public static Set<String> searchMatrix(char[][] matrix,List<String> words) {
        Trie root = new Trie();
        for(String word : words) {
            root.insert(word);
        }

        boolean[][] visited = new boolean[M][N];
        for(boolean[] row : visited) {
            Arrays.fill(row,false);
        }

        Set<String> result = new HashSet<>();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                char ch = matrix[i][j];
                if(root.getChildren().containsKey(ch)) {
                    searchMatrix(root.getChildren().get(ch),matrix,i,j,visited,Character.toString(ch),result);
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        char[][] board =
                {
                        {'M', 'S', 'E', 'F'},
                        {'R', 'A', 'T', 'D'},
                        {'L', 'O', 'N', 'E'},
                        {'K', 'A', 'F', 'B'}
                };

        M = board.length;
        N = board[0].length;

        List<String> words = Arrays.asList("START", "NOTE", "SAND", "STONED");
        StdOut.println(searchMatrix(board,words));

    }
}
