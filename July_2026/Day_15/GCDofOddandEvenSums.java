//Question : https://leetcode.com/problems/gcd-of-odd-and-even-sums/description/
class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd=0;
        int even=0;
        for(int i=1;i<=n*2;i++){
            if(i%2==0){
                odd+=i;
            }
            else{
                even+=i;
            }
        }
        while(even!=0){
            int temp=even;
            even=odd%even;
            odd=temp;
        }
        return odd;
    }
}
