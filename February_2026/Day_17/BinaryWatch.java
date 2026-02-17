//https://leetcode.com/problems/binary-watch/description/
class Solution {
    List<String> ans;
    public List<String> readBinaryWatch(int turnedOn) {
        ans   = new ArrayList<>();
        makerPoss(new StringBuilder("0000000000"), turnedOn, 0);
        return ans;
    }
    public void makerPoss(StringBuilder bits, int limit, int ind){
        if(limit == 0){
            String hr = bits.substring(0, 4);
            String mn = bits.substring(4);

            int hour = binaryToDec(hr);
            int min = binaryToDec(mn);
            if(hour > 11 || min > 59) return;

            StringBuilder temp = new StringBuilder();
            temp.append(hour).append(":");
            if(min < 10) temp.append("0");
            temp.append(min);
            ans.add(temp.toString());
            return;
        }

        for(int i = ind;i < 10;i++){
            bits.setCharAt(i, '1');
            makerPoss(bits, limit-1, i+1);
            bits.setCharAt(i, '0');
        }
    }
    public int binaryToDec(String s){
        int len = s.length();
        int res = 0;
        for(int i = len-1; i >= 0; i--){
            if(s.charAt(i) == '1'){
                res += (int) Math.pow(2, (len-(i+1)));
            }
        }

        return res;
    }
}
