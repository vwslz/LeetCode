// O(n)

public class PalindromeNumber_9 {

    int y;

    public boolean isPalindrome(int x) {
        y  = x;
        return (x < 0) ? false : isPalindrome_helper(x);
    }

    public boolean isPalindrome_helper(int x) {
        if (x == 0) return true;
        if (isPalindrome_helper(x / 10)) {
            if ((x % 10) == (y % 10)){
                y /= 10;
                return true;
            }
        }
        return false;
    }
}
