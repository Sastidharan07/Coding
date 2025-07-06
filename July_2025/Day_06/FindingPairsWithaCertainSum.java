//Question : https://leetcode.com/problems/finding-pairs-with-a-certain-sum/description/
class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> freqMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freqMap = new HashMap<>();
        for (int num : nums2) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;
        nums2[index] = newVal;

        // Update frequency map
        freqMap.put(oldVal, freqMap.get(oldVal) - 1);
        if (freqMap.get(oldVal) == 0) {
            freqMap.remove(oldVal);
        }
        freqMap.put(newVal, freqMap.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int num : nums1) {
            int complement = tot - num;
            count += freqMap.getOrDefault(complement, 0);
        }
        return count;
    }
}
