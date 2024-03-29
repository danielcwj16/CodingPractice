/**
用hashmap tracking 每一层的长度
 */
public class Solution {
    public int lengthLongestPath(String input) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int max = 0;
        map.put(0,0);
        
        for(String s : input.split("\n")){
            int level = s.lastIndexOf("\t")+1;
            int len = s.substring(level).length();
            
            if(s.contains(".")){
                max = Math.max(max,map.get(level)+len);
            }else{
                map.put(level+1,map.get(level)+len+1);
            }
        }
        return max;
    }
}