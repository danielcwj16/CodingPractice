public class Solution {
    private int lo=0;
    private int maxLen = 0;
    public String longestPalindrome(String s) {
        String longest = "";
        if(s == null || s.equals(""))
            return longest;
        for(int i = 0;i<s.length();i++){
            findPalindrome(s,i,i);
            findPalindrome(s,i,i+1);            
        }
        
        return s.substring(lo,lo+maxLen);
    }
    
    private void findPalindrome(String s, int j,int k){
        while(j>=0 && k<s.length()){
                if(s.charAt(j) == s.charAt(k)){
                    j--;
                    k++;
                    continue;
                }else{
                    break;
                }
            }
        if(maxLen<(k-j-1)){
            lo = j+1;
             maxLen = k-j-1;
                    }
    }
}