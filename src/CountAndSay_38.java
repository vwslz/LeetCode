// O(n)
public class CountAndSay_38 {
    public String countAndSay(int n) {
        if (n < 1)
            return null;
        if (n == 1)
            return "1";
        String iter = "1";
        for (int i = 1; i < n; i++) {
            iter = casHelper(iter);
        }
        return iter;
    }

    public String casHelper(String n){
        char[] n_c = n.toCharArray();
        char pre = n_c[0];
        int count = 1;
        for (int i = 1; i < n.length(); i++) {
            if (n_c[i] != pre) {
                pre = n_c[i];
                count++;
            }
        }
        char[] res = new char[count * 2];
        int index = 0;
        for (int i = 0; i < count; i++) {
            char c = n_c[index];
            int c_count = 0;
            while(n_c[index++] == c){
                c_count++;
                if(index >= n.length())
                    break;
            }
            res[2 * i + 1] = c;
            res[2 * i] = (char)('0' + c_count);
        }
        return String.valueOf(res);
    }
}
