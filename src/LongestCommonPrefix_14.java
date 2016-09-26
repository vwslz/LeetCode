// O(nm)
public class LongestCommonPrefix_14 {
    public String lngestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String res = "";
        for (int i = 0; i < strs[0].length(); i++){
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++){
                if(strs[j].length() > i){
                    if(strs[j].charAt(i) != temp)
                        return res;
                }
                else
                    return res;
            }
            res += temp;
        }
        return res;
    }
}
