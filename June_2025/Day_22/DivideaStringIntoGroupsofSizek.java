//Question : https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/description/
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int totalGroups = (s.length() + k - 1) / k; // ceil(s.length()/k)
        String[] ans = new String[totalGroups];
        StringBuilder ns = new StringBuilder();
        int c = 0, m = 0;

        for (int i = 0; i < s.length(); i++) {
            ns.append(s.charAt(i));
            c++;

            if (c == k) {
                ans[m++] = ns.toString();
                ns.setLength(0); // reset StringBuilder
                c = 0;
            }
        }

        // handle the last incomplete group (if any)
        if (ns.length() > 0) {
            while (ns.length() < k) {
                ns.append(fill);
            }
            ans[m] = ns.toString();
        }

        return ans;
    }
}
