class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder string = new StringBuilder();
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (counter > 0) {
                    string.append(c);
                }
                counter++;
            } else {
                counter--;
                if (counter > 0) {
                    string.append(c);
                }
            }
        }
        return string.toString();
    }
}