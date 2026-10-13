class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        // int left=0;
        // for(int right=0;right<n;right++){
        //     if(left<n && nums[right]>0  ){
        //         int temp=nums[right];
        //         nums[right]=nums[left];
        //         nums[left]=temp; 
        //         left+=2;
        //         while(left<n && nums[left]>0 ){
        //             left+=2;
        //         }
        //     }
        // }
        // return nums;
        int[] ans=new int[n];
        int even=0;
        int odd=1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans[even]=nums[i];
                even+=2;
            }
            else{
                ans[odd]=nums[i];
                odd+=2;
            }
        }
        for(int i=0;i<n;i++){
            nums[i]=ans[i];
        }
        return nums;
    }
}