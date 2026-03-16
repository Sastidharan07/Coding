//Question : https://leetcode.com/problems/get-biggest-three-rhombus-sums-in-a-grid/description/
class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Set<Integer> sums = new HashSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int d=0; d<26; d++){

                    if(i-d<0 || j-d<0 || i+d>=m || j+d>=n)
                        break;

                    int temp = 0;

                    if(d==0){
                        temp = grid[i][j];
                    } else {

                        temp = grid[i-d][j] + grid[i+d][j] + grid[i][j-d] + grid[i][j+d];

                        for(int t=1;t<d;t++){
                            temp += grid[i+t][j+d-t];
                            temp += grid[i+t][j-d+t];
                            temp += grid[i-t][j+d-t];
                            temp += grid[i-t][j-d+t];
                        }
                    }

                    sums.add(temp);
                }
            }
        }

        List<Integer> list = new ArrayList<>(sums);
        Collections.sort(list, Collections.reverseOrder());

        int k = Math.min(3, list.size());
        int[] ans = new int[k];

        for(int i=0;i<k;i++)
            ans[i] = list.get(i);

        return ans;
    }
}