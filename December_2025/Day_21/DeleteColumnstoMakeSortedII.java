//Question : https://leetcode.com/problems/delete-columns-to-make-sorted-ii/description/
class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        boolean[] fixed = new boolean[n];
        int fixedCount=1;
        fixed[0] = true;
        int del = 0;
        for(int col=0;col<strs[0].length();col++) {
            boolean colDeleted = false;
            for(int i=1;i<n;i++) {
                if(fixed[i]) continue;

                if(strs[i].charAt(col) < strs[i-1].charAt(col)) {
                    colDeleted = true;
                    del++;
                    break;
                }
            }
            if(!colDeleted) {
                for(int i=1;i<n;i++) {
                    if(!fixed[i] && strs[i].charAt(col) > strs[i-1].charAt(col)) {
                        fixed[i] = true;
                        fixedCount++;
                    }
                }
            }
            if(fixedCount == n)
                break;
        }
        return del;
    }
}