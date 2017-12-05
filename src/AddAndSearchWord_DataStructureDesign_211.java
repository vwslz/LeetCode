public class AddAndSearchWord_DataStructureDesign_211 {
    TrieNode root;
    TrieNode iter;

    /**
     * Initialize your data structure here.
     */
    public AddAndSearchWord_DataStructureDesign_211() {
        root = new TrieNode('.');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        iter = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (iter.children[c - 'a'] == null)
                iter.children[c - 'a'] = new TrieNode(c);
            iter = iter.children[c - 'a'];
        }
        iter.isWord = true;
    }


    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    public boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length())
            return node.isWord;

        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null)
                    if (searchHelper(word, index + 1, node.children[i]))
                        return true;
            }
        } else if (node.children[word.charAt(index) - 'a'] != null)
            return searchHelper(word, index + 1, node.children[word.charAt(index) - 'a']);
        return false;
    }
}
