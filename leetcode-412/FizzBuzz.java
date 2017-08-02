public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        
        if(n==0)
            return res;
        for(int i = 1;i<=n;i++){
            if(!isFizz(i) && !isBuzz(i)){
                res.add(Integer.toString(i));
            }else if(isFizz(i)&&isBuzz(i)){
                res.add("FizzBuzz");
            }else if(isFizz(i)){
                res.add("Fizz");
            }else{
                res.add("Buzz");
            }
        }
        return res;
    }
    public boolean isFizz(int n){
        return n%3==0? true : false;
    }
    public boolean isBuzz(int n){
        return n%5==0? true : false;
    }
}