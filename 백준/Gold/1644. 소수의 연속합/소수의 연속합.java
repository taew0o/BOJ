import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.println(0);
			return;
		}

		List<Integer> primes = getPrimes(N);

		int start = 0;
		int end = 0;
		int sum = primes.get(0);
		int count = 0;

		while (true) {
			if (sum == N)
				count++;

			if (sum <= N) {
				if (end == primes.size() - 1) break;
				sum += primes.get(++end);
			} 
			else if (sum > N) {
				sum -= primes.get(start++);
			}	
		}

		System.out.println(count);
	}

	private static List<Integer> getPrimes(int n) {

		List<Integer> list = new ArrayList<>();

		boolean[] prime = new boolean[n + 1];
		for (int i = 2; i <= n; i++)
			prime[i] = true;

		for (int i = 2; i * i <= n; i++) {
			if (!prime[i]) continue;

			for (int j = i * 2; j <= n; j += i)
				prime[j] = false;
		}

		for (int i = 2; i <= n; i++)
			if (prime[i])
				list.add(i);

		return list;
	}
}