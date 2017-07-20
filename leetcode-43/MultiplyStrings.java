/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
/**
 * 本题运用了一点字符串相乘的规律，i和j位置的数字相乘，放在i+j， i+j+1的位置
 */
import java.util.*;
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = nums1.length();
        int n = nums2.length();
        int[] pos = new int[m+n];

        for(int i=m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                int mul = (nums1.charAt(i)-'0') * (nums2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = mul + pos[p2];
                pos[p1] += sum/10;
                pos[p2] = sum%10;

            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<pos.length;i++){
            if(!(sb.length()==0&&pos[i]==0))sb.append(pos[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}