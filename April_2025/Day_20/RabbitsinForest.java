//Question : https://leetcode.com/problems/rabbits-in-forest/description/
class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }

        for (int answer : map.keySet()) {
            int count = map.get(answer);
            int groupSize = answer + 1;
            int groups = (count + answer) / groupSize;
            sum += groups * groupSize;
        }

        return sum;
    }
}
