class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        Map<Integer, Integer> pre = new HashMap<>(len);
        for (int i=0; i<len; i++) {
            pre.put(position[i], speed[i]);
        }
        position = Arrays.stream(position)
                 .boxed()
                 .sorted(Comparator.reverseOrder())
                 .mapToInt(Integer::intValue)
                 .toArray();

        float last = 0;
        int fleets = 0;
        for (int i=0; i<len; i++) {
            float time = (float)(target - position[i])/pre.get(position[i]);
            if (time > last) {
                fleets++;
                last = time;
            }
        }
        return fleets;
    }
}
