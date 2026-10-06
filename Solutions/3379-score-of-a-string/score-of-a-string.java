class Solution {
    public int scoreOfString(String s) {
        int ans=0;
        for(int c=0;c<s.length()-1;c++){
            ans+=Math.abs(s.charAt(c)-s.charAt(c+1));

        }
        return ans;
    }
}