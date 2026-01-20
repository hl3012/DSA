import java.util.*;
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map=new HashMap<>();
        for (String s: strs) {
            int[] table =new int[26];
            for(char c: s.toCharArray()) {
                table[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int n: table) {
                sb.append(n).append('#');
            }
            // map.putIfAbsent(sb.toString(),new ArrayList<>());
            // map.get(sb.toString()).add(s);
            // if (map.containsKey(sb.toString())) {
            //     map.get(sb.toString()).add(s);
            // } else {
            //     map.put(sb.toString(), new ArrayList<>());
            //     map.get(sb.toString()).add(s);
            // }
            map.computeIfAbsent(sb.toString(), k->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
