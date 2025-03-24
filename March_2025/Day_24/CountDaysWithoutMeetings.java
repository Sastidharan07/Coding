//Question : https://leetcode.com/problems/count-days-without-meetings/description/
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return Integer.compare(a1[0], a2[0]);
            }
        });

        int prev = 0;
        int curr = 1;

        while (prev < meetings.length && curr < meetings.length) {
            if (meetings[prev][1] >= meetings[curr][0]) {
                meetings[prev][1] = Math.max(meetings[curr][1], meetings[prev][1]);
                curr++;
            } else {
                prev++;
                meetings[prev][0] = meetings[curr][0];
                meetings[prev][1] = meetings[curr][1];
                curr++;
            }
        }

        int diff = 0;

        for (int i = 0; i <= prev; i++) {

            diff += meetings[i][1] - meetings[i][0] + 1;
        }

        return days - diff;
    }
}
