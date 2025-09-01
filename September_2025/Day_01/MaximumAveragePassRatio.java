//Question : https://leetcode.com/problems/maximum-average-pass-ratio/solutions/7143152/optimised-beginner-friendly-explanation-greedy-priority-queue/
class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(gain(b[0], b[1]), gain(a[0], a[1]))
        );

        for (int[] c : classes) {
            pq.add(new int[]{c[0], c[1]});
        }

        while (extraStudents-- > 0) {
            int[] top = pq.poll();
            top[0]++;
            top[1]++;
            pq.add(top);
        }

        double sum = 0.0;
        for (int[] c : pq) {
            sum += (double)c[0] / c[1];
        }

        return sum / classes.length;
    }

    private double gain(int pass, int total) {
        return (double)(pass + 1) / (total + 1) - (double)pass / total;
    }
}
