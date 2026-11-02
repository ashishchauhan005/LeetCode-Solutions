class Solution{
    public int minMoves2(int[] nums){
        int n=nums.length;
        Arrays.sort(nums);
        int mid=nums[n/2];
        int ans=0;
        for(int i:nums){
            ans+=Math.abs(mid-i);
        }
        return ans;
    }
}