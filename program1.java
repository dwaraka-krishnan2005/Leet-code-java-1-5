class Solution {
    public int[] twoSum(int[] nums, int target) {
          Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            // Calculate what we need to reach the target
            int complement = target - nums[i];
            
            // Check if we have already seen that number
            if (map.containsKey(complement)) {
                // If yes, return the index of the complement and current index
                return new int[] { map.get(complement), i };
            }
            
            // Otherwise, store the current number and its index in the map
            map.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found (though the problem guarantees one)
        return new int[] {};
    }
}
