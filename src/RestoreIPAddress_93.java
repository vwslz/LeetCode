import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress_93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4; k++) {
                    for (int l = k + 1; l < k + 4; l++) {
                        if (l == s.length() - 1) {
                            int one = Integer.parseInt(s.substring(0, i + 1));
                            int two = Integer.parseInt(s.substring(i + 1, j + 1));
                            int three = Integer.parseInt(s.substring(j + 1, k + 1));
                            int four = Integer.parseInt(s.substring(k + 1, l + 1));
                            if (one <= 255 && two <= 255 && three <= 255 && four <= 255) {
                                String output = one + "." + two + "." + three + "." + four;
                                if (output.length() == s.length() + 3)
                                    res.add(output);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}