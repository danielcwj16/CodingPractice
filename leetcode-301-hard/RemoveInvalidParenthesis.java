/**
 * 
 * 用BFS， Visisted hashset记录已访问过的串，遍历串，一个个删除字符，将子串push到queue中
 */

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res= new ArrayList<String>();
        if(s == null)
            return res;
        
        Queue<String> q = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        
        q.offer(s);
        visited.add(s);
        boolean found = false;
        
        while(!q.isEmpty()){
            s = q.poll();
            
            if(isValid(s)){
                res.add(s);
                found = true;
            }
            
            if(found)continue;
            
            for(int i =0;i<s.length();i++){
                if(s.charAt(i)!='(' && s.charAt(i)!=')')
                    continue;
                
                String str = s.substring(0,i) + s.substring(i+1);
                if(!visited.contains(str)){
                    q.add(str);
                    visited.add(str);
                }
            }
        }
        return res;
    }
    
    public boolean isValid(String s){
        int count = 0;
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(')count++;
            if(c == ')' && count--==0)return false;
        }
        return count == 0;
    }
}