public class wordSearch {
    public boolean exist(char[][] board, String word) {
        if(board==null){
            return false;
        }
        int m=board.length;
        int n=board[0].length;
        boolean[][] existed=new boolean[m][n];
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(helper(board,existed,word.toCharArray(),0,row,col)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean helper(char[][] board,boolean[][] existed,char[] word,int index,int row,int col){
        if(index==word.length){
            return true;
        }
        if(row<0 || row>board.length || col<0 || col> board[0].length){
            return false;
        }
        if(existed[row][col]==true || board[row][col]!=word[index]){
            return false;
        }
        existed[row][col]=true;
        boolean exist=helper(board,existed,word,index+1,row,col+1);
        if(exist) return true;
        exist=helper(board,existed,word,index+1,row,col-1);
        if(exist) return true;
        exist=helper(board,existed,word,index+1,row+1,col);
        if(exist) return true;
        exist=helper(board,existed,word,index+1,row-1,col);
        if(exist) return true;
        existed[row][col]=false;
        return false;
    }
}
