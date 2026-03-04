class container_water {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate width
            int width = right - left;
            
            // The height of the container is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);
            
            // Update the maximum water found so far
            int currentWater = width * currentHeight;
            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
