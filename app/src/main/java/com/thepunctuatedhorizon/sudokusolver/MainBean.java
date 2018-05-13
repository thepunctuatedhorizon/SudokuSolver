package com.thepunctuatedhorizon.sudokusolver;

import android.widget.TextView;

import java.io.IOException;

//*******************************************************************
// Simple Java Sudoku solver
//*******************************************************************

// one class needs to have a main() method
public class MainBean
{

    // arguments are passed using the text field below this editor
    public String solveTheGrid(String passedBoard) {

        //TODO: Add some parsing

        String originalBoard = "002060010" +
                "013405006" +
                "004900003" +
                "060843501" +
                "800000007" +
                "501679020" +
                "100004700" +
                "400102350" +
                "090080100";

        String secondBoard = "400000320" +
                "085240907"+
                "001000004"+
                "000800090"+
                "006725100"+
                "040003000"+
                "800000700"+
                "609031850"+
                "023000001";

        String thirdBoard = "005860070" +
                "403000650" +
                "007500940" +
                "021000086" +
                "306000509" +
                "850000320" +
                "042001800" +
                "069000204" +
                "030029700";

        String solution = "982367415" +
                "713425986" +
                "654918273" +
                "267843591" +
                "849251637" +
                "531679824" +
                "128534769" +
                "476192358" +
                "395786142";

        Grid grid = new Grid(secondBoard);
        Grid gridSol = new Grid(solution);
        SolverEngine solver = new SolverEngine(grid);

        boolean done = false;

        do {
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                    solver.updateKO();
                    solver.reduceKO(i,j);
                    solver.checkForSingleKO(i, j);
                }
            }
            for (int i = 0; i < 9; i++) {
                solver.reduce3x3( i );
                solver.updateKO();
            }

            int numDone = 0;
            for (int i = 0; i < 9; i++){
                for (int j = 0; j < 9; j++){
                    if (solver.getBoolAt(i, j)) {
                        numDone++;
                    }
                }
            }

            if (numDone > 80) {
                done = true;
            }
        } while (!done);

        //System.out.print(grid + "\n");
        System.out.print(gridSol + "\n");
        return solver.printOutKOs();
    }
}



