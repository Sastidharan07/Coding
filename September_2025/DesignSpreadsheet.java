//Question : https://leetcode.com/problems/design-spreadsheet/description/
class Spreadsheet {
    private int[][] grid;
    private int rows;
    public Spreadsheet(int rows) {
        this.rows=rows;
        grid=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col=cell.charAt(0)-'A';
        int row=Integer.parseInt(cell.substring(1))-1;
        grid[row][col]=value;
    }
    
    public void resetCell(String cell) {
        int col=cell.charAt(0)-'A';
        int row=Integer.parseInt(cell.substring(1))-1;
        grid[row][col]=0;
    }
    
    public int getValue(String formula) {
        String exp=formula.substring(1);
        String[] tok=exp.split("\\+");
        int sum=0;
        for(String s:tok){
            sum+=evaltok(s);
        }
        return sum;
    }
    public int evaltok(String tok){
        if(Character.isDigit(tok.charAt(0))){
            return Integer.parseInt(tok);
        }
        else{
            int col=tok.charAt(0)-'A';
            int row=Integer.parseInt(tok.substring(1))-1;
            return grid[row][col];
        }
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
