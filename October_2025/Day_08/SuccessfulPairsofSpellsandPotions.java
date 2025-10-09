//Question : https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long suc) {
        int n = spells.length;
        int m = potions.length;
        ArrayList<Integer> li = new ArrayList<>();
        Arrays.sort(potions);
        for(int num:spells){
            int ans = bs(num,potions,suc);
            li.add(ans);
        }
        int l = li.size();
        int arr[] = new int[l];
        for(int i=0;i<l;i++){
            arr[i] = li.get(i);
        }
        return arr;
    }
    int bs(int num,int arr[], long k)
    {
        int l=0;
        int r=arr.length-1;
        int ind = -1;
        while(l<=r)
        {
            int mid = (l+r)/2;
            if((long)arr[mid]*num >= k)
            {
                ind = mid;    //low bound
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ind==-1 ? 0 : arr.length-ind;
    }
}
