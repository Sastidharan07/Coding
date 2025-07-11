//Question : https://leetcode.com/problems/meeting-rooms-iii/description/
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        long[] busy = new long[n];        
        
        int res = 0;
        int max = 0;

        Arrays.sort(meetings, (a, b) -> (a[0] - b[0]));

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0];
            int end = meetings[i][1];

            long earliest = Long.MAX_VALUE;
            int roomIndex = -1;
            boolean assigned = false;

            for (int j = 0; j < n; j++) {
                if (busy[j] < earliest) {
                    earliest = busy[j];
                    roomIndex = j;
                }

                if (busy[j] <= start) {
                    busy[j] = end;
                    count[j]++;
                    assigned = true;
                    break;
                }
            }

            if (!assigned) {
                busy[roomIndex] += (end - start);
                count[roomIndex]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (count[i] > max) {
                max = count[i];
                res = i;
            }
        }

        return res;
    }
}
