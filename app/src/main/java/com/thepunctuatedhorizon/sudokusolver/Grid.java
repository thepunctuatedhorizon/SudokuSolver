package com.thepunctuatedhorizon.sudokusolver;

//Grid values holds the grid.
class Grid
{
    private String[][] grid = new String[9][9];
    private boolean[][] gridDone = new boolean[9][9];
    public Grid(String input)
    {
        super();
        setGrid(input);
    }

    @Override
    public String toString()
    {
        String returnString = "";
        for(int i = 0; i < 9; i++){
            for ( int j = 0; j < 9; j++){
                returnString += " " + grid[i][j];
            }
            returnString += "\n";
        }
        return returnString;
    }

    public String toStringNoFormat()
    {
        String returnString = "";
        for(int i = 0; i < 9; i++){
            for ( int j = 0; j < 9; j++){
                returnString += grid[i][j];
            }
        }
        return returnString;
    }

    public String getGrid()
    {
        return toStringNoFormat();
    }

    public String[][] getGridArray()
    {
        return this.grid;
    }

    public String getGridAt(int i, int j)
    {
        return this.grid[i][j];
    }

    public void setBoolAtTrue(int i, int j) {
        this.gridDone[i][j] = true;
    }

    public boolean getBoolAt(int i, int j)
    {
        return this.gridDone[i][j];
    }

    public void setGrid(String gridStr)
    {
        for(int i = 0; i < 9; i++){
            for ( int j = 0; j < 9; j++){
                int position = i*9 + j;
                int num = Integer.parseInt(gridStr.substring(position,position+1));
                this.gridDone[i][j] = (num == 0 ? false : true);
                this.grid[i][j] = num + "";
            }
        }
    }

    public void setGridAt(int i, int j, String value) {
        this.grid[i][j] = value;

    }

}