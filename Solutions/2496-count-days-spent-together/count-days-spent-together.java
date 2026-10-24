class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int startAlice = dateToDayOfYear(arriveAlice, daysInMonths);
        int endAlice = dateToDayOfYear(leaveAlice, daysInMonths);
        int startBob = dateToDayOfYear(arriveBob, daysInMonths);
        int endBob = dateToDayOfYear(leaveBob, daysInMonths);
        int startOverlap = Math.max(startAlice, startBob);
        int endOverlap = Math.min(endAlice, endBob);
        return Math.max(0, endOverlap - startOverlap + 1);
    }
    private int dateToDayOfYear(String dateStr, int[] daysInMonths) {
        int month = Integer.parseInt(dateStr.substring(0, 2));
        int day = Integer.parseInt(dateStr.substring(3, 5));
        int dayCount = 0;
        for (int i = 0; i < month - 1; i++) {
            dayCount += daysInMonths[i];
        }
        return dayCount + day;
    }
}
