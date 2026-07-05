//Question : https://leetcode.com/problems/number-of-paths-with-max-score/description/
class Solution {
    long mod = 1_000_000_007; 
    public int[] pathsWithMaxScore(List<String> board) {
        // DP 
        int m = board.size(); 

        long[] path = new long[m + 1]; // defautl value = 0 
        long[] pathSum = new long[m + 1]; 

        // base case 
        for(int i = m - 1; i >= 0; i--) {
            char c = board.get(m - 1).charAt(i); 
            if(c == 'X') {
                break; 
            }

            if(c == 'S') {
                path[i] = 1L; 
                continue; 
            }

            path[i] = 1L; 
            pathSum[i] = (pathSum[i + 1] + (c - '0')); 
        }

        // traverse our board 
        for(int i = m - 2; i >= 0; i--) {
            long[] curPath = new long[m + 1]; 
            long[] curPathSum = new long[m + 1]; 

            for(int j = m - 1; j>= 0; j--) {
                char c = board.get(i).charAt(j); 
                if(c == 'X') continue; // no update to cur 
                
                if(c != 'E') {
                    curPathSum[j] = (c - '0'); 
                }

                // bottom, bottom - right, right 
                long maxPathSum = Math.max(pathSum[j], Math.max(curPathSum[j + 1], pathSum[j + 1])); 
                curPathSum[j] = (curPathSum[j] + maxPathSum) % mod; 
                // bottom 
                if(pathSum[j] == maxPathSum) {
                    curPath[j] = (curPath[j] + path[j]) % mod; 
                }

                // bottom-right 
                if(pathSum[j + 1] == maxPathSum) {
                    curPath[j] = (curPath[j] + path[j + 1]) % mod; 
                }

                // rigth 
                if(curPathSum[j + 1] == maxPathSum) {
                    curPath[j] = (curPath[j] + curPath[j + 1]) % mod; 
                }
            }
            path = curPath; 
            pathSum = curPathSum; 
        }

        // if the path[0] = 
        if(path[0] == 0) pathSum[0] = 0; 
        return new int[] {(int)pathSum[0], (int)path[0]}; 
    }
}