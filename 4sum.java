import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return result;

        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Optimization: If the smallest 4 numbers are > target, no need to continue
            if ((long) nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            // Optimization: If the largest 3 numbers + nums[i] are < target, skip this i
            if ((long) nums[i] + nums[n-3] + nums[n-2] + nums[n-1] < target) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate for the second number
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                // Similar optimizations for the second loop
                if ((long) nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n-2] + nums[n-1] < target) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long currentSum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (currentSum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for left and right
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (currentSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
