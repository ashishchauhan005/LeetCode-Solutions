class Solution {
    public int minInsertions(String s) {
        int missingPieces = 0;
        int neededRightBrackets = 0;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(') {
                if (neededRightBrackets % 2 != 0) {
                    missingPieces++;      
                    neededRightBrackets--;
                }
                neededRightBrackets += 2; 
            } else {
                neededRightBrackets--;
                if (neededRightBrackets < 0) {
                    missingPieces++;         
                    neededRightBrackets += 2; 
                }
            }
        }
        return missingPieces + neededRightBrackets;
    }
}
