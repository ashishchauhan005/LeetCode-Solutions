class Solution {
    public int minMoves(int[] nums){
        int n=nums.length;
        int sum=0;
        int min=1000000000;
        for(int num:nums){
            sum+=num;
            if(num<min) min=num;
        }
        return sum-n*min;
    }
}