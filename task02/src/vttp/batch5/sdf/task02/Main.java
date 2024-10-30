package vttp.batch5.sdf.task02;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		String boardFile = args[0];
		TicTacToe run = new TicTacToe();
        run.readFile(boardFile);
        run.evaluateUtility();
       
    }
}