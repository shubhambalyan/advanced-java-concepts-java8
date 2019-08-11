package in.conceptarchitect.collections;

import java.util.function.BinaryOperator;

public interface IndexedList<E> extends Container<E>{

	Container<E> add(E value);
	E get(int pos);
	IndexedList<E> set(int pos, E value);
	int size();
	
	default void forEach(Action<E> action){
		for(int i=0;i<size();i++)
			action.actOn(get(i));
	}
	
	default <Output> Output each(ReturnableAction<E,Output> action) {
		for(int i=0;i<size();i++) {
			action.actOn(get(i));
		}
		
		return action.result();
	}
	
	
	public static <E> LinkedList<E> createList(E ... values){
		LinkedList<E> newList=new LinkedList<>();
		
		newList.addAll(values);
		
		return newList;
	}
	
	public static <E> GenericArray<E> createArray(int size,E ... values){
		GenericArray<E> array=new GenericArray<E>(size);
		array.addAll(values);
		return array;
	}
	
	
	default E reduce(E start, BinaryOperator<E> reducer) {
		
		for(int i=0;i<size();i++) {
			start=reducer.apply(start, get(i));
		}
		
		return start;
	}
	
	
}
