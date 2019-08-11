package in.conceptarchitect.collections;

public interface Container<E> {

	Container<E> add(E value);
	int size();
	
	default Container<E> addAll(E... values){
		for(E value :values)
			add(value);
		
		return this;
	}
	
	default boolean isEmpty() {
		return size()==0;
	}
	
	default Container<E> copyFrom(Container<E> other){
		
		other.each(this::add);
		return this;
		
	}
	
	<Output> Output each(ReturnableAction<E,Output> action) ;
}
