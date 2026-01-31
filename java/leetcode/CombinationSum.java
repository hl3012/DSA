import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res, path, 0, target, 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> path, int CurrSum, int target, int startIndex) {
        if (CurrSum==target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (CurrSum>target) {
            return;
        }
        for (int i = startIndex; i<nums.length;i++) {
            path.add(nums[i]);
            helper(nums, res, path, CurrSum+nums[i], target, i);
            path.remove((path.size()-1));
        }

    }
}
