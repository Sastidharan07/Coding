//Question : https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square/description/
import java.util.*;

class Solution {

    record Sequence(int startX, int startY, int endX, int endY, int length) {}

    public int maxDistance(int side, int[][] points, int k) {
        List<int[]> ordered = getOrderedPoints(side, points);

        int low = 0, high = side;

        while (low < high) {
            int mid = low + (high - low + 1) / 2;

            if (isValid(ordered, k, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean isValid(List<int[]> ordered, int k, int d) {
        Deque<Sequence> dq = new ArrayDeque<>();

        int[] first = ordered.get(0);
        dq.add(new Sequence(first[0], first[1], first[0], first[1], 1));

        int maxLen = 1;

        for (int i = 1; i < ordered.size(); i++) {
            int x = ordered.get(i)[0];
            int y = ordered.get(i)[1];

            int startX = x;
            int startY = y;
            int len = 1;

            while (!dq.isEmpty() &&
                    Math.abs(x - dq.peekFirst().endX()) +
                    Math.abs(y - dq.peekFirst().endY()) >= d) {

                Sequence curr = dq.pollFirst();

                if (Math.abs(x - curr.startX()) +
                    Math.abs(y - curr.startY()) >= d &&
                    curr.length() + 1 >= len) {

                    startX = curr.startX();
                    startY = curr.startY();
                    len = curr.length() + 1;
                    maxLen = Math.max(maxLen, len);
                }
            }

            dq.addLast(new Sequence(startX, startY, x, y, len));
        }

        return maxLen >= k;
    }

    private List<int[]> getOrderedPoints(int side, int[][] points) {
        List<int[]> left = new ArrayList<>();
        List<int[]> top = new ArrayList<>();
        List<int[]> right = new ArrayList<>();
        List<int[]> bottom = new ArrayList<>();

        for (int[] p : points) {
            int x = p[0];
            int y = p[1];

            if (x == 0 && y > 0) {
                left.add(p);
            } else if (x > 0 && y == side) {
                top.add(p);
            } else if (x == side && y < side) {
                right.add(p);
            } else {
                bottom.add(p);
            }
        }

        left.sort(Comparator.comparingInt(a -> a[1]));
        top.sort(Comparator.comparingInt(a -> a[0]));
        right.sort((a, b) -> b[1] - a[1]);
        bottom.sort((a, b) -> b[0] - a[0]);

        List<int[]> ordered = new ArrayList<>();
        ordered.addAll(left);
        ordered.addAll(top);
        ordered.addAll(right);
        ordered.addAll(bottom);

        return ordered;
    }
}