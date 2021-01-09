package day009;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		if (!wordList.contains(endWord)) {
			return 0;
		}
		Queue<String> q = new LinkedList<>();
		int target = 1;
		q.add(beginWord);
		HashSet<String> hs = new HashSet<>();
		hs.add(beginWord);
		while (q.size() > 0) {
			target++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String word = q.remove();
				if (word.equals(endWord)) {
					return target;
				}
				int count = 0;
				for (int k = 0; k < word.length(); k++) {
					if (word.charAt(k) != endWord.charAt(k)) {
						count++;
					}
				}
				if (count == 1) {
					return target;
				}
				for (int j = 0; j < wordList.size(); j++) {
					int sum = 0;
					for (int k = 0; k < word.length(); k++) {
						if (word.charAt(k) != wordList.get(j).charAt(k)) {
							sum++;
						}
					}
					if (sum == 1) {
						if (!hs.contains(wordList.get(j))) {
							q.add(wordList.get(j));
							hs.add(wordList.get(j));
						}
					}
				}
			}
		}
		return 0;
	}

}
