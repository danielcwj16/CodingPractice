/**
 * 找出所有的组合，首先想到DFS
 */

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num == null || num.equals(""))
            return res;
        StringBuilder sb = new StringBuilder();
        helper(res,"",num,0,0,target);
        return res;
    }
    
    public void helper(List<String> res,String sb,String num,long prenum,long total,int target){
        if(total == target && num.length()==0){
            res.add(new String(sb));
            return;
        }
        
        for(int i =1;i<=num.length();i++){
            String currStr = num.substring(0,i);
            if(currStr.length()>1 && currStr.charAt(0)=='0'){
                return;
            }
            long currNum = Long.parseLong(currStr);
            String next = num.substring(i);
            if(sb.length()!=0){
                helper(res,sb+"+"+currStr,next,currNum,total+currNum,target);
                helper(res,sb+"-"+currStr,next,-currNum,total-currNum,target);
                helper(res,sb+"*"+currStr,next,prenum*currNum,(total-prenum)+prenum*currNum,target);
            }else{
                helper(res,sb+currStr,next,currNum,currNum,target);
            }
        }
    }
}