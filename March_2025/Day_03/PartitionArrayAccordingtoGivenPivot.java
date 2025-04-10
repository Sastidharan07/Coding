//Question : https://leetcode.com/problems/partition-array-according-to-given-pivot/description/
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] s = new int[n];
        int[] e = new int[n];
        int[] mid = new int[n];

        int i = 0, j = 0, z = 0;
        
        // Categorize elements
        for (int x : nums) {
            if (x < pivot) {
                s[i++] = x;
            } else if (x == pivot) {
                mid[j++] = x;
            } else {
                e[z++] = x;
            }
        }
        
        int a = 0;
        // Combine smaller elements
        for (int b = 0; b < i; b++) {
            nums[a++] = s[b];
        }
        // Combine equal elements
        for (int b = 0; b < j; b++) {
            nums[a++] = mid[b];
        }
        // Combine greater elements
        for (int b = 0; b < z; b++) {
            nums[a++] = e[b];
        }

        return nums;
    }
}
