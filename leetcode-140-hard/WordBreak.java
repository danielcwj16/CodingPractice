/**
先参考word break 1题目，判断wordbreak是否存在，避免无用的查找。
再用DFS找到所有Path
更多解法： http://www.cnblogs.com/yuzhangcmu/p/4037299.html
*/
import java.util.*;

public class WordBreak {
    public boolean isWordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0)
                return true;
        boolean[] res = new boolean[s.length()+1];
        

        res[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j= 0;j<i;j++){
                if(res[j] && wordDict.contains(s.substring(j,i)))
                    {
                        res[i] = true;
                        break;
                    }
            }
        }
        return res[s.length()];    
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null || s.length() == 0 || wordDict.size() == 0)
            return new ArrayList<String>();
        
        List<String> res = new ArrayList<String>();
        if(isWordBreak(s,wordDict))
        {helper(0,s,wordDict,res,"");}
        return res;       
    }
    
    public void helper(int start,String s, List<String> wordDict,List<String> res,String str){
        if(start>= s.length())
        {
            res.add(str);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<s.length();i++){
            sb.append(s.charAt(i));
            if(!wordDict.contains(sb.toString()))
                continue;
            else{
                helper(i+1,s,wordDict,res,str.length()==0 ? sb.toString() : str+ " " +sb.toString());
            }
        }
        
        return;
    }
}