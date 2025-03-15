//Question : https://leetcode.com/problems/house-robber-iv/description/
class Solution {
    public static boolean f(int arr[],int val,int k){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=val){
                count++;
                i++;
            }
        }
        return count>=k;
    }
    public int minCapability(int[] arr, int k) {
        int n=arr.length;
        int low=arr[0];
        int high=arr[0];
        for(int i=1;i<arr.length;i++){
            low=Math.min(low,arr[i]);
            high=Math.max(high,arr[i]);
        }
        int ans=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(f(arr,mid,k)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}
