//Question : https://leetcode.com/problems/type-of-triangle/description/
class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "none";
        }
        if (a == b && b == c) {
            return "equilateral";
        } else if (a == b || b == c || a == c) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}
