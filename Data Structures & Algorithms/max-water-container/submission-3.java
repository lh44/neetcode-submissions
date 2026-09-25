class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int left = 0;
        int right = heights.length-1;

        while (left < right) {
            int leftHeight = heights[left];
            int rightHeight = heights[right];

            int area = Math.min(leftHeight, rightHeight) * (right - left);
            max = Math.max(max, area);

            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
