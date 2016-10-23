import java.util.Arrays;

//
public class ScrambleString_87 {
    public boolean isScramble(String s1, String s2) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!(new String(c1)).equals(new String(c2)))
            return false;
        if (s1.length() <= 1)
            return false;
        for (int i=1; i<s1.length(); i++){
            if ( (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i)))
                    || (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
                    && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)))
                    )
                return true;
        }
        return false;
    }
}