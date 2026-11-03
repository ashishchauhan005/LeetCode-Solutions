class Solution {
    public int minMoves(int[] nums) {
        int max=0;
        for(int num:nums){
            if(num>max) max=num;
        }
        int ans=0;
        for(int num:nums){
            ans+=Math.abs(num-max);
        }
        return ans;
    }
}