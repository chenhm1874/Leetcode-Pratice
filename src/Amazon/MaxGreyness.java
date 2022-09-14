package Amazon;

public class MaxGreyness {
    public static int maxGreyness(String[] grid){
        int[] prefRow=new int[grid.length];
        int[] prefCol=new int[grid[0].length()];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length();j++){
                if(grid[i].charAt(j)=='1'){
                    prefRow[i]+=1;
                    prefCol[j]+=1;
                }
                else{
                    prefRow[i]+=1;
                    prefCol[j]-=1;
                }
            }
        }
        int maxRow=Integer.MIN_VALUE;
        int maxCol= Integer.MIN_VALUE;
        for(int c:prefRow){
            if(c>maxRow){
                maxRow=c;
            }
        }
        for(int v:prefCol){
            maxCol=Math.max(maxCol,v);
        }
        return maxCol+maxRow;
    }

    public static void main(String[] args) {
        int res=maxGreyness(new String[]{"1101","0101","1010"});
        System.out.println(res);
    }
}
