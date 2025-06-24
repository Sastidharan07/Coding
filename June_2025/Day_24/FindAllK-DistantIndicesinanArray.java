//Question : https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/description/
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        Set<Integer> reSet = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(nums[i] == key){
                int start = Math.max(0, i - k);
                int end = Math.min(n - 1, i + k);

                for(int j = start; j <= end; j++){
                    reSet.add(j);
                }
            }
        }

        List<Integer> res = new ArrayList<>(reSet);
        Collections.sort(res);
        return res;
    }
}
