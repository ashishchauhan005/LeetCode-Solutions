class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n=grid.length;
        int prevsum=0;
        int newsum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int rowmax=0;
                int colmax=0;
                prevsum+=grid[i][j];
                for(int k=0;k<n;k++){
                    if(grid[i][k]>rowmax){
                        rowmax=grid[i][k];
                    }
                    if(grid[k][j]>colmax){
                        colmax=grid[k][j];
                    }

                }
                grid[i][j]=Math.min(rowmax,colmax);
                newsum+=grid[i][j];
            }
        }
        return newsum-prevsum;
    }
}