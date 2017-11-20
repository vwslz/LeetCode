import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> iter = new ArrayList<String>();
        char[] chars = s.toCharArray();
        if (s == null || s.length() == 0)
            return res;

        partitionHelper(chars, 0, s.length(), res, iter);
        return res;
    }

    public void partitionHelper(char[] chars, int left, int right, List<List<String>> res, List<String> iter) {

        if (isPalindrome(chars, left, right))
        {
            iter.add(new String(chars, left, right - left));
            List add = new ArrayList(iter);
            res.add(add);

            iter.remove(iter.size() - 1);
        }

        for (int i = left; i < right; i++)
        {

            if (isPalindrome(chars, left, i))
            {
                iter.add(new String(chars, left, i - left));
                partitionHelper(chars, i, right, res, iter);
                iter.remove(iter.size() - 1);
            }
        }
    }

    public boolean isPalindrome(char[] chars, int left, int right)
    {
        if (left >= right)
            return false;
        if (right - left == 1)
            return true;

        for (int i = 0; i < (right - left) / 2; i++)
        {
            if (chars[left + i] != chars[right - 1 - i])
                return false;
        }
        return true;
    }
}
