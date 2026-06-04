//Question : https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/description/
class Solution {
    public int totalWaviness(int num1, int num2) {
        
        int count = 0;
        for(int i=num1;i<=num2;i++)
        {
            String s = String.valueOf(i);
            
            if(s.length()<3)
            {
                continue;
            }

            for(int k = 1; k<s.length()-1; k++)
            {
                char left = s.charAt(k-1);
                char mid = s.charAt(k);
                char right = s.charAt(k+1);

                if(mid > left && mid > right || mid < left && mid < right)
                {
                    count ++;
                }
            }
        }
        return count;
    }
}