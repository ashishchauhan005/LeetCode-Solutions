import java.util.*;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Map to store PriorityQueue (Min-Heap) for each diagonal index (row - col)
        Map<Integer, PriorityQueue<Integer>> diagonals = new HashMap<>();
        
        // Step 1: Put all elements into their respective diagonal heaps
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diagonalKey = i - j;
                diagonals.putIfAbsent(diagonalKey, new PriorityQueue<>());
                diagonals.get(diagonalKey).add(mat[i][j]);
            }
        }
        
        // Step 2: Poll elements out of the heaps back into the matrix in sorted order
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diagonalKey = i - j;
                mat[i][j] = diagonals.get(diagonalKey).poll();
            }
        }
        
        return mat;
    }
}
