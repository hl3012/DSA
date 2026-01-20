import java.util.*;

public class LongestSubStringWithTwoDistinct {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int left=0, right=0, maxLen=0;
        Map<Character, Integer> map = new HashMap<>();

        while (right<s.length()) {
            char c= s.charAt(right);
            map.put(c, map.getOrDefault(c,0)+1);
            while (map.keySet().size()>2) {
                char c1= s.charAt(left);
                map.put(c1, map.get(c1)-1);
                if (map.get(c1)==0) {
                    map.remove(c1);
                }
                left++;
            }
            maxLen=Math.max(right-left+1, maxLen);
            right++;

        }
        return maxLen;
    }
}
