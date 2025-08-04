//Question : https://leetcode.com/problems/fruit-into-baskets/description/
class Solution {
    public int totalFruit(int[] arr) {
        int ans = 0;
        int s = 0;
        int e = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        while(e<arr.length){
            int k = map.getOrDefault(arr[e],0);
            if(k==0) count++;
            map.put(arr[e],k+1);
            if(count>2){
                while(count>2 && s<=e){
                   int k1 = map.getOrDefault(arr[s],0);
                   if(k1==1){
                    count--;
                    map.remove(arr[s]);
                   }
                   else{
                   map.put(arr[s],k1-1);
                   }
                   s++;
                }
            }
            ans = Math.max(ans,e-s+1);
            e++;
        }
        return ans;
    }
}
