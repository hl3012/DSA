import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length-2;i++) {
            if (i>0&&nums[i]==nums[i-1]) continue;
            int diff = 0-nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left<right) {
                if (nums[left]+nums[right]>diff) {
                    right--;
                } else if (nums[left]+nums[right]<diff) {
                    left++;
                } else {
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    while(left<right&&nums[left]==nums[left+1]) left++;
                    while(left<right&&nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
