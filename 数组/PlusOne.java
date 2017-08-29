import java.util.*;

public class PlusOne{
    public int[] plusone(int[] digits){
        if(digits == null || digits.length==0)
            return digits;

        int c =1;

        for(int i = digits.length-1;i>=0;i--){
            int t = digits[i] + c;
             c = t/10;
             digits[i] = t%10;
        }

        if(c>0){
            int[] res = new int[digits.length+1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = c;
            return res;
        }else{
            return digits;
        }
    }
}