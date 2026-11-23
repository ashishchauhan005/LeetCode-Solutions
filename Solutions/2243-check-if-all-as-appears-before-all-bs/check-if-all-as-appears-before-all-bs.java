class Solution {
    public boolean checkString(String s) {
        boolean have=false;
        for(int i=1;i<s.length();i++){
            if(have) return false;
            if(s.charAt(i)=='a' && s.charAt(i-1)=='b') have=true;
        }
        return !have;
    }
}