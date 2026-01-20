import java.util.*
;
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()) return false;

        // int[] table =new int[26];

        // for(int i=0; i<s.length();i++) {
        //     table[s.charAt(i)-'a']++;
        //     table[t.charAt(i)-'a']--;
        // }
        
        // for (int i: table) {
        //     if (i!=0) return false;
        // }
        // return true;
        Map<Character, Integer> map = new HashMap<>();
        for (char c:s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (char c:t.toCharArray()) {
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c)-1);
            if(map.get(c)<0) return false;
        }
        for(int i: map.values()) {   
            if (i!=0) return false;   
        }
        return true;
    }

    public static void main(String[] args) {
        String s="ratta";
        String t="ttark";
        System.out.println(isAnagram(s, t));
    }
}
