package in.conceptarchitect.collections;

import java.util.Arrays;

public class GenericArray<E> implements IndexedList<E> {

	Object [] values;
	int count;
	int growSize; //by what size array will regrow
	
	
	
	public GenericArray(int growSize) {
		// TODO Auto-generated constructor stub
		values=new Object[growSize];
		this.growSize=growSize;
		this.count=0;
	}

	@Override
	public Container<E> add(E value) {
		// TODO Auto-generated method stub
		
		ensureCapacity();
		
		values[count]=value;
		count++;
		return this;
	}
	
	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if (count==values.length) {
			Object [] newArray= new Object [count+growSize];
			for(int i=0;i<values.length;i++)
				newArray[i]=values[i];
			
			values=newArray;				
		}
	}

	public int capacity() {
		return values.length;
	}

	@Override
	public E get(int pos) {
		// TODO Auto-generated method stub
		validateIndex(pos);
		return (E)values[pos];
	}

	private void validateIndex(int pos) {
		// TODO Auto-generated method stub
		if(pos<0 || pos>=count)
			throw new IndexOutOfBoundsException("Invalid Index"+pos);
	}

	@Override
	public IndexedList<E> set(int pos, E value) {
		// TODO Auto-generated method stub
		validateIndex(pos);
		values[pos]=value;
		return this;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	
	
	@Override
	public String toString() {
		if(count==0) return "DynamicArray (empty)";
		
		StringBuilder builder=new StringBuilder("DynamicArray ");
		if(count!=values.length)
			builder.append("(\t");
		else
			builder.append("[\t");
		
		for(int i=0;i<count;i++) {
			builder.append(values[i]+"\t");
		}
		
		
		if(count!=values.length)
			builder.append(")");
		else
			builder.append("]");
		
		return builder.toString();
	}

	
	
	
	
}
