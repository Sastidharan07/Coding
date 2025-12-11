//Question : https://leetcode.com/problems/count-covered-buildings/description/
class Solution {
    int MAX = 100001;
    public int countCoveredBuildings(int n, int[][] buildings) {
        // store column, row wise minX, minY, maxX, maxY
        HashMap<Integer,Integer> left = new HashMap<>(); // same y but minX (rowWise)
        HashMap<Integer,Integer> right = new HashMap<>(); // same y but maxX (rowWise) 
        HashMap<Integer,Integer> up = new HashMap<>(); // same x but maxY (columnWise)
        HashMap<Integer,Integer> down = new HashMap<>(); // same x but minY (columnWise)
        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];
            left.put(y, Math.min(left.getOrDefault(y, MAX), x));
            right.put(y, Math.max(right.getOrDefault(y, 0), x));
            up.put(x, Math.max(up.getOrDefault(x, 0), y));
            down.put(x, Math.min(down.getOrDefault(x, MAX), y));
        }
        int coveredBuildings = 0;
        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];
            if(x > left.get(y) && x < right.get(y) && y > down.get(x) && y < up.get(x)){
                coveredBuildings++;
            }
        }
        return coveredBuildings;        
    }
}
