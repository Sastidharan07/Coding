//Question : https://leetcode.com/problems/partition-labels/description/
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> arr=new ArrayList<>();
        Map<Character, Integer> lastOc = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOc.put(s.charAt(i), i);
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++){
            end=Math.max(end,lastOc.get(s.charAt(i)));
            if(i==end){
                arr.add(end-start+1);
                start=i+1;
            }
        }
        return arr;
    }
}
