import java.util.Arrays;
class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        int n=nums.length;
        long ans=0;
        long[] square=new long[n];
        for(int i=0;i<n;i++){
            square[i]=nums[i]*nums[i];
        }
        Arrays.sort(square);
        for(int i=0;i<n;i++){
            if(i<n/2){
                ans-=square[i];
            }
            else{
                ans+=square[i];
            }
        }
        return ans;
    }
}