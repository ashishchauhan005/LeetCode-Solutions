class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max=nums[n-1];
        int ans=0;
        for(int num:nums){
            ans+=Math.abs(num-max);
        }
        return ans;
    }
}