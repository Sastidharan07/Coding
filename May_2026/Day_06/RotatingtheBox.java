//Question : https://leetcode.com/problems/rotating-the-box/description/
class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;

        char[][] ans = new char[m][n];
        int hc = 0;

        for (int i = 0; i < n; i++) {
            int i1 = n - i - 1;

            for (int j = 0; j < m; j++) {
                ans[j][i1] = '.';

                if (boxGrid[i][j] == '#') {
                    hc++;
                } else if (boxGrid[i][j] == '*') {
                    ans[j][i1] = '*';
                    int pos = j - 1;

                    while (hc != 0) {
                        ans[pos][i1] = '#';
                        pos--;
                        hc--;
                    }
                }
            }

            int pos = m - 1;
            while (hc != 0) {
                ans[pos][i1] = '#';
                pos--;
                hc--;
            }
        }

        return ans;
    }
}