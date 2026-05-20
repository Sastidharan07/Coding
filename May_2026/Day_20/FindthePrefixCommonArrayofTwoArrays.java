//Question : https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
int n=A.length;
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            list2.add(B[i]);
            list1.add(A[i]);
            if(A[i]==B[i]){
                if(i!=0)ans[i]=ans[i-1]+1;
                else ans[i]=1;
            }else{
                if(i==0)ans[i]=0;
                else{
                    int curAdd=0;
                    if(list1.contains(B[i]))curAdd++;
                    if(list2.contains(A[i]))curAdd++;
                    ans[i]=ans[i-1]+curAdd;
                }
            }
        }
        return ans;
    }
}