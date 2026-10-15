import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        // 1. Sort diagonals starting from the first column (row i, col 0)
        for (int i = 0; i < m; i++) {
            sortSingleDiagonal(mat, i, 0, m, n);
        }
        
        // 2. Sort diagonals starting from the first row (row 0, col j)
        // Start j from 1 because (0,0) was already covered above
        for (int j = 1; j < n; j++) {
            sortSingleDiagonal(mat, 0, j, m, n);
        }
        
        return mat;
    }
    
    private void sortSingleDiagonal(int[][] mat, int row, int col, int m, int n) {
        List<Integer> diagonalValues = new ArrayList<>();
        
        // Step A: Collect all elements along this diagonal
        int r = row, c = col;
        while (r < m && c < n) {
            diagonalValues.add(mat[r][c]);
            r++;
            c++;
        }
        
        // Step B: Sort the collected elements
        Collections.sort(diagonalValues);
        
        // Step C: Write the sorted elements back into the matrix
        r = row; 
        c = col;
        int index = 0;
        while (r < m && c < n) {
            mat[r][c] = diagonalValues.get(index++);
            r++;
            c++;
        }
    }
}
