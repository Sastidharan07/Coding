//Question : https://leetcode.com/problems/zero-array-transformation-iii/description/
class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n  =  nums.length , usedQ = 0 ;
        Arrays.sort(queries , (a ,b)->a[0]-b[0]);
        PriorityQueue<int[]> pool =  new PriorityQueue<>((a, b) ->  b[1]-a[1]); // max Heap
        PriorityQueue<int[]> used =  new PriorityQueue<>((a, b) ->  a[1] - b[1]); // min heap
        int qInd = 0 ;
        for(int i = 0 ; i < n ; i++){
            while(queries.length > qInd && queries[qInd][0] == i){
                pool.offer(queries[qInd]);
                qInd++;            
            }
            nums[i]-=used.size();
            while(nums[i] > 0  && !pool.isEmpty() && pool.peek()[1] >= i ){
                used.offer(pool.poll());
                nums[i]--;
                usedQ++;
            }
            if(nums[i] > 0 ) return -1;

            while(!used.isEmpty() && used.peek()[1] == i){
                used.poll();
            }
        } 
        return queries.length - usedQ;
    }
}
