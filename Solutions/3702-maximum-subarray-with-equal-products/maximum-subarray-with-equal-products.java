class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 2;
        for (int i = 0; i < n; i++) {
            long prod = 1;
            int gcd = 0;
            int lcm = 1;
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                if (prod > 25200) {
                    break;
                }
                gcd = (gcd == 0) ? nums[j] : getGcd(gcd, nums[j]);
                lcm = (lcm * nums[j]) / getGcd(lcm, nums[j]);
                if (prod == (long) lcm * gcd) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }
    private int getGcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}