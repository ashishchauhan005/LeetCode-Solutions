class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
    //     Sorting(nums,n);
    //     int n=nums.length;
    //     List<Integer> ans=new ArrayList<>();
    //     for(int i=0;i<n;i++){
    //         if(nums[i]==target) ans.add(i);
    //     }
    //     return ans;
        int n=nums.length;
        int smalls=0;
        int targets=0;
        for(int num:nums){
            if(num<target) smalls++;
            else if(num==target) targets++;
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<targets;i++){
            ans.add(smalls+i);
        }
        return ans;
    }
    // private void sorting(int[] nums,int n){
    //     int left=0;
    //     int right=n-1;

    // }
}