public class ValidPalindrome{
    public boolean isPalindome(String s){
        if(s == null)
            return false;
        if(s.equals(""))
            return true;
        int i=0;
        int j=s.length()-1;
        while(i<=j){
            char m = s.charAt(i);
            char n = s.charAt(j);
            if(!Character.isLetterOrDigit(m))
                i++;
            else if(!Character.isLetterOrDigit(n))
                j--;
            else{
                if(Character.toLowerCase(m) != Character.toLowerCase(n))
                    return false;
                i++;
                j--;
            }           
        }
        return true;
    }
}