//Question : https://leetcode.com/problems/sum-of-k-mirror-numbers/description/
class Solution {
 int parkDigit[] = new int[100];
 boolean isPalindrom(long x, int k)
 {
          int j = -1;
        while (x > 0) {
            ++j;
            parkDigit[j] = (int) (x % k);
            x /= k;
        }
        int i = 0; 
        while(i<j) {
            if (parkDigit[i] != parkDigit[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
 }

    public long kMirror(int k, int n) {
    int start = 1; 
    int count = 0;
    long ans = 0; 
    while(count<n)
    {
      for(int op=0; op<2; op++) 
      { 
      for(int i=start; i<start*10 && count<n; i++)
      {
         long combined = i;

            int x = op==0 ? i/10 : i;
            while(x>0)
            {
             combined = combined*10 + x%10;
             x /=10;   
            }
           if(isPalindrom(combined, k))
           {
            count++;
            ans += combined;
           } 
      }
      }
      start = start*10;   
    }    

     return ans;
    }
}
