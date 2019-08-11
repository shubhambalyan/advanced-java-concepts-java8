package test.streams;

public class PrimeUtils {

	public static boolean isPrime(int n) {
		// TODO Auto-generated method stub
		n=Math.abs(n);
		if(n<2)
			return false;
		
		for(int i=2;i<n;i++)
			if(n%i==0)
				return false;
		
		return true;
	}

}
