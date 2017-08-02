public class Solution {
    public String reverseWords(String s) {
        StringBuilder word = new StringBuilder();
        StringBuilder res = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                if(word.length()!=0){
                    res.insert(0,word.toString()).insert(0,' ');
                    word.setLength(0);
                }else{
                    continue;
                }
            }else{
                word.append(s.charAt(i));
            }
        }
        res.insert(0,word.toString());
        if(res.length()>0 && res.charAt(0)==' ')
            res.deleteCharAt(0);
        return res.toString();
    }
}