//Question : https://leetcode.com/problems/apple-redistribution-into-boxes/description/
class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int sum=0;
        for(int i:apple){
            sum+=i;
        }
        int cap=0;
        int c=0;
        for(int i=capacity.length-1;i>=0;i--){
            cap+=capacity[i];
            c++;
            if(sum<=cap){
                return c;
            }
        }
        return c;
    }
}
