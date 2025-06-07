//Question : https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description/
class Solution {
    public String clearStars(String s) {
        int len = s.length();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
        });
        boolean[] deleted = new boolean[len];
        for (int i = 0; i < len; i++) 
        {
            char c = s.charAt(i);
            if (c == '*') 
            {
                int[] top = pq.poll();
                deleted[-top[1]] = true;
            } 
            else
                pq.offer(new int[]{c, -i});
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) 
        {
            if (deleted[i] || s.charAt(i) == '*') 
                continue;
            res.append(s.charAt(i));
        }
        return res.toString();
    }
}
