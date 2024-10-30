package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class TicTacToe {

    private char[][] board;
    private char Player;

    private String boardFile;

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '.';
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2)
                    System.out.print(" . ");
            }
            System.out.println();
            if (i < 2)
                System.out.println("---------");
        }
    }

    public void readFile() throws Exception {

      Reader fis = new FileReader(boardFile);
      BufferedReader br = new BufferedReader(fis);
      String line;


}
}