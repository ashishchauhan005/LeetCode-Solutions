
class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        int n=nums.size();
        // for (int i=0;i<n;i++){
        //     Set<Integer> set=new HashSet<>();
        //     for(int j=i;j<n;j++){
        //         set.add(nums.get(j));
        //         int Count=set.size();
        //         ans+=Count*Count;
        //     }
        // }
        for(int i=0;i<n;i++){
            boolean[] seen=new boolean[101];
            int unique=0;
            for(int j=i;j<n;j++){
                int num=nums.get(j);
                if(!seen[num]){
                    seen[num]=true;
                    unique++;
                }
                ans+=unique*unique;
            }
        }
        return ans;
    }
}
