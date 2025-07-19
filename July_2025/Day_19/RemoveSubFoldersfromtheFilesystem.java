//Question : https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
class Solution {
    public List<String> removeSubfolders(String[] folder) {
       int n=folder.length;
       Stack<String>s=new Stack<>();
       List<String>list=new ArrayList<>();
       Arrays.sort(folder);
       s.push(folder[0]);
       list.add(folder[0]);
       for(int i=1;i<n;i++){
           if(folder[i].startsWith(s.peek())&&folder[i].charAt(s.peek().length())=='/'){
            continue;
           }
           else{
            s.pop();
            s.push(folder[i]);
            list.add(folder[i]);
           }
       } 
       return list;
    }
 }
