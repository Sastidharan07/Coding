//Question : https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/description/
class Solution
{
    public int longestPalindrome(String[] words)
    {
        int cnt=0;
        Map<String,Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for(String w : words)
        {
            String rev = new StringBuilder(w).reverse().toString();
            if(w.equals(rev))
            {
                if(set.contains(w))
                {
                    set.remove(w);
                    cnt+=4;
                }
                else
                {
                    set.add(w);
                }
            }
            else
            {
                cnt+=(map.getOrDefault(rev,0)>0)?4:0;
                map.put(w,map.getOrDefault(w,0)+1);
                map.put(rev,map.getOrDefault(rev,0)-1);
            }
        }
        return cnt+(set.isEmpty()?0:2);
    }
}
