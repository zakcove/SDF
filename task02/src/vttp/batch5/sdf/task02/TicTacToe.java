package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    private char[][] board;

    public TicTacToe() {
        board = new char[3][3];
    }

    public void readFile(String f) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(f));
        for (int i = 0; i < 3; i++) {
            String line = reader.readLine();
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        reader.close();
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    public int minimax(char[][] board, char player) {
        if (checkWinner('X'))
            return -10;
        if (checkWinner('O'))
            return 10;
        if (isBoardFull())
            return 0;

        int optimal = (player == 'O') ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = player;
                    int score = minimax(board, (player == 'X') ? 'O' : 'X');
                    board[i][j] = '.';
                    optimal = (player == 'O') ? Math.max(score, optimal) : Math.min(score, optimal);
                }
            }
        }
        return optimal;
    }

    private List<int[]> getAvailableMoves(char[][] board) {
        List<int[]> availableMoves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '.') {
                    availableMoves.add(new int[] { i, j });
                }
            }
        }
        return availableMoves;
    }

    public void evaluateUtility() {
        List<int[]> availableMoves = getAvailableMoves(board);
        System.out.println("Board:");
        printBoard();
        System.out.println("-----------------------------------");
        for (int[] move : availableMoves) {
            board[move[0]][move[1]] = '.';
            int utility = minimax(board, 'O');
            board[move[0]][move[1]] = 'X';
            int displayUtility = (utility > 0) ? 1 : (utility < 0) ? -1 : 0;
            System.out.println("x=" + move[1] + ", " + "y=" + move[0] + ", " + "utility=" + displayUtility);
        }
    }
}