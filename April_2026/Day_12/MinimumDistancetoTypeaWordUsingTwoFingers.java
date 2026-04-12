//Question : https://leetcode.com/problems/minimum-distance-to-type-a-word-using-two-fingers/description/
class Solution {

    // distance between two chars
    private int dist(char a, char b) {
        int x1 = (a - 'A') / 6, y1 = (a - 'A') % 6;
        int x2 = (b - 'A') / 6, y2 = (b - 'A') % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public int minimumDistance(String word) {
        int n = word.length();

        // dp[j] = max saving when second finger is at j
        int[] dp = new int[26];
        int total = 0;

        for (int i = 0; i < n - 1; i++) {
            char a = word.charAt(i);
            char b = word.charAt(i + 1);

            int d = dist(a, b);
            total += d;

            int[] newDp = new int[26];

            for (int j = 0; j < 26; j++) {
                // case1: don't use second finger
                newDp[j] = Math.max(newDp[j], dp[j]);

                // case2: use second finger
                int saving = dp[j] + d - dist((char)(j + 'A'), b);
                newDp[a - 'A'] = Math.max(newDp[a - 'A'], saving);
            }

            dp = newDp;
        }

        int maxSaving = 0;
        for (int val : dp) {
            maxSaving = Math.max(maxSaving, val);
        }

        return total - maxSaving;
    }
}