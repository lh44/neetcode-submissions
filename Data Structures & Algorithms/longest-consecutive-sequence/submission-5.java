class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> items = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            items.add(nums[i]);
        }

        int max = 1;
        for (int i=0; i<nums.length; i++) {
            if (!items.contains(nums[i] - 1)) { //start of sequence
              int cur = 1;
              int next = nums[i] + 1;
              while (items.contains(next)) {
                cur++;
                next++;
              }
              max = Math.max(cur, max);
            }
        }
        return max;
    }
}
