package test.streams;

import java.util.stream.Stream;

public class PrimeStream {
	int min,max;
	int prime=min-1;
	public PrimeStream(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}
	
	int nextPrime() {
		do {
			prime++;
		
		}while(!PrimeUtils.isPrime(prime));
		
		return prime;
	}
	
	public Stream<Integer> stream() {

		return Stream
					.generate(this::nextPrime)
					.limit(max);
					
		
	}
}






