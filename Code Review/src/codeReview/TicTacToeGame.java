package codeReview;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {

	public static void main(String[] args) {
		char[] players = {'X', 'O'};
		
		TicTacToeBoard board = new TicTacToeBoard();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Let's play Tic Tac Toe!");
		
		int turn = 0;
		while (!board.isGameOver()) {
	    char currentPlayer = getPlayer(turn, players);
		System.out.println(board);
		System.out.println("Enter the row and column for player " + currentPlayer);
			
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		if (board.makeMove(row, col, currentPlayer)) {
			turn++;
		}
		}
		
		System.out.println(board);
		char winner = board.getWinningPlayer();
		if (winner != TicTacToeBoard.UNSET) {
			System.out.println("The winnr is " + winner);
		} else {
			System.out.println("It's a draw!");
		}
	}

	private static char getPlayer(int turn, char[] players) {
		return players[turn % players.length];
	}
}
