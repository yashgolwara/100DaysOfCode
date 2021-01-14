package day014;

public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length <= 2 || board[0] == null || board[0].length <= 2) {
			return;
		}

		int rows = board.length;
		int cols = board[0].length;

		// Start from first and last column, turn 'O' to '*'
		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O') {
				infect(board, i, 0, rows, cols);
			}
			if (board[i][cols - 1] == 'O') {
				infect(board, i, cols - 1, rows, cols);
			}
		}

		// Start from first and last row, turn '0' to '*'
		for (int j = 0; j < cols; j++) {
			if (board[0][j] == 'O') {
				infect(board, 0, j, rows, cols);
			}
			if (board[rows - 1][j] == 'O') {
				infect(board, rows - 1, j, rows, cols);
			}
		}

		// post-prcessing, turn 'O' to 'X', '*' back to 'O', keep 'X' intact.
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == '*') {
					board[i][j] = 'O';
				} else if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
			}
		}
	}

	// Use DFS to turn boundary-connected 'O' to '*';
	private void infect(char[][] board, int i, int j, int rows, int cols) {
		if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != 'O') {
			return;
		}
		// Mark the explored island cells with '*'
		board[i][j] = '*';
		infect(board, i + 1, j, rows, cols);
		infect(board, i - 1, j, rows, cols);
		infect(board, i, j + 1, rows, cols);
		infect(board, i, j - 1, rows, cols);
	}
}
