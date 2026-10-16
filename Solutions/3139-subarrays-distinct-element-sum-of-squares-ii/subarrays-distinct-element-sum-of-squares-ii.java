import java.util.*;

class Solution {
    private int MOD = 1000000007;
    private int n;
    
    // Two BIT arrays needed to support Range Updates and Range Queries
    private long[] bit1;
    private long[] bit2;

    // Standard BIT update operation
    private void bitUpdate(long[] bit, int idx, long val) {
        for (; idx <= n; idx += idx & -idx) {
            bit[idx] = (bit[idx] + val) % MOD;
        }
    }

    // Range update helper: adds 'val' to the range [l, r] (1-indexed)
    private void rangeUpdate(int l, int r, long val) {
        bitUpdate(bit1, l, val);
        bitUpdate(bit1, r + 1, -val + MOD);
        
        bitUpdate(bit2, l, val * (l - 1) % MOD);
        bitUpdate(bit2, r + 1, (-val * r % MOD + MOD) % MOD);
    }

    // Standard BIT prefix sum query operation
    private long bitQuery(long[] bit, int idx) {
        long sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum = (sum + bit[idx]) % MOD;
        }
        return sum;
    }

    // Prefix query helper: returns the sum from index 1 to idx
    private long prefixQuery(int idx) {
        long term1 = bitQuery(bit1, idx) * idx % MOD;
        long term2 = bitQuery(bit2, idx);
        return (term1 - term2 + MOD) % MOD;
    }

    // Range query helper: returns the sum of elements in the range [l, r]
    private long rangeQuery(int l, int r) {
        return (prefixQuery(r) - prefixQuery(l - 1) + MOD) % MOD;
    }

    public int sumCounts(int[] nums) {
        this.n = nums.length;
        this.bit1 = new long[n + 2];
        this.bit2 = new long[n + 2];

        long totalAns = 0;
        long currentSumOfSquares = 0; 
        Map<Integer, Integer> lastSeen = new HashMap<>();

        for (int j = 0; j < n; j++) {
            // Find the 1-based bounds for our range update
            int prevIdx = lastSeen.getOrDefault(nums[j], -1);
            int L = prevIdx + 2; // +1 for next element, +1 for 1-based indexing
            int R = j + 1;       // +1 for 1-based indexing

            // 1. Get the current linear sum of the target range BEFORE the update
            long currentRangeSum = rangeQuery(L, R);

            // 2. Mathematically compute how much the total sum of squares will increase
            long length = R - L + 1;
            long deltaSq = (2 * currentRangeSum + length) % MOD;
            currentSumOfSquares = (currentSumOfSquares + deltaSq) % MOD;

            // 3. Perform the range update in our BIT to reflect the +1 increase
            rangeUpdate(L, R, 1);

            // 4. Add the newly updated sum of squares to our running total answer
            totalAns = (totalAns + currentSumOfSquares) % MOD;

            // Save the current position of the number
            lastSeen.put(nums[j], j);
        }

        return (int) totalAns;
    }
}
