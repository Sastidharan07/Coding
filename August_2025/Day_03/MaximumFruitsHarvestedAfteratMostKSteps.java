//Question : https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/description/
class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int ans=0;
        int sum=0;
        int left=0;
        for(int right=0;right<fruits.length;right++){
            sum+=fruits[right][1];
            while(left<=right && steps(fruits[left][0],fruits[right][0],startPos)>k){
                sum-=fruits[left][1];
                left++;
            }
            ans=Math.max(ans,sum);
        }
        return ans;
    }
    public int steps(int left,int right,int start){
        int goLeft=Math.abs(start-left)+(right-left);
        int goRight=Math.abs(start-right)+(right-left);
        return Math.min(goLeft,goRight);
    }
}
