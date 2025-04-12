//Question : https://leetcode.com/problems/find-the-count-of-good-integers/description/
class Solution {
    int [] arr;
    long rs;
    HashSet <String> set;
    public long countGoodIntegers(int n, int k) {
        if (n == 1){
            // brute force
            rs = 0;
            for (int i = 1; i < 10; ++i){
                if (i%k == 0){
                    rs++;
                }
            }
            return rs;
        }
        arr = new int[n];
        int rm = 1%k;
        for (int i = 0; i < n; ++i){
            arr[i] = rm;
            rm = (rm*10)%k;
        }
        rs = 0l;
        set = new HashSet<String>();
        rec(0, n, k, 0, new int[10]);
        return rs;
    }
    public void rec(int curr, int n, int k, int rm, int [] dg){
        if (curr > (n - 1)/2){
            if (rm > 0){
                return;
            }
            if (set.contains(get(dg))){
                return;
            }
            long tmp1 = fact(n);
            for (int i = 0; i < 10; ++i){
                if (dg[i] == 0){
                    continue;
                }
                tmp1 = tmp1/fact(dg[i]);
            }
            rs = rs + tmp1;
            if (dg[0] == 0){
                set.add(get(dg));
                return;
            }
            long tmp2 = fact(n - 1)/fact(dg[0] - 1);
            for (int i = 1; i < 10; ++i){
                if (dg[i] == 0){
                    continue;
                }
                tmp2 = tmp2/fact(dg[i]);
            }
            rs = rs - tmp2;
            set.add(get(dg));
            return;
        }
        for (int i = 0; i < 10; ++i){
            if (curr == 0 && i == 0){
                continue;
            }
            if (n%2 == 1 && curr == n/2){
                dg[i] = dg[i] + 1;
                rec(curr + 1, n, k, (rm + i*arr[curr])%k, dg);
                dg[i] = dg[i] - 1;
            }
            else{
                dg[i] = dg[i] + 2;
                rec(curr + 1, n, k, (rm + i*arr[curr] + i*arr[n - 1 - curr])%k, dg);
                dg[i] = dg[i] - 2;
            }
            
        }
    }
    public long fact(int n){
        if (n <= 1){
            return 1l;
        }
        long frs = 1l;
        for (int i = 2; i <= n; ++i){
            frs = frs*(0l + i);
        }
        return frs;
    }
    public String get(int [] arr){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; ++i){
            s.append("" + arr[i]);
        }
        return s.toString();
    }
}
