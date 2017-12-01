public class ImplementTrie_PrefixTree_208 {
    TrieNode root;
    TrieNode iter;
    /** Initialize your data structure here. */
    public ImplementTrie_PrefixTree_208() {
        root = new TrieNode('.');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        iter = root;
        for (int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if (iter.children[c - 'a'] == null)
                iter.children[c - 'a'] = new TrieNode(c);
            iter = iter.children[c - 'a'];
        }
        iter.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word)
    {
       return startsWith(word) && iter.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        iter = root;
        for (int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if (iter.children[c - 'a'] == null)
                return false;
            iter = iter.children[c - 'a'];
        }
        return true;
    }
}

class TrieNode {
    char val;
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
    TrieNode(char c){ val = c; isWord = false;}
}
