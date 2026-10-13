class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n=garbage.length;
        int paper=0;
        int glass=0;
        int metal=0;
        int p_last=0;
        int g_last=0;
        int m_last=0;
        int ans=0;
        for(int i=0;i<n;i++){
            String house= garbage[i];
            for(int j=0;j<house.length();j++){
                if(house.charAt(j)=='P'){
                    paper++;
                    p_last=i;
                }
                if(house.charAt(j)=='G'){
                    glass++;
                    g_last=i;
                }
                if(house.charAt(j)=='M'){
                    metal++;
                    m_last=i;
                }
            }
        }
        for(int i=0;i<n-1;i++){
            if(i<p_last){
                ans+=travel[i];
            }
            if(i<g_last){
                ans+=travel[i];
            }
            if(i<m_last){
                ans+=travel[i];
            }
        }
        return ans+paper+glass+metal;
    }
}