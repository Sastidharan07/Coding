//Question : https://leetcode.com/problems/count-and-say/description/
class Solution {
    public String countAndSay(int n) {
       String res = "1";
        for(int i=1;i<n;i++){
            res = rle(res);
        }
        return res;
    }

    private String rle(String str){
        StringBuilder sb = new StringBuilder();
        int i=0;

        while(i<str.length()){
            char ch = str.charAt(i);
            int count =0;

            while(i<str.length() && str.charAt(i)==ch){
                i++;
                count++;
            }

            sb.append(count);
            sb.append(ch);
        }
        return sb.toString();
    }
}
