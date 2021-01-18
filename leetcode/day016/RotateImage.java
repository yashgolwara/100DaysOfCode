package day016;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix.length < 2) {
			return;
		}
		int n = matrix.length, m = matrix[0].length;
		for (int i = 0; i < (n + 1) / 2; i++) {
			for (int j = 0; j < m / 2; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - j - 1][i] = matrix[n - i - 1][m - j - 1];
				matrix[n - i - 1][m - j - 1] = matrix[j][m - i - 1];
				matrix[j][m - i - 1] = tmp;
			}
		}
	}
}
