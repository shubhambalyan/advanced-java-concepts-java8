package in.conceptarchitect.collections;

public class AverageFinder<E extends Number> implements ReturnableAction<E, Double> {

	double sum=0;
	double count=0;
	
	@Override
	public void actOn(E value) {
		
		sum += value.doubleValue();
		count++;
	}
	
	public double average() {
		return sum/count;
	}
	
	public Double result() {
		return average();
	}
	
}