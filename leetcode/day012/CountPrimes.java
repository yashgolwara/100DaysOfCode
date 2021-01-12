package day012;

public class CountPrimes {
	// implementation of Sieve of Eratosthenes.
	public int countPrimes(int n) {
		if (n <= 2)
			return 0;

		// init an array to track prime numbers
		boolean[] primes = new boolean[n];
		for (int i = 2; i < n; i++)
			primes[i] = true;

		//We can stop the loop at the square root of 'n'
	    //This is because the numbers greater than this square root
	    //will only have multiples that are greater than 'n'
		for (int i = 2; i <= Math.sqrt(n - 1); i++) {
			if (primes[i]) {
				for (int j = i + i; j < n; j += i)
					primes[j] = false;
			}
		}

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (primes[i])
				count++;
		}

		return count;
	}
}
