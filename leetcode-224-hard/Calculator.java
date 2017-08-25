
/**
 * http://www.cnblogs.com/grandyang/p/4570699.html
 * 时间： O（n）
 * 空间： O（n）
 * 
 * 我们需要一个栈来辅助计算，用个变量sign来表示当前的符号，
 * 我们遍历给定的字符串s，如果遇到了数字，由于可能是个多位数，
 * 所以我们要用while循环把之后的数字都读进来，
 * 然后用sign*num来更新结果res；如果遇到了加号，则sign赋为1，如果遇到了符号，则赋为-1；
 * 如果遇到了左括号，则把当前结果res和符号sign压入栈，res重置为0，sign重置为1；
 * 如果遇到了右括号，结果res乘以栈顶的符号，栈顶元素出栈，结果res加上栈顶的数字，栈顶元素出栈
 */
import java.util.*;
public class Calculator {
    public static void main(String[] args) {
        Calculator ins = new Calculator();
        System.out.println(ins.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
    public int calculate(String s) {
        
        Stack<Integer> nums = new Stack<Integer>();

        int res = 0;
        int sign = 1;
        int n = s.length();

        for(int i=0;i<n;i++){
            char c = s.charAt(i);

            if(c >= '0'){
                int num = 0;
                while(i<n && s.charAt(i)>='0'){
                    num = num*10 + (s.charAt(i) - '0');
                    i++;
                }

                res += sign * num;
                i--;
            }
            else if(c == '+'){
                sign =1;
            }else if(c == '-'){
                sign = -1;
            }else if(c == '('){
                nums.push(res);
                nums.push(sign);
                res = 0;
                sign =1;
            }else if(c == ')'){
                res *= nums.peek();
                nums.pop();
                res += nums.peek();
                nums.pop();
            }
        }
        return res;
    }
}