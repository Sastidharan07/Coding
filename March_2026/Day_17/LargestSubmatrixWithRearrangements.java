//Question : https://leetcode.com/problems/largest-submatrix-with-rearrangements/description/
import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Step 1: Build heights from bottom
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] += mat[i + 1][j];
                }
            }
        }

        int areaMax = 0;

        // Step 2 & 3: Sort rows and compute max area
        for (int i = 0; i < m; i++) {
            Arrays.sort(mat[i]);

            int width = 1;
            for (int j = n - 1; j >= 0; j--) {
                areaMax = Math.max(areaMax, mat[i][j] * width);
                width++;
            }
        }

        return areaMax;
    }
}