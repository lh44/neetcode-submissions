class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String gram: strs) {
            char[] arr = gram.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            groups.computeIfAbsent(key, v -> new LinkedList<>()).add(gram);
        }

        return new LinkedList(groups.values());
    }
}
