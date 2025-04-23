//Question : https://leetcode.com/problems/count-largest-group/description/
class Solution {
    public int countLargestGroup(int n) {
        int maxPossibleSum=9+9+9+9+1;
        int groups[]=new int[maxPossibleSum];
        
        int maxGroupSize=0;

        for (int i=1;i<=n;i++){
            int sum=0;
            int num=i;
            while (num>0){
                sum+=num%10;
                num/=10;
            }
            groups[sum]++;
            maxGroupSize=Math.max(maxGroupSize, groups[sum]);
        }

        int res=0;
        for (int i=0;i<maxPossibleSum;i++){
            if (groups[i]==maxGroupSize)res++;
        }
        return res;

    }
}
