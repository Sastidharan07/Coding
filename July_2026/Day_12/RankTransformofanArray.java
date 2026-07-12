//Question : https://leetcode.com/problems/rank-transform-of-an-array/
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted=arr.clone();
        int[] res=new int[arr.length];
        Arrays.sort(sorted);
        HashMap<Integer,Integer> ran=new HashMap<>();
        int rank=1;
        for(int i=0;i<arr.length;i++){
            if(!ran.containsKey(sorted[i])){
            ran.put(sorted[i],rank++);
            }
        }
        for(int i=0;i<arr.length;i++){
            res[i]=ran.get(arr[i]);
        }
        return res;
    }
}
