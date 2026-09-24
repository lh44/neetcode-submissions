class Solution {

  private final char delimiter = '#';
  public String encode(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (String s: strs) {
      sb.append(s.length())
        .append(delimiter)
        .append(s);
    }
    return sb.toString();
  }

  public List<String> decode(String str) {
    List<String> strs = new ArrayList<>();
    char[] encoded = str.toCharArray();
    int index = 0;
    String currentLength = "";
    while (index < encoded.length) {
      if (encoded[index] == delimiter) {
        int sl = currentLength.isEmpty() ? 0 : Integer.parseInt(currentLength);
        StringBuilder sb = new StringBuilder();
        for (int i=index + 1; i <= index + sl; i++) {
          sb.append(encoded[i]);
        }
        strs.add(sb.toString());
        index += sl+1;
        currentLength = "";
      } else {
        currentLength += encoded[index];
        index++;
      }
    }
    return strs;
  }
}
