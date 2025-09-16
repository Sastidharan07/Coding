//Question : https://leetcode.com/problems/replace-non-coprime-numbers-in-array/description/
class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Long> stack = new Stack<>();
        for(int v : nums) {
            long cur = v;
            while(!stack.isEmpty()) {
                long top = stack.peek();
                long g = gcd(top, cur);
                if(g == 1)
                    break;
                stack.pop();
                cur = lcm(top, cur);
            }
            stack.push(cur);
        }
        List<Integer> result = new ArrayList<>();
        for(long val : stack) {
            result.add((int) val);
        }
        return result;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b; 
    }
}
