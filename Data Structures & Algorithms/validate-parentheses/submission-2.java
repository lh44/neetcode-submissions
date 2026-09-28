class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();

        for (Character c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                chars.push(c);
            } else if (!chars.isEmpty()) {
                if (c == ')') {
                    if (chars.pop() != '(') return false;
                }
                if (c == ']') {
                    if (chars.pop() != '[') return false;
                }
                if (c == '}') {
                    if (chars.pop() != '{') return false;
                }                                
            } else {
                return false;
            }
        }

        return chars.isEmpty();
    }
}
