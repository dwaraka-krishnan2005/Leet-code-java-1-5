class reomove_element {
    public int removeElement(int[] nums, int val) {
        // k represents the number of elements not equal to val
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            // If the current element is NOT the one we want to remove
            if (nums[i] != val) {
                // Move it to the 'k' position and increment k
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
