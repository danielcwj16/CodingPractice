/**
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.


{'0'," "},{'1',""},{'2',"abc"},{'3',"def"},{'4',"ghi"},{'5',"jkl"},{'6',"mno"},{'7',"pqrs"},{'8',"tuv"},{'9',"wxyz"}

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

/**
 * DFS方法，注意理清整个代码运行的流程以及递归过程
 */

public class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<String,String>() map = new HashMap<String,String>();
        
        map.put('0'," ");
        map.put('1',"");
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> res = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        helper(digits,map,res,sb,0);
        return res;
    }
    public void helper(String digits,HashMap<String,String>() map,List<String> res,StringBuilder sb,int i){
        if(i> digits.length()-1){
            if(sb.length()!=0)
            res.add(sb.toString());
            return;
        }
        String letters = map.get(digits.charAt(i));
        for(int j = 0;j<letters.length();j++){
            sb.append(letters.charAt(j));
            helper(digits,map,res,sb,i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}