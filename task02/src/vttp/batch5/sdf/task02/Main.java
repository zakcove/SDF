package vttp.batch5.sdf.task02;

public class Main {

	public static void main(String[] args) throws Exception {
		if (args.length <= 0) {
			System.err.println("Missing file");
			System.exit(1);
		}

		TicTacToe TTT = new TicTacToe(args[0]);
		TTT.readFile();
		TTT.printBoard();

	}
}
