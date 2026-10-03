class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        int left = 0;
        int max = 0;
        int[] chars = new int[128];
        for (int right=0; right< s.length(); right++) {
            char current = s.charAt(right);
            left = Math.max(left, chars[current]);
            max = Math.max(max, right-left+1);
            chars[current] = right+1;
        }
        return max;
    }
}
