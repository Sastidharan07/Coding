//Question : https://leetcode.com/problems/lexicographical-numbers/description/
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (i <= n) {
                ans.add(i);
                lexi(i, n, ans);
            }
        }
        return ans;
    }

    public static void lexi(int num, int n, List<Integer> ans) {
        if (num == n || num > n) {
            return;
        }
        for (int i = 0; i <= 9; i++) {

            if (num * 10 + i <= n) {
                ans.add(num * 10 + i);

                lexi(num * 10 + i, n, ans);
            }
        }
    }
}
