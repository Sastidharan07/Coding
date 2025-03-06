//Question:https://leetcode.com/problems/removing-stars-from-a-string/
class Solution {
    public String removeStars(String s) {
        int i=0;
        char[] arr=s.toCharArray();
        for(char c:arr){
            if(c=='*'){
                if(i>0){
                    i--;
                }
            }
            else{
                arr[i]=c;
                i++;
            }
        }
        return (new String(arr,0,i));
    }
}
