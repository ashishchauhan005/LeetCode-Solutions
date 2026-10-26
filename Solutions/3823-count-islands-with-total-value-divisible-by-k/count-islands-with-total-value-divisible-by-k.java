import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long islandSum = bfs(grid, i, j, m, n);
                    if (islandSum % k == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    private long bfs(int[][] grid, int startX, int startY, int m, int n) {
        long sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{startX, startY});
        sum += grid[startX][startY];
        grid[startX][startY] = 0; 
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0) {
                    sum += grid[nr][nc];
                    grid[nr][nc] = 0; 
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        return sum;
    }
}
