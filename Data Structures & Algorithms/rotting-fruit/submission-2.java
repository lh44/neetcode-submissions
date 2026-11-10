class Solution {
    public int orangesRotting(int[][] grid) {
        final Queue<int[]> queue = new LinkedList<>();
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[r].length; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } 
            }
        }

        while (!queue.isEmpty()) {
            int[] chest = queue.poll();

            int r = chest[0];
            int c = chest[1];
            int v = grid[r][c];

            setValue(grid, r-1, c, v, queue);
            setValue(grid, r+1, c, v, queue);
            setValue(grid, r, c-1, v, queue);
            setValue(grid, r, c+1, v, queue);
        }

        int mins = 0;
        System.out.println(Arrays.deepToString(grid));
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    return -1;
                } else {
                    mins = Math.max(mins, grid[r][c]-2);
                }
            }
        }
        return mins;
    }

    private void setValue(int[][] grid, int r, int c, int v, Queue<int[]> queue) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[r].length || grid[r][c] == 0) {
            return;
        }

        if (grid[r][c] == 1) {
            grid[r][c] = v+1;
            queue.offer(new int[]{r, c});
        }
    }
}
