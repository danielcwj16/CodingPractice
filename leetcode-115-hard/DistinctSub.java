public class DistinctSub {
    public int numDistinct(String s, String t) {
        if(s == null || t == null || s.length() < t.length())
            return 0;
        //this array represent how many subsequence with length of i in string with length of j
        int[][] dp = new int[t.length()+1][s.length()+1];
        
        //when i is 0, subsequence is empty string, the dp[0][j] are all 1;
        for(int j = 0;j < dp[0].length;j++){
            dp[0][j] = 1;
        }
        
        //when j is 0, there is no subsequence, dp[i][j] are all 0;
        for(int i = 1;i<dp.length;i++){
            dp[i][0] = 0;
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=i;j<dp[0].length;j++){
                //if character t.charAt(i) not equal to s.charAt(j), number of sequence will be the same with previous one
                //if t.charAt(i) == s.charAt(j), number if sequence will be the sum and previous dp[i][j-1] and dp[i-1][j-1] 
                if(t.charAt(i-1)!=s.charAt(j-1)){
                    dp[i][j] = dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }
            }
        }
        
        return dp[t.length()][s.length()];
    }
}