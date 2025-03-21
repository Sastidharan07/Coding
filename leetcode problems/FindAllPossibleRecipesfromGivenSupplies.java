//Question : https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/
class Solution {

    private boolean check(String Curr_Recipe, List<List<String>> ingredients,HashMap<String,Integer> Recipe_Id,HashSet<String> available,HashSet<String> visited){
        if(available.contains(Curr_Recipe))return true;
        int id=Recipe_Id.get(Curr_Recipe);
        for(String cR:ingredients.get(id)){
            if(available.contains(cR))continue;
            if(!Recipe_Id.containsKey(cR) || visited.contains(cR))return false;
            visited.add(cR);
            if(check(cR,ingredients,Recipe_Id,available,visited))  available.add(cR);
            else{
                visited.remove(cR);
                return false;
            } 
        }
        return true;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,Integer> Recipe_Id=new HashMap<>();
        int i=0;
        for(String a:recipes){
            Recipe_Id.put(a,i);
            i++;
        }
        HashSet<String> available=new HashSet<>();
        List<String> list=new ArrayList<String>();
        for(String a:supplies)available.add(a);
        HashSet<String> visited=new HashSet<String>();
        for(String s:recipes){
            int re=Recipe_Id.get(s);
            if(check(recipes[re],ingredients,Recipe_Id, available,visited)){
                available.add(recipes[re]);
                list.add(recipes[re]);
            }
        }
        return list;
    }
}
