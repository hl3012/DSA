import java.util.*;
public class containDuplicate {
    public static boolean hasDuplicate(int[] nums) {
        // Set<Integer> set = new HashSet<>();
        // for (int num: nums) {
        //     if (!set.add(num)) {
        //         return true;
        //     } else {
        //         set.add(num);
        //     }
        // }
        // return false;
        Arrays.sort(nums);
        for (int i=1; i<nums.length;i++) {
            if (nums[i]==nums[i-1]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        System.out.println(hasDuplicate(nums));
        int[] nums1={1,2,3,4,5,5};
        System.out.println(hasDuplicate(nums1));
    }
}

//内存受限？ 排序后 线性扫描


