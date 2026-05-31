//Question : https://leetcode.com/problems/destroying-asteroids/description/
import java.util.Arrays;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        long cur = mass;

        for (int a : asteroids) {
            if (cur < a) return false;
            cur += a;
        }

        return true;
    }
}