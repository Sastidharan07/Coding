//Question : https://leetcode.com/problems/sum-of-distances/description/

class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, Integer> numMapIndex = new HashMap<>();
        HashMap<Integer, Integer> numMapCounter = new HashMap<>();

        long[] resultFront = new long[nums.length];
        long[] resultBack = new long[nums.length];
        long[] result = new long[nums.length];

        // Left -> Right
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numMapIndex.containsKey(num)) {
                long count = numMapCounter.get(num);
                long index = numMapIndex.get(num);
                resultFront[i] = resultFront[(int) index] + count * (i - index);
            } else {
                resultFront[i] = 0;
            }
            numMapIndex.put(num, i);
            numMapCounter.put(num, numMapCounter.getOrDefault(num, 0) + 1);
        }

        // Reset maps for Right -> Left
        numMapIndex.clear();
        numMapCounter.clear();

        // Right -> Left
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (numMapIndex.containsKey(num)) {
                long count = numMapCounter.get(num);
                long index = numMapIndex.get(num);
                resultBack[i] = resultBack[(int) index] + count * (index - i);
            } else {
                resultBack[i] = 0;
            }
            numMapIndex.put(num, i);
            numMapCounter.put(num, numMapCounter.getOrDefault(num, 0) + 1);
        }

        // Combine
        for (int i = 0; i < nums.length; i++) {
            result[i] = resultFront[i] + resultBack[i];
        }
        return result;
    }
}