class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n=nums.length;
        int[] freq=new int[201];
        int max_freq=0;
        for(int i:nums){
            freq[i]++;
            if(freq[i]>max_freq){
                max_freq=freq[i];
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int j=0;j<max_freq;j++){
            List<Integer> l=new ArrayList<>();
            for(int k=1;k<201;k++){
                
                if(freq[k]>0){
                    l.add(k);
                    freq[k]--;
                }
            }
            list.add(l);
        }
        return list;
    }
}