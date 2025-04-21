//Question : https://leetcode.com/problems/count-the-hidden-sequences/description/
class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long smallest = 100001;
        long biggest = -100001;
        long start = 0;


        for( int num : differences){
            smallest = Math.min(start,smallest );
            biggest = Math.max(start,biggest );
            start += num ;
        }
        
        smallest = Math.min(start,smallest );
        biggest = Math.max(start,biggest );
             

        int count =  upper - lower  - (int)(biggest - smallest ) + 1;
        return Math.max(0, count);
    }
}
