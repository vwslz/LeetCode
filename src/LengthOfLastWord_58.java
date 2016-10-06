// O(n)
public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int res = 0;
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == ' ')
                break;
            else
                res++;
        }
        return res;
    }
}
