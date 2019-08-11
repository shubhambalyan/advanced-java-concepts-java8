package in.conceptarchitect.collections;

//@FunctionalInterface
public interface Action<I> {

	/**
	 * Act on each provided item one by one
	 * @param value
	 */
	void actOn(I value);
	
}
