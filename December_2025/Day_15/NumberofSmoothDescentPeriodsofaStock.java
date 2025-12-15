//Question : https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock/description/
class Solution {
    public long getDescentPeriods(int[] prices) {
        long ans = 1, count = 1;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] == prices[i - 1] - 1) count++;
            else count = 1;
            ans += count;
        }
        return ans;
    }
}