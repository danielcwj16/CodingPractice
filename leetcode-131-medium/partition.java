/**
 * 用DFS加回溯
 * TIme: O(n2)
 * space ： O(n)
 */


import java.util.*;
class partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        List<String> path = new ArrayList<String>();
        helper(s,res,path,0);
        return res;
    }
    
    public void helper(String s, List<List<String>> res,List<String> path, int start){
        if(start == s.length())
        {
            res.add(new ArrayList<String>(path));
            return;
        }
        
        
        for(int i= start;i<s.length();i++){
            if(isValid(s,start,i)){
                path.add(s.substring(start,i+1));
                helper(s,res,path,i+1);
                path.remove(path.size()-1);
            }
        }
    }
    
    public boolean isValid(String s,int left,int right){
        
        while(left<=right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}