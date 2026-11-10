class Solution {
    public void islandsAndTreasure(int[][] grid) {
        final Queue<int[]> queue = new LinkedList<>();
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[r].length; c++) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                } 
            }
        }

        while (!queue.isEmpty()) {
            int[] chest = queue.poll();

            int r = chest[0];
            int c = chest[1];
            int current = grid[r][c];
            setValue(grid, r-1, c, current+1, queue);
            setValue(grid, r+1, c, current+1, queue);
            setValue(grid, r, c-1, current+1, queue);
            setValue(grid, r, c+1, current+1, queue);
        }
    }

    private void setValue(int[][] grid, int r, int c, int value, Queue<int[]> queue) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length) {
            return;
        }

        if (grid[r][c] == Integer.MAX_VALUE) {
            grid[r][c] = value;
            queue.offer(new int[]{r, c});
        }
    }
}
