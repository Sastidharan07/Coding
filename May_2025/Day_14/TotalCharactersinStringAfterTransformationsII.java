//Question : https://leetcode.com/problems/total-characters-in-string-after-transformations-ii/description/
class Solution {
    private static final int MOD = 1_000_000_007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[] count = new int[26]; 
        int[][] transition = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= nums.get(i); j++) {
                transition[i][(i + j) % 26]++;
            }
        }
        int[][] resultMatrix = matrixPower(transition, t);
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                count[i] = (count[i] + resultMatrix[i][j]) % MOD;
            }
        }
        long total = 0;
        for (char ch : s.toCharArray()) {
            total = (total + count[ch - 'a']) % MOD;
        }

        return (int) total;
    }
    private int[][] multiply(int[][] a, int[][] b) {
        int[][] res = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int k = 0; k < 26; k++) {
                for (int j = 0; j < 26; j++) {
                    res[i][j] = (int)((res[i][j] + 1L * a[i][k] * b[k][j]) % MOD);
                }
            }
        }
        return res;
    }
    private int[][] matrixPower(int[][] matrix, int power) {
        int[][] result = new int[26][26];
        for (int i = 0; i < 26; i++) {
            result[i][i] = 1;
        }

        while (power > 0) {
            if ((power & 1) == 1) {
                result = multiply(result, matrix);
            }
            matrix = multiply(matrix, matrix);
            power >>= 1;
        }

        return result;
    }
}
