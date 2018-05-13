package TrieDemo;

/**
 * @Author: Allen
 * @Description:        字典树
 * @Date: Created in 22:30 2018/5/13
 * @Modify By:
 */
public class Trie {
    static class TireNode{
        public int path;
        public int end;
        public TireNode[] map;

        public TireNode() {
            path = 0;
            end = 0;
            map = new TireNode[26];     // 此处因为只有26个字母，如果字符种类多的话可以使用map
        }
    }
    private TireNode root;

    public Trie() {
        root = new TireNode();
    }

    void insert(String word){
        if (word == null)
            return;
        char[] chars = word.toCharArray();
        TireNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';     // 获取需要存的字符的位置
            if (node.map[index] == null){
                node.map[index] = new TireNode();
            }
            node = node.map[index];
            node.path++;        // 表示有多少个单词共用这个节点
        }
        node.end++;     // 表示一个单词的结尾，此处表示有多少个单词以这个节点结尾
    }

    boolean search(String word){
        if (word == null)
            return false;
        char[] chars = word.toCharArray();
        TireNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i]-'a';
            if (node.map[index] == null)
                return false;
            node = node.map[index];
        }
        return node.end!=0;     // 表示存在以这个节点结尾的单词
    }

    void del(String word){
        if (search(word)){
            char[] chars = word.toCharArray();
            TireNode node = root;
            int index =0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i]-'a';
                if (node.map[index].path-- == 0){
                    node.map[index] = null;
                    break;
                }
                node = node.map[index];
                node.path--;        // 共用这个节点的单词变少了
            }
            node.end--;     // 以这个单词为结尾的节点少了一个
        }
    }

    /**
     * 表示以字符串pre为 前缀的单词的数量
     * @param pre
     * @return
     */
    int prefixNumber(String pre){
        if (pre == null)
            return -1;
        char[] chars = pre.toCharArray();
        TireNode node = root;
        int index =0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i]-'a';
            if (node.map[index] == null){
                return 0;
            }
            node = node.map[index];
        }
        return node.path;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abcd");
        trie.insert("abd");
        trie.insert("b");
        trie.insert("bcd");
        trie.insert("efg");
        trie.insert("hik");
        System.out.println(trie.prefixNumber("b"));
        trie.del("abc");
        System.out.println(trie.search("abc"));
    }
}