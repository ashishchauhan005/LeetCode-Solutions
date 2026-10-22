class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0;
        }

        int drops = 0;
        int ascents = 0;
        int idx0 = -1;

        // Single loop to find drops, ascents, and the position of 0
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                idx0 = i;
            }
            
            int nextIdx = (i + 1) % n;
            if (nums[i] > nums[nextIdx]) {
                drops++;
            }
            if (nums[i] < nums[nextIdx]) {
                ascents++;
            }
        }

        boolean isInc = (drops <= 1);
        boolean isDec = (ascents <= 1);

        // If it fits neither cyclic pattern, sorting is impossible
        if (!isInc && !isDec) {
            return -1;
            
        }

        int minOps = Integer.MAX_VALUE;

        // Case 1: Increasing cyclic shift
        if (isInc) {
            int pathA = idx0;
            int pathB = 2 + (n - idx0) % n;
            minOps = Math.min(minOps, Math.min(pathA, pathB));
        }

        // Case 2: Decreasing cyclic shift
        if (isDec) {
            int pathA = ((idx0 + 1) % n) + 1;
            int pathB = n - idx0;
            minOps = Math.min(minOps, Math.min(pathA, pathB));
        }

        return minOps;
    }
}
