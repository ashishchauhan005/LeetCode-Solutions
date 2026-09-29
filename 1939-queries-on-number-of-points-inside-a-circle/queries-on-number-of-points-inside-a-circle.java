class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans=new int[queries.length];
        int i=0;
        for(int[] q:queries){
            int qx=q[0],qy=q[1],qr=q[2];
            
            int count=0;

            for(int[] p:points){
                int px=p[0]-qx;
                int py=p[1]-qy;
                if(qr*qr>=((px*px) +(py*py))) count++;
            }
            ans[i++]=count;
        }
        return ans;
    }
}