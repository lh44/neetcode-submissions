class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] source = new char[128];
        char[] window = new char[128];
        for (int i=0; i<s1.length(); i++) {
            source[s1.charAt(i)]++;
            window[s2.charAt(i)]++;
        }
        if (Arrays.equals(source, window)) return true;
        
        for (int right=s1.length(); right<s2.length(); right++) {
            char cur = s2.charAt(right);
            window[cur]++;
            window[s2.charAt(right - s1.length())]--;
            if (Arrays.equals(source, window)) {
                return true;
            }
        }
        return false;
    }
}
