class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        int rowId = 0;

        while (low <= high) {
            int mid = low + (high - low)/2;
            int[] row = matrix[mid];
            int rowLen = row.length;
            if (row[0] <= target && row[rowLen-1] >= target) {
                rowId = mid;
                break;
            } else if (row[0] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        low = 0;
        int[] row = matrix[rowId];
        high = matrix[rowId].length-1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (row[mid] > target) {
                high = mid - 1;
            } else if (row[mid] < target) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
