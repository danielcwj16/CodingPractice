/**
 *
 */

public class Solution {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num == 0)
            return "Zero";
        String[] str = {"","Thousand","Million","Billion","Trillion"};
        int i = 0;
        
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            int remain = num % 1000;
            num /= 1000;
            
            if(remain != 0)
            {
                String s = getWord(remain) + str[i];
                sb.insert(0,s).insert(0," ");
            }
              i++;         
        }
        return sb.toString().trim();
    }
    
    public String getWord(int num){
        
        if(num == 0)
            return "";
        else if(num < 20)
            return LESS_THAN_20[num] + " ";
        else if(num < 100)
            return TENS[num/10] + " " + getWord(num%10);
        else 
            return LESS_THAN_20[num/100] + " Hundred " + getWord(num%100);
    }
}