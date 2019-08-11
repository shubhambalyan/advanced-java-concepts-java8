package test.streams;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class PrimeRange implements Iterable<Integer>{

	int min,max;

	public PrimeRange(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new PrimeIterator();
	};
	
	public Stream<Integer> stream(){
		return StreamSupport.stream(this.spliterator(),false);
	}
	
	
	
	class PrimeIterator implements Iterator<Integer>{

		int prime=min-1;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(prime>=max) return false;
			
			do {
				prime++;
				
			}while(!PrimeUtils.isPrime(prime));
			
			
			
			return prime<max;
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			return prime;
		}
		
	}
	
	
}
