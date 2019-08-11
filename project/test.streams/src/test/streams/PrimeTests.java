package test.streams;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PrimeTests {

	@Before
	public void setUp() throws Exception {
	}

	@Test @Ignore
	public void testTimeTakenToFindPrimes() {
		
		System.out.println("Using PrimeFinder to find 1000th prime");
		long start=System.currentTimeMillis();
		List<Integer> primes= new PrimeFinder().primeRange(2, 500000); 
		long end=System.currentTimeMillis();
		System.out.println("Total Time Taken is "+(end-start)+" ms");
		System.out.println("Total Primes is "+primes.size());
		System.out.println("1000th prime is "+primes.get(999));
	}
	
	
	@Test
	public void testPrimeRangeIteration() {
		
		System.out.println("Using Prime Iterator to find 1000th prime");
		PrimeRange range=new PrimeRange(2,500000);
		int count=0;
		int prime1000=0;
		long start=System.currentTimeMillis();
		for(int prime : range) {
			count++;
			if(count==1000) {
				prime1000=prime;
				break;
			}
		}
		long end=System.currentTimeMillis();
		System.out.println("Total time taken is "+(end-start)+" ms");
		System.out.println("1000th prime is "+prime1000);
	}

	@Test
	public void testPrimeRangeStream() {
		
		System.out.println("Using Prime Stream to find 1000th prime");
		PrimeRange range=new PrimeRange(2,500000);
		
		long start=System.currentTimeMillis();
		
		int prime1000=range
						.stream()
						.skip(999)
						//.limit(1)
						.findFirst() //terminal operation return Optional
						.get();		//operation of Optional not on stream
		
		
		long end=System.currentTimeMillis();
		System.out.println("Total time taken is "+(end-start)+" ms");
		System.out.println("1000th prime is "+prime1000);
	}

	
	@Test
	public void testPrimeStream() {
		
		System.out.println("Using PrimeStream to find 1000th prime");
		PrimeStream range=new PrimeStream(2,1000);
		
		long start=System.currentTimeMillis();
		
		int prime1000=range
						.stream()
						.skip(999)
						
						.findFirst() //terminal operation return Optional
						.get();		//operation of Optional not on stream
		
		
		long end=System.currentTimeMillis();
		System.out.println("Total time taken is "+(end-start)+" ms");
		System.out.println("1000th prime is "+prime1000);
	}

	
	
	
	
	
	
}
