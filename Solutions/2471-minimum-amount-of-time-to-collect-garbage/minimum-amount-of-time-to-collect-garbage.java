class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n=garbage.length;
        for(int i=1;i<travel.length;i++){
            travel[i]=travel[i]+travel[i-1];
        }
        int p_last=0;
        int g_last=0;
        int m_last=0;
        int ans=0;
        for(int i=0;i<n;i++){
            String house= garbage[i];
            ans+=house.length();
            for(int j=0;j<house.length();j++){
                char c=house.charAt(j);
                if(c=='P') p_last=i;
                if(c=='G') g_last=i;
                if(c=='M') m_last=i;
            }
        }
        if(p_last>0)ans+=travel[p_last-1];
        if(g_last>0)ans+=travel[g_last-1];
        if(m_last>0)ans+=travel[m_last-1];
        return ans;
    }
}