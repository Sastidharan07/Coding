//Question:https://leetcode.com/problems/find-missing-and-repeated-values/description/
class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        HashMap<Integer,Integer> container=new HashMap<>();
        int rep=-1,mis=-1;
        int size=grid.length*grid[0].length;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int num=grid[i][j];
                if(container.containsKey(num)){
                    container.put(num,container.get(num)+1);
                }
                else{
                    container.put(num,1);
                }
            }
        }
        for(int i=1;i<=size;i++){
            if(container.getOrDefault(i,0)==2){
                rep=i;
            }
            else if(!container.containsKey(i)){
                mis=i;
            }
        }
        return new int[]{rep,mis};
    }
}
