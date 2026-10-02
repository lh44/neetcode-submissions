class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board[0].length;
        Set<Character>[] rows = new HashSet[len];
        Set<Character>[] cols = new HashSet[len];
        Set<Character>[] boxes = new HashSet[len];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for (int row=0; row<len; row++) {
            for (int col=0; col<len; col++) {
                char val = board[row][col];

                if (val == '.') {
                    continue;
                }

                int boxInd = (row/3) * 3 + (col/3);

                if (rows[row].contains(val) || cols[col].contains(val) || boxes[boxInd].contains(val)) {
                    return false;
                }
                rows[row].add(val);
                cols[col].add(val);
                boxes[boxInd].add(val);
            }
        }
        return true;
    }
}
