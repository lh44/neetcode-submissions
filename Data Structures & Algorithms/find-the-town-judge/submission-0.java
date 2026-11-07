class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, List<Integer>> list = new HashMap<>();

        for (int[] edge: trust) {
            list.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            list.putIfAbsent(edge[1], new ArrayList<>());
        }

        int judge = -1;
        for (int each: list.keySet()) {
            List<Integer> cit = list.get(each);
            if (cit.isEmpty()) {
                judge = each;
                break;
            }
        }
    
        for (int each: list.keySet()) {
            if (each != judge && !list.get(each).contains(judge)) {
                return -1;
            }
        }

        return judge;
    }
}