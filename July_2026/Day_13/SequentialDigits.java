//Question : https://leetcode.com/problems/sequential-digits/
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int start = 1; start <= 9; start++) {
            int num = 0;
            for (int next = start; next <= 9; next++) {
                num = num * 10 + next;
                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
