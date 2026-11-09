class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c, 0));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c, int area) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return area;
        }
        
        grid[r][c] = 0;
        return 1 + dfs(grid, r-1, c, area) + dfs(grid, r+1, c, area) + dfs(grid, r, c-1, area) + dfs(grid, r, c+1, area);
    }
}
