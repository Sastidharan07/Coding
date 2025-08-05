//Question : https://leetcode.com/problems/fruits-into-baskets-ii/description/
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] used = new boolean[baskets.length];
        int unplacedCount = 0;

        for (int i = 0; i < fruits.length; i++) {
            boolean placed = false;
            for (int j = 0; j < baskets.length; j++) {
                if (!used[j] && fruits[i] <= baskets[j]) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                unplacedCount++;
            }
        }
        return unplacedCount;
    }
}
