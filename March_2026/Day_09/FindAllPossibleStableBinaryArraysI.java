//Question : https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i/description/
class Solution {
    static int mod = 1000000007;
    private static void rec(int one, int zero, List<Integer> temp, List<List<Integer>> ans) {
        if (one == 0 && zero == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (one > 0) {
            temp.add(1);
            rec(one - 1, zero, temp, ans);
            temp.remove(temp.size() - 1);
        }
        if (zero > 0) {
            temp.add(0);
            rec(one, zero - 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    private static boolean helper1(List<Integer> arr, int limit) {
        int count = 1;

    for(int i = 1; i<arr.size();i++) {
        if(arr.get(i).equals(arr.get(i - 1))) {
            count++;
        } 
        else{
            count=1;
        }
        if(count>limit) {
            return false;
        }
    }
    return true;
    }

    private static boolean helper(List<Integer> arr,int limit){
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=i;j<arr.size();j++){
                temp.add(arr.get(j));
                ans.add(new ArrayList<>(temp));
            }
        }
        for(List<Integer> temp:ans){
            if(!helper1(temp,limit)){
                return false;
            }
        }
        return true;
    }
    private static int rec1(int last,int ones,int zeros,int cons,int limit,Integer[][][][] dp){
        if(ones==0 && zeros==0){
            return 1;
        }
        
        if(dp[last][ones][zeros][cons]!=null) return dp[last][ones][zeros][cons];
        int tones=0;
        int tzeros=0;
        if(ones>0){
            if(last==1){   
                if(cons < limit) tones=rec1(1,ones-1,zeros,cons+1,limit,dp);
            }
            else{
                tones=rec1(1,ones-1,zeros,1,limit,dp);
            }
        }
        if(zeros>0){
            if(last==0){
                if(cons < limit) tzeros=rec1(0,ones,zeros-1,cons+1,limit,dp);
            }
            else{
                tzeros=rec1(0,ones,zeros-1,1,limit,dp);
            }
        }
        return dp[last][ones][zeros][cons]=(tones + tzeros) % mod;
    }
    public int numberOfStableArrays(int zero, int one, int limit) {
        // List<List<Integer>> ans = new ArrayList<>();
        // List<Integer> temp = new ArrayList<>();
        // int ans1=0;
        //bruteforce
        // rec(one,zero,temp,ans);
        // for(List<Integer> vb:ans){
        //     if(helper(vb,limit)){
        //         ans1++;
        //     }
        // }
        // return ans1%mod;

        Integer[][][][] dp=new Integer[2][one+1][zero+1][limit+1];
        int ans = 0;
        if(one>0) ans= (ans + rec1(1, one-1,zero, 1,limit, dp)) %mod;
        if(zero>0) ans =(ans +rec1(0, one, zero-1, 1,limit, dp)) % mod;
        return ans;
    }
}