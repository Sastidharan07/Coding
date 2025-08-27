//Question : https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/description/
class Solution {
    int result=0;
    public int lenOfVDiagonal(int[][] grid) {
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    result=Math.max(result,1);
                    if(i>0 && j>0 && grid[i-1][j-1]==2) 
                       func(-1,-1,i-1,j-1,true,2,grid);
                    if(i>0 && j<grid[0].length-1 && grid[i-1][j+1]==2)
                      func(-1,1,i-1,j+1,true,2,grid);  
                    if(i<grid.length-1 && j>0 && grid[i+1][j-1]==2) 
                       func(1,-1,i+1,j-1,true,2,grid);
                    if(i<grid.length-1 && j<grid[0].length-1 && grid[i+1][j+1]==2)
                      func(1,1,i+1,j+1,true,2,grid); 
                }
            }
        }
        return result;
    }

    void func(int dirRow,int dirCol,int row,int col,boolean vaildTurn,int len,int[][] grid){
        result=Math.max(result,len);
        int next=grid[row][col]==0?2:0;
        if(row+dirRow >=0 && row+dirRow<grid.length && col+dirCol >=0 && col+dirCol<grid[0].length && grid[row+dirRow][col+dirCol]==next) func(dirRow,dirCol,row+dirRow,col+dirCol,vaildTurn,len+1,grid);

        if(vaildTurn){
    // turn 90 degree clockwise
        int newDirRow = dirCol;     
    int newDirCol = -dirRow; 
        if(row+newDirRow >=0 && row+newDirRow<grid.length && col+newDirCol >=0 && col+newDirCol<grid[0].length && grid [row+newDirRow][col+newDirCol]==next){
        func(newDirRow,newDirCol,row+newDirRow,col+newDirCol,false,len+1,grid);
        }
    }

    }
}
