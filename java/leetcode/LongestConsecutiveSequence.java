import java.util.*;
public class LongestConsecutiveSequence {
    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        } //作为词典查  快

        int maxLen=0;
        for (int num: set) {
            if (!set.contains(num-1)) {
                int length = 1;
                int curr=num;
                while (set.contains(curr+1)) {
                    curr++;
                    length++;
                }
                maxLen=Math.max(maxLen,length);
            }
        }
        return maxLen;

        // Arrays.sort(nums);
        // int maxLength=1;
        // int curr=1;
        // for(int i=1;i<nums.length;i++) {
        //     if (nums[i]==nums[i-1]) continue;
        //     if (nums[i]==nums[i-1]+1) curr++;
        //     else curr=1;
        //     maxLength=Math.max(maxLength, curr);
        // }
        // return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,20,4,10,3,4,5};
        System.out.println(longestConsecutiveSequence(nums));
    }
}
