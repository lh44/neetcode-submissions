class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            int val = nums[i];
            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = (nums[left] + nums[right] + val);
                if (sum == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(val);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    if (!triplets.contains(triplet)) {
                        triplets.add(triplet);
                    }
                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return triplets;
    }
}
