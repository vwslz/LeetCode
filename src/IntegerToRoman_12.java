// O(n)
public class IntegerToRoman_12 {
    public String intToRoman(int num) {
        int[] ints = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String res = "";
        int i = 0;
        while (num > 0 && i < ints.length) {
            while (num >= ints[i]) {
                res += strs[i];
                num -= ints[i];
            }
            i++;
        }
        return res;
    }
}
