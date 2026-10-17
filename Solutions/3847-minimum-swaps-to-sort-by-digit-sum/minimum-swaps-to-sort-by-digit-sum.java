import java.util.Arrays;

class Solution {
    // Helper method to calculate the sum of digits
    private int getDigitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // Step 1: Track the number, its original index, and its digit sum
        // Each element array is configured as: [value, original_index, digit_sum]
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
            arr[i][2] = getDigitSum(nums[i]);
        }
        
        // Step 2: Sort based on custom rules: digit_sum first, then the number itself
        Arrays.sort(arr, (a, b) -> {
            if (a[2] != b[2]) {
                return Integer.compare(a[2], b[2]); // Sort by digit sum
            }
            return Integer.compare(a[0], b[0]);     // Tiebreaker: sort by value
        });
        
        // Step 3: Map each original index to its target position in the sorted array
        int[] targetMap = new int[n];
        for (int sortedIdx = 0; sortedIdx < n; sortedIdx++) {
            int originalIdx = arr[sortedIdx][1];
            targetMap[originalIdx] = sortedIdx;
        }
        
        // Step 4: Count the permutation cycles
        boolean[] visited = new boolean[n];
        int numCycles = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                numCycles++;
                int curr = i;
                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = targetMap[curr];
                }
            }
        }
        
        // The minimum number of swaps is equal to n - number_of_cycles
        return n - numCycles;
    }
}
