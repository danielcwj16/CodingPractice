/**
 * Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
import java.util.*;
public class AddBinary {
    public String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int n = a.length() < b.length() ? b.length() : a.length();
        for (int i = 0; i < n; i++) {
            int p = 0;
            int q = 0;
            if (i < a.length()) {
                p = a.charAt(a.length() - 1 - i) - '0';
            } else {
                p = 0;
            }
            if (i < b.length()) {
                q = b.charAt(b.length() - 1 - i) - '0';
            } else {
                q = 0;
            }
            int temp = p + q + carry;
            carry = temp / 2;
            sb.insert(0, temp % 2);
        }
        if (carry == 1)
            sb.insert(0, 1);
        return sb.toString();
    }
}