class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            sortDiagonal(mat, i, 0, m, n);
        }
        for (int j = 1; j < n; j++) {
            sortDiagonal(mat, 0, j, m, n);
        }
        return mat;
    }
    private void sortDiagonal(int[][] mat, int row, int col, int m, int n) {
        List<Integer> diagonal = new ArrayList<>();
        int r = row, c = col;
        while (r < m && c < n) {
            diagonal.add(mat[r][c]);
            r++;
            c++;
        }
        Collections.sort(diagonal);
        r = row; 
        c = col;
        int index = 0;
        while (r < m && c < n) {
            mat[r][c] = diagonal.get(index++);
            r++;
            c++;
        }
    }
}