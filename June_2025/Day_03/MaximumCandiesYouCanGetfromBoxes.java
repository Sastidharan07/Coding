//Question : https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/description/
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Queue<Integer> hq = new ArrayDeque<>();
        for(int i = 0; i < initialBoxes.length; i++){
            hq.add(initialBoxes[i]);
        }

        int total = 0;
        while(!hq.isEmpty()){
            int rm = hq.remove();
            if(status[rm] == 0){
                if(hq.isEmpty()) return total;
                hq.add(rm);
            } else {
                total += candies[rm];
                for(int key : keys[rm]){
                    status[key] = 1;
                }
                for(int box : containedBoxes[rm]){
                    hq.add(box);
                }
            }
        }
        return total;
    }
}
