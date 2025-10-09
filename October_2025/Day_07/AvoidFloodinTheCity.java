//Question : https://leetcode.com/problems/avoid-flood-in-the-city/description/
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake == 0) {
                dryDays.add(i);
                ans[i] = 1; // placeholder; can dry any lake if unused
            } else {
                ans[i] = -1; // raining day
                if (lastRain.containsKey(lake)) {
                    int prev = lastRain.get(lake);
                    Integer dry = dryDays.higher(prev); // earliest dry day after prev
                    if (dry == null) return new int[0]; // flood unavoidable
                    ans[dry] = lake; // dry this lake on that dry day
                    dryDays.remove(dry);
                }
                lastRain.put(lake, i);
            }
        }
        return ans;
    }
}
