class Solution {
    public int numIslands(char[][] grid) {
        //piexes collected one at a time
        if(grid == null || grid.length == 0){
            return 0;
        }
        
        //call dfs/bfs 
        int numOfIslands = 0;
        //traverse the entire grid using nested for loop
        for(int i = 0 ;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                //check for the ones having ones
                if(grid[i][j] == '1'){
                    //call the general format of BFS
                    numOfIslands += dfs(grid, i,j);
                }
            }
        }
        return numOfIslands;
    }
    public int dfs(char[][] grid, int i, int j){
        //check the edge condition in recursive call -> very important to check the outside of grid condition
        if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j] == '0'){
            return 0;
        }
        //sink island
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        return 1;
    }
}
