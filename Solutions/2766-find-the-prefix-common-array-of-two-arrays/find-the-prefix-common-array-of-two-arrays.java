public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];
        int[] counts = new int[n + 1];
        int commonCount = 0;
        for (int i = 0; i < n; i++) {
            counts[A[i]]++;
            if (counts[A[i]] == 2) {
                commonCount++;
            }
            counts[B[i]]++;
            if (counts[B[i]] == 2) {
                commonCount++;
            }
            C[i] = commonCount;
        }
        return C;
    }
}
