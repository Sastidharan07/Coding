//Question : https://leetcode.com/problems/put-marbles-in-bags/description/
class Solution {
    public long putMarbles(int[] weights, int k) {
        int[] pairs = new int[weights.length-1];
        for (int i = 0; i < weights.length-1; ++i) {
            pairs[i] = weights[i] + weights[i+1];
        }

        Arrays.sort(pairs);
        long minScore = 0l;
        long maxScore = 0l;
        for (int i = 0; i < k-1; ++i) {
            minScore += pairs[i];
        }
        for (int i = pairs.length - (k-1); i < pairs.length ; ++i) {
            maxScore += pairs[i];
        }
        return maxScore - minScore;
    }
}
