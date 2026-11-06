class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[][] indexedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            indexedQueries[i][0] = queries[i];
            indexedQueries[i][1] = i;
        }
        java.util.Arrays.sort(indexedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        java.util.Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        int[] ans = new int[m];
        int[] serverCount = new int[n + 1];
        int activeServers = 0;
        int logIdx = 0;
        int windowStart = 0;
        for (int i = 0; i < m; i++) {
            int qTime = indexedQueries[i][0];
            int qIdx = indexedQueries[i][1];
            int leftBound = qTime - x;
            while (logIdx < logs.length && logs[logIdx][1] <= qTime) {
                int serverId = logs[logIdx][0];
                if (serverCount[serverId] == 0) {
                    activeServers++;
                }
                serverCount[serverId]++;
                logIdx++;
            }
            while (windowStart < logIdx && logs[windowStart][1] < leftBound) {
                int serverId = logs[windowStart][0];
                serverCount[serverId]--;
                if (serverCount[serverId] == 0) {
                    activeServers--;
                }
                windowStart++;
            }
            ans[qIdx] = n - activeServers;
        }
        return ans;
    }
}