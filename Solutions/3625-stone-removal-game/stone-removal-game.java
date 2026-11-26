class Solution {
    public boolean canAliceWin(int n) {
        boolean win=false;
        int replace=10;
        while(replace<=n){
            n-=replace;
            win=!win;
            replace--;
        }
        return win;
    }
}