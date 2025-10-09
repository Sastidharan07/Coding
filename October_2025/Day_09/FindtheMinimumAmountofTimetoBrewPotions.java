//Question : https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/description/
class Solution {
    public long minTime(int[] skill, int[] mana) {
        long[] endTime = new long[skill.length];

        for(int i = 0; i < mana.length; ++i){
            long t = 0, maxDiff = 0;
            for(int j = 0; j < skill.length; ++j){
                maxDiff = Math.max(maxDiff, endTime[j] - t);
                t += (long)skill[j] * (long)mana[i];
                endTime[j] = t;
            }
            for(int j = 0; j < skill.length; ++j) endTime[j] += maxDiff;
        }
        return endTime[endTime.length-1];
    }
}
