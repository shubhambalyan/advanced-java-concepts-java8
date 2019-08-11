package test.streams;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinder {

	public List<Integer> primeRange(int min,int max) {
		
		List<Integer> list=new ArrayList<>();
		for(int i=min;i<max;i++) {
			if(PrimeUtils.isPrime(i))
				list.add(i);
		}
		
		return list;
		
		
	}

}
