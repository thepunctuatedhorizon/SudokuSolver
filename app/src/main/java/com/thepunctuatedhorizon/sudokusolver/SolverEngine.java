package com.thepunctuatedhorizon.sudokusolver;


class SolverEngine
{
    private String[][] kO = new String[9][9];
    private boolean[][] kOdone = new boolean[9][9];
    private Grid grid;

    public SolverEngine(Grid grd){
        super();
        grid = new Grid(grd.toStringNoFormat());

        for ( int i = 0; i < 9; i++){
            for ( int j = 0; j < 9; j++){
                kO[i][j] = "123456789";
                kOdone[i][j] = grid.getBoolAt(i,j);
            }
        }
    }

    public void checkForSingleKO(int i, int j) {
        if ((kO[i][j].length() < 2)) {
            if (kOdone[i][j]) {return;}
            if (!(grid.getGridAt(i, j).contains("0"))) {return;}

            System.out.println("i = " + i + ", " + "j = " + j);
            kOdone[i][j] = true;
            grid.setGridAt(i, j, kO[i][j]);
            return;
        }

    }

    public boolean getBoolAt(int i, int j) {
        return kOdone[i][j];
    }

    public String printOutKOs(){
        String returnString = "";
        for(int i = 0; i < 9; i++){
            returnString = returnString += "Line " + i;
            for ( int j = 0; j < 9; j++){
                returnString += "\t" + kO[i][j];
            }
            returnString += "\n";
        }
        return returnString;
    }

