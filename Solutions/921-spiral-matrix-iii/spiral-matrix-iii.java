// class Solution {
//     public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
//         int east=cols;
//         int west=0;
//         int north=0;
//         int south=rows;
//         int[][] ans=new int[rows*cols][2];
//         while(true){
            
//         }
//     }
// }
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int count = 0;
        
        // Add the starting coordinate
        res[count++] = new int[]{rStart, cStart};
        
        // Define direction moves: East, South, West, North
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        int r = rStart;
        int c = cStart;
        int dirIdx = 0;  // Start facing East
        int steps = 1;   // Initial step length
        
        while (count < rows * cols) {
            // Repeat the current step length twice (e.g., E then S, W then N)
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    r += dr[dirIdx];
                    c += dc[dirIdx];
                    
                    // Only record the coordinate if it falls inside the grid
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        res[count++] = new int[]{r, c};
                        
                        // Early exit if we have visited all cells
                        if (count == rows * cols) {
                            return res;
                        }
                    }
                }
                // Turn clockwise: East -> South -> West -> North -> East
                dirIdx = (dirIdx + 1) % 4;
            }
            // Increase step size after completing 2 directions
            steps++;
        }
        
        return res;
    }
}
