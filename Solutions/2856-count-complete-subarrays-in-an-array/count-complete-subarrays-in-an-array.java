// class Solution {
//     public int countCompleteSubarrays(int[] nums) {
//         int n=nums.length;
//         int[] freq=new int[2001];
//         int count=0;
//         for(int i=0;i<n;i++){
//             if(freq[nums[i]]==0){
//                 count++
//                 freq[nums[i]]=1;
//             }
//         }
//         int left=0;
//         for(int right=0;right<n;right++){
            
//         }

//     }
// }
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[2001];
        int count = 0;
        for (int num : nums) {
            if (!seen[num]) {
                seen[num] = true;
                count++;
            }
        }
        int[] freq = new int[2001];
        int unique = 0;
        int ans = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if (freq[nums[right]] == 0) {
                unique++;
            }
            freq[nums[right]]++;
            while (unique==count) {
                ans += (n - right);
                freq[nums[left]]--;
                if (freq[nums[left]] == 0) {
                    unique--;
                }
                left++;
            }
        }
        return ans;
    }
}