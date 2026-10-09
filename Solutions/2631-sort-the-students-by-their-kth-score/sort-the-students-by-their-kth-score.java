class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, Comparator.comparingInt((int[] row)-> row[k]).reversed());
        return score;
    }
}