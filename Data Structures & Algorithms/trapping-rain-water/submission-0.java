class Solution {
    public int trap(int[] height) {
        int max = 0;
        int len = height.length;
        int[] left = new int[len];
        for (int i=1; i<len; i++) {
            max = Math.max(height[i-1], max);
            left[i] = max;
        }

        max = 0;
        int[] right = new int[len];
        for (int i=len-2; i>=0; i--) {
            max = Math.max(height[i+1], max);
            right[i] = max;
        }

        int total = 0;
        for (int i=0; i<len; i++) {
            int cur = Math.min(left[i], right[i]) - height[i];
            if (cur > 0) total += cur;
        }
        return total;
    }
}
