//Question : https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/
class Solution {
    public int numberOfBeams(String[] bank) {
        int row = bank.length;
        int ans = 0;

    
        ArrayList<Integer> deviceCount = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            String curr = bank[i];
            int count = 0;
            for (int j = 0; j < curr.length(); j++) {
                if (curr.charAt(j) == '1') {
                    count++;
                }
            }
            if (count > 0) deviceCount.add(count);
        }

        for (int i = 0; i < deviceCount.size() - 1; i++) {
            ans += deviceCount.get(i) * deviceCount.get(i + 1);
        }

        return ans;
    }
}