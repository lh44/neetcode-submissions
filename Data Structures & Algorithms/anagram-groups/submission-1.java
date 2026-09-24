class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String gram: strs) {
            int[] count = new int[26];
            for (char c: gram.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i: count) {
                sb.append("#").append(i);
            }
            String key = sb.toString();
            groups.computeIfAbsent(key, v -> new ArrayList<>()).add(gram);
        }

        return new ArrayList<>(groups.values());
    }
}
