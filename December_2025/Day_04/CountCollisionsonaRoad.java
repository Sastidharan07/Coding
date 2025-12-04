//Question : https://leetcode.com/problems/count-collisions-on-a-road/description/
class Solution {
    public int countCollisions(String directions) {
        int collisions = 0; 
        int right = 0;
        boolean blocker = false;

        for (char c : directions.toCharArray()) {
            if (c == 'R') {
                right++;
                blocker = true;
            } else if (c == 'S') {
                collisions += right;
                right = 0;
                blocker = true;
            } else {
                if (blocker == true) {
                    collisions += right + 1;
                    right = 0;
                }
            }
        }

        return collisions;
    }
}
