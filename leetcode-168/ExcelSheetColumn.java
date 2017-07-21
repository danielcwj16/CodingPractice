/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
 */
/**
 * 进制转换的问题，注意此题不是从0开始，而是1，所以n需要减1
 */
public class ExcelSheetColumn {
    public String convertToTitle(int n) {
        if (n == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int r = n % 26;
            n /= 26;
            if (r == 0) {
                sb.insert(0, 'Z');
                n--;
            } else {
                sb.insert(0, (char) ('A' + r - 1));
            }
        }
        return sb.toString();
    }
}