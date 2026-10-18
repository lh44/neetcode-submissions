class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temps = new Stack<>();
        int[] res = new int[temperatures.length];
        temps.push(0);

        for (int i=1 ;i<temperatures.length; i++) {
            int current = temperatures[i];
            while (!temps.isEmpty() && temperatures[temps.peek()] < current) {
                int index = temps.pop();
                res[index] = i-index;
            }
            temps.push(i);
        }

        return res;
    }
}
