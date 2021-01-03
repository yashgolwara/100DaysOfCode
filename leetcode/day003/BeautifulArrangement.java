package day003;

public class BeautifulArrangement {

	public int countArrangement(int n) {

		boolean[] visited = new boolean[n + 1];
		return process(1, visited);

	}

	private static int process(int start, boolean[] visited) {
		if (start == visited.length) {
			return 1;
		}
		int count = 0;
		for (int i = 1; i < visited.length; i++) {
			if (Boolean.FALSE.equals(visited[i]) && (start % i == 0 || i % start == 0)) {
				visited[i] = true;
				count += process(start + 1, visited);
				visited[i] = false;
			}
		}
		return count;
	}

}
