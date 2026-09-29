class Solution {
    public int numberOfBeams(String[] bank) {
        int n=bank.length;
        int prev_count=0;
        
        int ans=0;
        for(int i=0;i<n;i++){
            String s=bank[i];
            int curr_count=0;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='1') curr_count++;
            }
            ans+=(curr_count*prev_count);
            if(curr_count!=0){
                prev_count=curr_count;
            }
        }
        return ans;
    }
}