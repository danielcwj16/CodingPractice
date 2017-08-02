/**
 * Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") ? false
isMatch("aa","aa") ? true
isMatch("aaa","aa") ? false
isMatch("aa", "a*") ? true
isMatch("aa", ".*") ? true
isMatch("ab", ".*") ? true
isMatch("aab", "c*a*b") ? true
 */

import java.util.*;

public class RegularExpressionMatching{
    public boolean isMatch(String s, String p) {

    if (s == null || p == null) {
        return false;
    }
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i]) {
            dp[0][i+1] = true;
        }
    }
    for (int i = 1 ; i < s.length(); i++) {
        for (int j = 1; j < p.length(); j++) {
            if (p.charAt(j) == '.') {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == s.charAt(i)) {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                    dp[i+1][j+1] = dp[i+1][j-1];
                } else {
                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
    }
    return dp[s.length()][p.length()];
}
public boolean isMatch(String s, String p) {
        if(p.length()==0)
            return s.length() == 0;
        if(p.length()==1){
            if(s.length()<1){
                return false;
            }else if((s.charAt(0)!=p.charAt(0))&&(p.charAt(0) != '.')){
                return false;
            }else{
                return isMatch(s.substring(1),p.substring(1));
            }
        }
        
        if(p.charAt(1) != '*'){
            if(s.length()<1)
                return false;
            if((s.charAt(0)!=p.charAt(0))&&(p.charAt(0)!='.'))
                return false;
            else
                return isMatch(s.substring(1),p.substring(1));
        }else{
            //when '*' stands for zero preceding element;
            if(isMatch(s,p.substring(2)))
                return true;
            
                //when '*' stands for 1 or more preceding element, go through all possible number of *;
                int i =0;
                while(i<s.length()&&(s.charAt(i)==p.charAt(0)||p.charAt(0) == '.')){
                    if(isMatch(s.substring(i+1),p.substring(2)))
                        return true;
                    i++;
                }
                return false;
        }
    }
}