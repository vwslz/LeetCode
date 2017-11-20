import java.util.*;

// improve in the future
public class WordLadderII_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();

        if (wordList.indexOf(endWord) < 0)
            return res;
        if (isLadder(beginWord, endWord))
        {
            List<String> listStr = new ArrayList<String>(Arrays.asList(beginWord, endWord));
            res.add(listStr);
            return res;
        }

        List<String> left = new ArrayList<String>();
        List<String> right = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.put(beginWord, new ArrayList<String>());
        map.put(endWord, new ArrayList<String>());
        left.add(beginWord);
        right.add(endWord);

        List<String[]> combination = bfs(wordList, left, right, map);
        List<String> iterList = new LinkedList<String>();

        for(String[] strs: combination)
        {
            iterList = new LinkedList<String>();
            generateHelper(beginWord, map, strs[1], strs[0], iterList, res);
        }

        return res;
    }

    public List<String[]> bfs(List<String> wordList, List<String> lefts, List<String> rights, Map<String, List<String>> map)
    {
        List<String> current = new ArrayList<String>();
        if (lefts.size() > 0 && rights.size() > 0)
        {
            if (lefts.size() > rights.size())
            {
                return bfs(wordList, rights, lefts, map);
            }
            else
            {
                List<String[]> res = new ArrayList<String[]>();
                for (String left: lefts)
                {
                    for (String right: rights)
                    {
                        String[] combination = new String[2];
                        if (isLadder(left, right))
                        {
                            combination[0] = left;
                            combination[1] = right;
                            res.add(combination.clone());
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
                                List<String> value = new ArrayList<String>();
                                if (map.containsKey(word))
                                    value = new ArrayList<String>(map.get(word));
                                value.add(left);
                                map.put(word, value);

                                current.remove(word);
                                current.add(word);
                            }
                        }
                    }
                }

                wordList.removeAll(current);
                if (res.size() > 0)
                    return res;
                return bfs(wordList, rights, current, map);
            }
        }
        else
        {
            List<String[]> empty = new ArrayList<String[]>();
            return empty;
        }
    }

    public boolean isLadder(String a, String b)
    {
        int diff = 0;
        for (int i = 0; i < a.length(); i++)
        {
            if (a.charAt(i) != b.charAt(i))
                diff++;
            if (diff > 1)
                return false;
        }
        return diff == 1;
    }

    public void generateHelper(String beginWord, Map<String, List<String>> map, String keyRight, String key, List<String> iterList, List<List<String>> res)
    {
        iterList.add(0, key);
        if (map.get(key).size() > 0)
        {

            for (String newKey: map.get(key))
            {
                generateHelper(beginWord, map, keyRight, newKey, iterList, res);
            }
        }
        else
        {
            List<String> newIterList = new LinkedList<String>();
            generateHelperRight(beginWord, map, keyRight, iterList, newIterList, res);
        }
        iterList.remove(0);
    }

    public void generateHelperRight(String beginWord, Map<String, List<String>> map, String key, List<String> listLeft, List<String> iterList, List<List<String>> res)
    {
        iterList.add(0, key);
        if (map.get(key).size() > 0)
        {

            for (String newKey: map.get(key))
            {
                generateHelperRight(beginWord, map, newKey, listLeft, iterList, res);
            }
        }
        else
        {
            List<String> wholeList= new LinkedList<String>();
            if (listLeft.get(0).equals(beginWord))
            {
                wholeList = new LinkedList<String>(listLeft);
                Collections.reverse(iterList);
                wholeList.addAll(iterList);
                Collections.reverse(iterList);
            }
            else
            {
                wholeList = new LinkedList<String>(iterList);
                Collections.reverse(listLeft);
                wholeList.addAll(listLeft);
                Collections.reverse(listLeft);
            }
            res.add(wholeList);
        }
        iterList.remove(0);
    }
}
