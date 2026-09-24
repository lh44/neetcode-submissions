class Solution {
    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length()-1;

        while (left < right) {
            if (!isAlpha(s.charAt(left))) {
                left++;
            } else if (!isAlpha(s.charAt(right))) {
                right--;
            } else if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isAlpha(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}