    public void reduce3x3(int boxNum) {
        String [] kOofBox = new String[9];

        int[][] map = new int[9][2];

        switch (boxNum) {
            case 0:{
                map[0][0] = 0;
                map[0][1] = 0;

                map[1][0] = 1;
                map[1][1] = 0;

                map[2][0] = 2;
                map[2][1] = 0;

                map[3][0] = 0;
                map[3][1] = 1;

                map[4][0] = 1;
                map[4][1] = 1;

                map[5][0] = 2;
                map[5][1] = 1;

                map[6][0] = 0;
                map[6][1] = 2;

                map[7][0] = 1;
                map[7][1] = 2;

                map[8][0] = 2;
                map[8][1] = 2;
                break;
            }

            case 1:{
                map[0][0] = 0;
                map[0][1] = 3;

                map[1][0] = 1;
                map[1][1] = 3;

                map[2][0] = 2;
                map[2][1] = 3;

                map[3][0] = 0;
                map[3][1] = 4;

                map[4][0] = 1;
                map[4][1] = 4;

                map[5][0] = 2;
                map[5][1] = 4;

                map[6][0] = 0;
                map[6][1] = 5;

                map[7][0] = 1;
                map[7][1] = 5;

                map[8][0] = 2;
                map[8][1] = 5;
                break;
            }

            case 2:{
                map[0][0] = 0;
                map[0][1] = 6;

                map[1][0] = 1;
                map[1][1] = 6;

                map[2][0] = 2;
                map[2][1] = 6;

                map[3][0] = 0;
                map[3][1] = 7;

                map[4][0] = 1;
                map[4][1] = 7;

                map[5][0] = 2;
                map[5][1] = 7;

                map[6][0] = 0;
                map[6][1] = 8;

                map[7][0] = 1;
                map[7][1] = 8;

                map[8][0] = 2;
                map[8][1] = 8;
                break;
            }

            case 3:{
                map[0][0] = 3;
                map[0][1] = 0;

                map[1][0] = 4;
                map[1][1] = 0;

                map[2][0] = 5;
                map[2][1] = 0;

                map[3][0] = 3;
                map[3][1] = 1;

                map[4][0] = 4;
                map[4][1] = 1;

                map[5][0] = 5;
                map[5][1] = 1;

                map[6][0] = 3;
                map[6][1] = 2;

                map[7][0] = 4;
                map[7][1] = 2;

                map[8][0] = 5;
                map[8][1] = 2;
                break;
            }

            case 4:{
                map[0][0] = 3;
                map[0][1] = 3;

                map[1][0] = 4;
                map[1][1] = 3;

                map[2][0] = 5;
                map[2][1] = 3;

                map[3][0] = 3;
                map[3][1] = 4;

                map[4][0] = 4;
                map[4][1] = 4;

                map[5][0] = 5;
                map[5][1] = 4;

                map[6][0] = 3;
                map[6][1] = 5;

                map[7][0] = 4;
                map[7][1] = 5;

                map[8][0] = 5;
                map[8][1] = 5;
                break;
            }

            case 5:{
                map[0][0] = 3;
                map[0][1] = 6;

                map[1][0] = 4;
                map[1][1] = 6;

                map[2][0] = 5;
                map[2][1] = 6;

                map[3][0] = 3;
                map[3][1] = 7;

                map[4][0] = 4;
                map[4][1] = 7;

                map[5][0] = 5;
                map[5][1] = 7;

                map[6][0] = 3;
                map[6][1] = 8;

                map[7][0] = 4;
                map[7][1] = 8;

                map[8][0] = 5;
                map[8][1] = 8;
                break;
            }

            case 6:{
                map[0][0] = 6;
                map[0][1] = 0;

                map[1][0] = 7;
                map[1][1] = 0;

                map[2][0] = 8;
                map[2][1] = 0;

                map[3][0] = 6;
                map[3][1] = 1;

                map[4][0] = 7;
                map[4][1] = 1;

                map[5][0] = 8;
                map[5][1] = 1;

                map[6][0] = 6;
                map[6][1] = 2;

                map[7][0] = 7;
                map[7][1] = 2;

                map[8][0] = 8;
                map[8][1] = 2;
                break;
            }

            case 7:{
                map[0][0] = 6;
                map[0][1] = 3;

                map[1][0] = 7;
                map[1][1] = 3;

                map[2][0] = 8;
                map[2][1] = 3;

                map[3][0] = 6;
                map[3][1] = 4;

                map[4][0] = 7;
                map[4][1] = 4;

                map[5][0] = 8;
                map[5][1] = 4;

                map[6][0] = 6;
                map[6][1] = 5;

                map[7][0] = 7;
                map[7][1] = 5;

                map[8][0] = 8;
                map[8][1] = 5;
                break;
            }

            case 8:{
                map[0][0] = 6;
                map[0][1] = 6;

                map[1][0] = 7;
                map[1][1] = 6;

                map[2][0] = 8;
                map[2][1] = 6;

                map[3][0] = 6;
                map[3][1] = 7;

                map[4][0] = 7;
                map[4][1] = 7;

                map[5][0] = 8;
                map[5][1] = 7;

                map[6][0] = 6;
                map[6][1] = 8;

                map[7][0] = 7;
                map[7][1] = 8;

                map[8][0] = 8;
                map[8][1] = 8;
                break;
            }
            default:{}
        }

        for(int itr = 0; itr < 9; itr++) {
            if(grid.getBoolAt(map[itr][0],map[itr][1])){
                String kOnum = grid.getGridAt(map[itr][0],map[itr][1]);
                for (int iterator = 0; iterator < 9; iterator++) {
                    if(itr == iterator) {continue;}
                    kO[map[iterator][0]][map[iterator][1]] = kO[map[iterator][0]][map[iterator][1]].replace(kOnum, "");
                }
            }
        }
    }

    public void reduceCol(int row, int col){
        if(grid.getBoolAt(row,col)){
            String kOnum = grid.getGridAt(row, col);

            for(int i = 0; i < 9; i++) {
                kO[row][i] = kO[row][i].replace(kOnum, "");
            }
        }
    }

    public void reduceKO(int row, int col){
        try {
            reduceRow(row, col);
            reduceCol(row, col);

        } catch (Exception e){
            e.printStackTrace();
        }
        return;
    }

    public void reduceRow(int row, int col){
        if(grid.getBoolAt(row,col)){
            String kOnum = grid.getGridAt(row, col);

            for(int i = 0; i < 9; i++) {
                kO[i][col] = kO[i][col].replace(kOnum, "");
            }
        }
    }

    public void updateKO() 	{
        //Here we update the KOs.

        for ( int i = 0; i < 9; i++){
            for ( int j = 0; j < 9; j++){
                if(grid.getBoolAt(i, j)) {
                    kO[i][j] = grid.getGridAt(i, j);
                    kOdone[i][j] = true;
                }

                if(kO[i][j].length() < 2 || kOdone[i][j]) {
                    kOdone[i][j] = true;
                    grid.setBoolAtTrue(i, j);
                    grid.setGridAt(i, j, kO[i][j]);
                }
            }
        }
    }
}