class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        int[] rowmax=new int[n];
        int[] colmax=new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rowmax[i] = Math.max(rowmax[i], grid[i][j]);
                colmax[j] = Math.max(colmax[j], grid[i][j]);
                
            }
        }
        int Increase=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Increase+=Math.min(rowmax[i],colmax[j])-grid[i][j];
            }
        }
        return Increase;
    }
}