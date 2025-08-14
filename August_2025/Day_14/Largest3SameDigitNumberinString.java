//Question : https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/
class Solution {
    public String largestGoodInteger(String num) {
        String[] temp= {"000" , "111" , "222" , "333" , "444" , "555",
                       "666" , "777" , "888" , "999"
        };
        for(int i=temp.length-1 ; i>=0 ; i--){
            if(num.contains(temp[i])){
                return temp[i];
            }
        }
        return "";
    }
}
