public class numberOfIslands {
    public static void dfs(int[][] grid,int i,int j, int M,int N){
        if(i<0||i>=M||j<0||j>=N||grid[i][j]!=1){
            return;
        }
        grid[i][j]=2;
        dfs(grid,i+1,j,M,N);
        dfs(grid,i-1,j,M,N);
        dfs(grid,i,j+1,M,N);
        dfs(grid, i, j-1, M, N);
    }
    public int countIslands(int[][] grid){
        if(grid==null || grid[0]==null){
            return 0;
        }
        int M=grid[0].length;
        int N=grid.length;
        int res=0;
        for(int i =0;i<N;i++){
            for(int j=0;j<M;j++){
                if(grid[i][j]==1){
                    res++;
                    dfs(grid,i,j,M,N);
                }
            }
        }
        return res;
    }
}
