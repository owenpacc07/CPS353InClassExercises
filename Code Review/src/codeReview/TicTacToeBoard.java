package codeReview;
public class TicTacToeBoard {
	public static final char UNSET = '_';
	private char[][] board = new char[3][3];
	
	public TicTacToeBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = UNSET;
			}
		}
	}
	
	public boolean makeMove(int row, int column, char player) {
		if (isGameOver()) {
			System.out.println("The game is over!");
			return false;
		} else if (outOfBounds(row) || outOfBounds(column)) {
			System.out.println(row + " row and " + column + " col is an invalid move!");
			return false;
		} else if (board[row][column] != UNSET) {
			System.out.println("Someone already played there!");
			return false;
		} else {
			board[row][column] = player;
			return true;
		}
	}
	
	private boolean outOfBounds(int rowCol) {
		return rowCol < 0 || rowCol >= 3;
	}

	public boolean isGameOver() {
		if (getWinningPlayer() != UNSET) {
			return true;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == UNSET) {
					return false;
				}
			}
		}
		return true;
	}
	
	public char getWinningPlayer() {
		// rows
		for (int i = 0; i < 3; i++) {
			char player = board[i][0];
			boolean playerWon = (player != UNSET);
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != player) {
					playerWon = false;
				}
			}
			if (playerWon) {
				return player;
			}
		}
		
		// columns
		for (int j = 0; j < board[0].length; j++) {
			char player = board[0][j];
			boolean playerWon = (player != UNSET);
			for (int i = 0; i < 3; i++) {
				if (board[i][j] != player) {
					playerWon = false;
				}
			}
			if (playerWon) {
				return player;
			}
		}
		
		// diagonal
		char player = board[0][0];
		boolean playerWon = (player != UNSET);
		for (int rowCol = 0; rowCol < 3; rowCol++) {
			if (board[rowCol][rowCol] != player) {
				playerWon = false;
			}
		}
		if (playerWon) {
			return player;
		}
		
		// other diagonal
		player = board[0][2];
		playerWon = (player != UNSET);
		for (int rowCol = 0; rowCol < 3; rowCol++) {
			if (board[rowCol][2 - rowCol] != player) {
				playerWon = false;
			}
		}
		if (playerWon) {
			return player;
		}
		
		return UNSET;
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				result += board[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}
	
}
