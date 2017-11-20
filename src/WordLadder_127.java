import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class WordLadder_127 {
    int res = 2;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.indexOf(endWord) < 0)
            return 0;

        List<String> left = new ArrayList<String>();
        left.add(beginWord);
        List<String> right = new ArrayList<String>();
        right.add(endWord);

        bfs(wordList, left, right);
        return res;
    }

    public void bfs(List<String> wordList, List<String> lefts, List<String> rights)
    {
        List<String> current = new ArrayList<String>();
        if (lefts.size() > 0 && rights.size() > 0)
        {
            if (lefts.size() > rights.size())
            {
                // System.out.println("change left and right.");
                bfs(wordList, rights, lefts);
            }
            else
            {
                for (String left: lefts)
                {
                    for (String right: rights)
                    {
                        if (isLadder(left, right))
                        {
                            return;
                        }
                    }
                    ListIterator<String> iter = wordList.listIterator();
                    while(iter.hasNext()){
                        String word = iter.next();
                        if (left.equals(word))
                            iter.remove();
                        else
                        {
                            if (isLadder(left, word))
                            {
                                current.add(word);
                                iter.remove();
                            }
                        }
                    }
                }
                res++;
                bfs(wordList, rights, current);
            }
        }
        else
            res = 0;
    }

    public boolean isLadder(String str1, String str2)
    {
        int diff = 0;
        int index = 0;
        while (index < str1.length())
        {
            if (str1.charAt(index) != str2.charAt(index))
                diff++;
            if (diff > 1)
                return false;
            index++;
        }
        return (diff == 1);
    }
}
