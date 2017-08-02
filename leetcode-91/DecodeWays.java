/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
 */

/**
 * 本题只需要求方法的个数，用DP。 注意corner case   ，分两种情况，一位数字或者两位数字
 */

import java.util.*;
public class DecodeWays {
    public int numDecodings(String s) {
        if(s== null || s.equals(""))
            return 0;
        if(s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length()+1];
        dp[0]  =1;
        dp[1]  =1;
        for(int i=2;i<=s.length();i++){
            int tmp = Integer.parseInt(s.substring(i-1,i));
            if(tmp>=1&&tmp<=9){
                dp[i] = dp[i-1];
            }
            if(s.charAt(i-2)!='0'){
                tmp = Integer.parseInt(s.substring(i-2,i));
                if(tmp>=1&&tmp<=26){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length()];
    }
    
}