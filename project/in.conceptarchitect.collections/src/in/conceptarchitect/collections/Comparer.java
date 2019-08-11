package in.conceptarchitect.collections;

@FunctionalInterface
public interface Comparer<T> {

	int compare(T one, T two);
	
	//boolean areEqual(T one, T two);
	
	default boolean areEqual(T one, T two) {
		return this.compare(one, two)==0;
	}
}
