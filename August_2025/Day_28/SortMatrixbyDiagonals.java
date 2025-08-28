//Question : https://leetcode.com/problems/sort-matrix-by-diagonals/description/
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        //bottom left triangle
        for (int i=0; i<n; i++){
            int r = i, c = 0;
            int[] temp = new int[n-i];
            int j=0;
            while (r < n){
                temp[j++] = grid[r][c];
                r++;
                c++;
            }
            Arrays.sort(temp);
            j=temp.length-1;
            r = i; c = 0;
            while (r < n){
                grid[r][c] = temp[j--];
                r++;
                c++;
            }
        }
        //top right triangle
        for (int i=1; i<n; i++){
            int r = 0, c = i;
            int[] temp = new int[n-i];
            int j=0;
            while (c < n){
                temp[j++] = grid[r][c];
                r++;
                c++;
            }
            Arrays.sort(temp);
            j=0;
            r = 0; c = i;
            while (c < n){
                grid[r][c] = temp[j++];
                r++;
                c++;
            }
        }
        return grid;
    }
}
