//Question : https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/description/
class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int l = firstPlayer - 1;
        int r = n - secondPlayer;
        if (l == r)
            return new int[] { 1, 1 };
        dfs(l, r, n, 1);
        return new int[] { min, max };
    }

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    public void dfs(int l, int r, int n, int stp) {
        if (l == r) {
            max = Math.max(stp, max);
            min = Math.min(stp, min);
            return;
        }
        if (l > r) {
            int temp = l;
            l = r;
            r = temp;
        }
        if (r >= n / 2) {
            int rem = n / 2;
            int c = n - l - r - 2;
            if (n % 2 == 1 && r == n / 2) {
                r--;
                rem--;
            } else {
                r -= 2;
                rem -= 2;
            }
            for (int i = 0; i <= l; i++) {
                for (int j = rem - i - c; j <= rem - i; j++) {
                    dfs(l - i, r - j, (n + 1) / 2, stp + 1);
                }
            }
        } else {
            for (int i = 0; i <= l; i++) {
                for (int j = 1; j <= r - l; j++) {
                    dfs(l - i, r - j - (l - i), (n + 1) / 2, stp + 1);
                }
            }
        }
    }
}
