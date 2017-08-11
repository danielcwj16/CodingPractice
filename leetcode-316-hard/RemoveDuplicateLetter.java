/**
 * 用Hashmap记录字符个数，用visited数组记访问记录
 * 
 * Time Complexity : worst case should be O(m*n) m is number of alphabetic letters
 * 
 * PS.还可以用递归的方法
 */

import java.util.*;

public class RemoveDuplicateLetter{
    public String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        boolean[] visited = new boolean[256];
        
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        
        StringBuilder res = new StringBuilder();
        res.append(0);
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.get(c)-1);
            if(visited[(int)c]) continue;
            
            while(c < res.charAt(res.length()-1) && map.get(res.charAt(res.length()-1))>0){
                visited[(int)res.charAt(res.length()-1)] = false;
                res.deleteCharAt(res.length()-1);
            }
            
            res.append(c);
            visited[(int)c] = true;
        }
        
        return res.toString().substring(1);
    }
}