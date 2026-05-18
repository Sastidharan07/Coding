//Question : https://leetcode.com/problems/jump-game-iv/description/
class Solution {
    class Pair{
        int id;
        int steps;
        Pair(int id,int steps){
            this.id=id;
            this.steps=steps;
        }
    }
    public int minJumps(int[] arr) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                List<Integer> l=map.get(arr[i]);
                l.add(i);
                map.put(arr[i],l);
            }
            else{
                List<Integer> l=new ArrayList<>();
                l.add(i);
                map.put(arr[i],l);
            }
        }
        int min=Integer.MAX_VALUE;
        boolean[] vis=new boolean[arr.length];
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0));
        vis[0]=true;
        while(!q.isEmpty()){
            Pair p=q.remove();
            if(p.id==arr.length-1){
                return p.steps;
            }
            if(map.containsKey(arr[p.id])){
                List<Integer> list=map.get(arr[p.id]);
                List<Integer> l=new ArrayList<>(list);
                map.remove(arr[p.id]);
                for(int i:l){
                    if(i!=p.id && !vis[i]){
                        vis[i]=true;
                        q.add(new Pair(i,p.steps+1));
                    }
                }
            }
            if(p.id-1>=0 && !vis[p.id-1]){
                vis[p.id-1]=true;
                q.add(new Pair(p.id-1,p.steps+1));
            }
            if(p.id+1<arr.length && !vis[p.id+1]){
                vis[p.id+1]=true;
                q.add(new Pair(p.id+1,p.steps+1));
            }
        }
        return -1;
    }
}