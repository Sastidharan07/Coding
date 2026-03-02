//Question : https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/description/
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            boolean  a= false;
            for(int j=i;j<n;j++){
                int count = zero(grid[j]);
                if(count >= n-1-i){
                    a= true;
                    if(i==j) break;
                    for(int k=j;k>i;k--){
                        swap(grid[k],grid[k-1]);
                        ans++;
                    }
                    break;
                }   
            }
            if(a==false) return -1;
        }
        return ans;

    }
    public void swap(int[] arr,int[] arr1){
        for(int i=0;i<arr.length;i++){
            int temp = arr[i];
            arr[i] = arr1[i];
            arr1[i] = temp;
        }
    }
    public int zero(int[] arr){
        int cnt= 0;
        for(int j=arr.length-1;j>=0;j--){
                if(arr[j]==0){
                    cnt++;
                }
                else{
                    break;
                }
            }
            return cnt;
    }
}
