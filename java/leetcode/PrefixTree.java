class TriesNode {
    TriesNode[] childNodes = new TriesNode[26];
    boolean isEnd = false;
}


public class PrefixTree {
    private TriesNode root;
    public PrefixTree() {
         root = new TriesNode();
    }

    public void insert(String word) {
        TriesNode curr = root;
        for (char c: word.toCharArray()) {
            if(curr.childNodes[c-'a']==null) {
                curr.childNodes[c-'a']=new TriesNode();
            }
            curr=curr.childNodes[c-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        TriesNode curr = root;
        for (char c: word.toCharArray()) {
            if (curr.childNodes[c-'a']==null) {
                return false;
            }
            curr=curr.childNodes[c-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TriesNode curr = root;
        for (char c: prefix.toCharArray()) {
            if (curr.childNodes[c-'a']==null) {
                return false;
            }
            curr=curr.childNodes[c-'a'];
        }
        return true;
    }
}
