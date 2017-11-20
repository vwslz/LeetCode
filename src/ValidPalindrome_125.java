public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            char cl = chars[left];
            char cr = chars[right];
            if(!isValid(cl)){
                left++;
            }
            if(!isValid(cr)){
                right--;
            }
            if(isValid(cl) && isValid(cr)){
                if(cl != cr)
                    return false;
                left++;
                right--;
            }
        }
        return true;
    }

    public boolean isValid(char c){
        return (c >= 'a' && c <= 'z' ) || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
