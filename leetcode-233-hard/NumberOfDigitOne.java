/**
 * 统计每一位上1出现的次数
 * 求出1~n所有数中1出现的个数。

最一般的方法当然是一个一个数的去数。

还有一种方法就是数每一个数位上1出现的个数。

对于一个数 abcd

当 d > 1的时候 个位上出现1的个数为 (abc + 1)*1

当d = 1 的时候 个位上出现1的个数为 abc * 1 + 0 + 1， 0表示 d后面的数。对于11 来说，个位上出现1的数为 11,1

当d = 0的时候 个位上出现1的个数为 abc * 1

对于其它数位，相对的1变为10,100,1000..
 */

public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        long ans = 0,base = 1,last=0;
        while(n>0){
            int t = n%10;
            n /= 10;
            
            if(t>1)ans += (n+1)*base;
            else if(t == 1) ans += n*base + last+1;
            else{
                ans += n*base;
            }
            last = t*base+last;
            base *= 10;
        }
        return (int)ans;
    }
}