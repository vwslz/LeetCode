import java.util.ArrayList;
import java.util.List;

// O(mn)
public class TestJustification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int beginIndex = 0, endIndex = -1, sum = words[0].length();
        for (int i = 1; i < words.length; i++) {
            if (sum + 1 + words[i].length() > maxWidth) {
                endIndex = i - 1;
                res.add(contructString(words, beginIndex, endIndex, sum, maxWidth));
                beginIndex = i;
                sum = words[i].length();
            }
            else
                sum += words[i].length() + 1;
        }

        res.add(leftJustified(words, beginIndex, words.length - 1, maxWidth));
        return res;
    }

    public String contructString(String[] words, int beginIndex, int endIndex, int sum, int length) {
        if (beginIndex == endIndex)
            return leftJustified(words, beginIndex, endIndex, length);

        int blank = length - sum + endIndex - beginIndex, index = 0, i_blank = 0, i_word = beginIndex + 1, i_banks = blank % (endIndex - beginIndex);
        char[] res = new char[length];

        for (index = 0; index < words[beginIndex].length(); index++) {
            res[index] = words[beginIndex].charAt(index);
        }

        while (index < length) {
            if (i_blank < i_banks) {
                for (int i = 0; i < blank / (endIndex - beginIndex) + 1; i++)
                    res[index++] = ' ';
            }
            else {
                for (int i = 0; i < blank / (endIndex - beginIndex); i++)
                    res[index++] = ' ';
            }
            i_blank++;
            for (int i = 0; i < words[i_word].length(); i++)
                res[index++] = words[i_word].charAt(i);
            i_word++;
        }
        return String.valueOf(res);
    }

    public String leftJustified(String[] words, int beginIndex, int endIndex, int length) {
        char[] res = new char[length];
        int index = 0;
        for (int i_index = beginIndex; i_index <= endIndex; i_index++) {
            for (int i = 0; i < words[i_index].length(); i++) {
                res[index++] = words[i_index].charAt(i);
            }
            if (i_index < endIndex)
                res[index++] = ' ';
        }
        while (index < length)
            res[index++] = ' ';
        return String.valueOf(res);
    }
}
