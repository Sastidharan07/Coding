//Question : https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/description/
class Solution {
    public boolean inc(List<Integer> list){
        for(int i=1; i<list.size(); i++){
            if(list.get(i)<=list.get(i-1)) return false;
        }
        return true;
    }
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n= nums.size();
        for(int i=0; i<=n-2*k; i++){
            int a= i, b= i+k;
            List<Integer> list1= new ArrayList<>();
            List<Integer> list2= new ArrayList<>();
            for(int j= a; j<a+k; j++){
                list1.add(nums.get(j));
            }
            for(int j= b; j<b+k; j++){
                list2.add(nums.get(j));
            }
            if(inc(list1) && inc(list2)) return true;
        }
        return false;
    }
}