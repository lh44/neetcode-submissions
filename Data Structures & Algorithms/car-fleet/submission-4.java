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

        Stack<Float> fleets = new Stack<>();
        for (int i=0; i<len; i++) {
            float time = (float)(target - position[i])/pre.get(position[i]);
            System.out.println(time);
            if (fleets.isEmpty() || time > fleets.peek()) {
                fleets.push(time);
            }
        }
        return fleets.size();
    }
}
