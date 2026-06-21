//Question : https://leetcode.com/problems/maximum-ice-cream-bars/description/
class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int ans = 0;
        int[] cnt = new int[100000 + 1];
        int spend = 0;

        for (int cost : costs) {
            cnt[cost]++;
        }

        for (int i = 0; i < cnt.length; i++) {
            if (spend >= coins) {
                break;
            }

            if (cnt[i] == 0) continue;

            if (i * cnt[i] <= coins - spend) {
                spend += i * cnt[i];
                ans += cnt[i];
            } else {
                for (int j = 1; j <= cnt[i]; j++) {
                    if (spend + i > coins) {
                        break;
                    }
                    ans++;
                    spend += i;
                }
            }
        }

        return ans;
    }
}