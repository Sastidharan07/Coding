//Question : https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/description/
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> ans = new PriorityQueue<>();

        int day = 1, n = events.length, i = 0, res = 0;

        while(i < n || !ans.isEmpty()){
            // if 0th index of ith event matches with day, then insert it into queue
            while(i < n && events[i][0] == day){
                ans.offer(events[i][1]);
                i++;
            }
            // event expired
            while(!ans.isEmpty() && ans.peek() < day){
                ans.poll();
            }
            if(!ans.isEmpty()){
                ans.poll();
                res++;
            }
            day++;
        }
        return res;
    }

}
