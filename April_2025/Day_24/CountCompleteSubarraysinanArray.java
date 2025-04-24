//Question : https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/
class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int val : nums){
            set.add(val);
        }

        int k = set.size();

        int i = 0;
        
        int j = 0;

        int ans = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        while(j < nums.length){

            map.put(nums[j],map.getOrDefault(nums[j],0)+1);

            while(map.size() == k){

                ans += (nums.length - j);

                map.put(nums[i],map.get(nums[i])-1);

                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }

        return ans;
    }
}
