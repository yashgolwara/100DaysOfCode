package day013;

import java.util.Arrays;

public class BoatsToSavePeople {
	// Time Complexity: O(NlogN)
	// Space Complexity: O(N)
	public int numRescueBoats(int[] people, int limit) {

		Arrays.sort(people);

		int totalBoats = 0;
		int lightPersonIndex = 0;
		int heaviestPersonIndex = people.length - 1;
		while (lightPersonIndex <= heaviestPersonIndex) {
			totalBoats++;
			if (people[lightPersonIndex] + people[heaviestPersonIndex] <= limit) {
				lightPersonIndex++;
			}
			heaviestPersonIndex--;
		}
		return totalBoats;
	}
}
