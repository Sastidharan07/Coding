//Question : https://leetcode.com/problems/finding-3-digit-even-numbers/description/
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<digits.length;i++)
        {
            for(int j=0;j<digits.length;j++)
            {
                for(int k=0;k<digits.length;k++)
                {
                    int num=0;
                    if(i!=j && j!=k && k!=i) num=digits[i]*100+digits[j]*10+digits[k];
                    if(num>=100 && num%2==0) set.add(num);
                }
            }
        }
        int[] res=new int[set.size()];
        int i=0;
        for(int num:set)
        {
            res[i++]=num;
        }
        Arrays.sort(res);
        return res;
    }
}
