//Question : https://leetcode.com/problems/three-consecutive-odds/description/
class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int c=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==1){
                c++;
            }
            if(arr[i]%2==0){
                c=0;
            }
            if(c==3){
                return true;
            }
        }
        return false;
    }
}
