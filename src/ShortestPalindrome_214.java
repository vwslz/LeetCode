public class ShortestPalindrome_214 {
    public String shortestPalindrome(String s) {
        char[] newString = new char[s.length() * 2 + 1];
        newString[s.length()] = '.';
        for (int i = 0; i < s.length(); i++)
        {
            newString[i] = s.charAt(i);
            newString[newString.length - 1 - i] = s.charAt(i);
        }

        int[] res = getRes(String.valueOf(newString));
        return new StringBuilder(s.substring(res[res.length - 1])).reverse().toString() + s;
    }

    public int[] getRes(String s){
        int[] res = new int[s.length()];
        int index = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(index) == s.charAt(i)){
                res[i] = res[i-1] + 1;
                index++;
            }else{
                index = res[i-1];
                while(index > 0 && s.charAt(index) != s.charAt(i))
                    index = res[index-1];

                if(s.charAt(index) == s.charAt(i))
                    index++;
                res[i] = index;
            }
        }
        return res;
    }
}