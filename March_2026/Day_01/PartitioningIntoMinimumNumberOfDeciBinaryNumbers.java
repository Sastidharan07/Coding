//Question : https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/
class Solution {
    public int minPartitions(String n) {
        for (char d = '9'; d >= '1'; d--) {
            if (n.indexOf(d) != -1) {
                return d - '0';
            }
        }
        return 0;
    }
}