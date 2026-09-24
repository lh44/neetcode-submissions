class Solution {

  private static final char DELIMITER = '#';
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s: strs) {
      sb.append(s.length())
        .append(DELIMITER)
        .append(s);
    }
    return sb.toString();
  }

  public List<String> decode(String str) {
    List<String> strs = new ArrayList<>();
    int index = 0;
    while (index < str.length()) {
      int length = 0;
      while (str.charAt(index) != DELIMITER) {
        length = length * 10 + (str.charAt(index) - '0');
        index++;
      }
      index++;

      strs.add(str.substring(index, index + length));
      index += length;
    }
    return strs;
  }
}
