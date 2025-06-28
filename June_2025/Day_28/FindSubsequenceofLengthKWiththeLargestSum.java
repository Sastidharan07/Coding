//Question : https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/description/
class Pair{
    int num;
    int ind;
    public Pair(int num, int ind){
        this.num=num;
        this.ind=ind;
    }
}
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(new Pair(nums[i],i));
        }
        Collections.sort(list, (a,b) -> b.num-a.num);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.ind - b.ind);
        for(int i=0;i<k;i++) pq.add(list.get(i));
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll().num;
        }
    return ans;
    }
}
