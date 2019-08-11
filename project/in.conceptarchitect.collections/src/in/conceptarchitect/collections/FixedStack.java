package in.conceptarchitect.collections;

public class FixedStack<T> {

	int count=0;
	int size;
	//int lastItem;
	Object [] items;
	
	public FixedStack(int size) {
		// TODO Auto-generated constructor stub
		if(size<=0)
			throw new InvalidArgumentException();
		
		this.size=size;
		items=new Object [size];  //java doesn't permit an array of Generic Type
	}

	public void push(T value) {
		// TODO Auto-generated method stub
		if(count==size)
			throw new StackOverFlowException(value);
		//lastItem=value;
		
		items[count]=value;
		
		count++;
	}

	public T pop() {
		// TODO Auto-generated method stub
		if(count==0)
			throw new StackUnderFlowException();
		count--;
		//return lastItem;
		return (T) items[count];
	}

	int size() {
		// TODO Auto-generated method stub
		return count;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count==0;
	}

	public boolean isFull() {
		// TODO Auto-generated method stub
		return count==size;
	}

}
	