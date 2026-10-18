class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> temps = new Stack<>();
        int len = temperatures.length;
        int[] res = new int[len];
        temps.push(0);

        for (int i=1 ;i<len; i++) {
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
