//Question : https://leetcode.com/problems/fraction-to-recurring-decimal/description/
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder sb = new StringBuilder();
        if( (numerator > 0 && denominator < 0) || ((numerator < 0 && denominator > 0)))
            sb.append("-");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num/den);
        num %= den;
        if(num == 0) {
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while(num != 0) {
            num *= 10;
            sb.append(num/den);
            num %= den;
            if(map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            } else {
                map.put(num, sb.length());
            }
        }
        return sb.toString();
    }
}
