// class Solution {
//     public int minMoves(int[] nums) {
//         int max=0;
//         int sum=0;
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             if(nums[i]>max){
//                 max=nums[i];
//             }
//             sum+=nums[i];
            
//         }
//         return max*n-sum;
//     }
// }
class Solution {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(nums[i]>max){
                max=nums[i];
            }
        }
        return max*nums.length-sum;
       
    }
}