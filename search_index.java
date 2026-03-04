class search_index {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            // Calculate mid safely
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Target found
            } else if (nums[mid] < target) {
                left = mid + 1; // Target is to the right
            } else {
                right = mid - 1; // Target is to the left
            }
        }

        // If not found, 'left' is the insertion index
        return left;
    }
}
