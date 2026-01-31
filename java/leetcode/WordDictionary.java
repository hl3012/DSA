class TriesNode {
    TriesNode[] children = new TriesNode[26];
    boolean isEnd = false;
}


class WordDictionary {
    private TriesNode root;
    public WordDictionary() {
        root = new TriesNode();
    }

    public void addWord(String word) {
        TriesNode curr = root;
        for (char c: word.toCharArray()) {
            if(curr.children[c-'a']==null) {
                curr.children[c-'a']=new TriesNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
       return dfs(root, word, 0,2);
    }

    private boolean dfs(TriesNode node, String word, int index, int remainingDots) {
        if (index==word.length()) {
            return node.isEnd;
        }
        char c=word.charAt(index);
        if(c!='.') {
            if (node.children[c-'a']==null) return false;
            return dfs(node.children[c-'a'], word, index+1, remainingDots);
        } else {
            // if (remainingDots==0) return false;
            for (int i = 0;i<26;i++) {
                if (node.children[i]!=null&&dfs(node.children[i],word, index+1, remainingDots-1)) {
                    return true;
                }
            }
            return false;
        }
    }
}