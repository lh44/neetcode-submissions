class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> counts = new HashMap<>(nums.length);
      for (int num: nums) {
        counts.compute(num, (n, v) -> v == null ? 1 : v+1);
      }

      List<List<Integer>> buckets = new ArrayList<>();
      for (int i=0; i<=nums.length; i++) {
        buckets.add(new ArrayList<>());
      } 

      for (int key: counts.keySet()) {
        buckets.get(counts.get(key)).add(key);
      }

      int[] arr = new int[k];
      int index = 0;
      int currentBucket = buckets.size()-1;
      while (index < k && currentBucket >= 0 && !buckets.isEmpty()) {
        for (int v: buckets.get(currentBucket)) {
          arr[index] = v;
          index++;
        }
        currentBucket--;
      }
      return arr;
    }
}
