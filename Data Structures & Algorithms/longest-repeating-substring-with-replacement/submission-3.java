class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int max = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char cur = s.charAt(right);
            freq[cur - 'A']++;

            maxFreq = Math.max(maxFreq, freq[cur - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
