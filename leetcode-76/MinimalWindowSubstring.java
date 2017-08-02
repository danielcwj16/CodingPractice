/**
 * 双指针寻找window，右指针keep往右遍历，当找到count等于t的长度时，左指针往右找到第一个出现在属于t的字符
 */

public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null || s.equals("") || t.equals(""))
            return "";
        int count =0;
        int start = 0;
        String res = "";
        int minLen = s.length()+1;
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(int i = 0;i<t.length();i++){
            if(map.containsKey(t.charAt(i))){
                map.put(t.charAt(i),map.get(t.charAt(i))+1);
            }else{
                map.put(t.charAt(i),1);
            }
        }
        
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))>=0)
                    count++;
                
                while(count == t.length()){
                    if(map.containsKey(s.charAt(start))){
                        map.put(s.charAt(start),map.get(s.charAt(start))+1);
                        if(map.get(s.charAt(start))>0){
                            if(minLen>(i-start+1)){
                                res = s.substring(start,i+1);
                                minLen = i-start+1;
                            }
                            count--;
                        }
                    }
                    start++;
                }
            }
        }
        return res;
    }
}