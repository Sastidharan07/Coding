// Question : https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/
class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[26];

        
        for (int i = 0; i < s.length(); i++) {
            dp[s.charAt(i) - 'a']++;
        }

    
        for (int r = 0; r < t; r++) {
            int[] nextDp = new int[26];

            for (int i = 0; i < 26; i++) {
                if (dp[i] == 0) continue;

                if (i == 25) { 
                    nextDp[0] = (int)((nextDp[0] + (long)dp[i]) % MOD);
                    nextDp[1] = (int)((nextDp[1] + (long)dp[i]) % MOD);
                } else { 
                    nextDp[i + 1] = (int)((nextDp[i + 1] + (long)dp[i]) % MOD);
                }
            }

            dp = nextDp;
        }

        
        long len = 0;
        for (int count : dp) {
            len = (len + count) % MOD;
        }

        return (int)len;
    }
}
