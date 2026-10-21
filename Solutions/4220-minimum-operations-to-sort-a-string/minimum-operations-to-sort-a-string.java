import java.util.Arrays;

public class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // Step 1: Get the target sorted version of the string
        char[] sortedArr = s.toCharArray();
        Arrays.sort(sortedArr);
        String sortedS = new String(sortedArr);
        
        // Case 0: Already sorted
        if (s.equals(sortedS)) {
            return 0;
        }
        
        // Case -1: Length 2 and unsorted is impossible to fix with proper substrings
        if (n == 2) {
            return -1;
        }
        
        // Target boundary characters
        char minChar = sortedArr[0];
        char maxChar = sortedArr[n - 1];
        
        // Case 1: Can sort in 1 operation if the first char is already min 
        // OR the last char is already max
        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }
        
        // Case 3: Requires 3 operations if:
        // 1. The first char is the max character AND the last char is the min character
        // 2. AND there are no duplicate min characters in the prefix, nor max characters in the suffix
        boolean hasMinInPrefix = false;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == minChar) {
                hasMinInPrefix = true;
                break;
            }
        }
        
        boolean hasMaxInSuffix = false;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == maxChar) {
                hasMaxInSuffix = true;
                break;
            }
        }
        
        if (!hasMinInPrefix && !hasMaxInSuffix) {
            return 3;
        }
        
        // Case 2: All remaining scenarios can be solved in 2 operations
        return 2;
    }
}
