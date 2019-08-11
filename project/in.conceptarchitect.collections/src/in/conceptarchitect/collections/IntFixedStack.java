package in.conceptarchitect.collections;

@Deprecated
public class IntFixedStack {

	int count=0;
	int size;
	//int lastItem;
	int [] items;
	
	public IntFixedStack(int size) {
		// TODO Auto-generated constructor stub
		if(size<=0)
			throw new InvalidArgumentException();
		
		this.size=size;
		items=new int [size];
	}

	public void push(int value) {
		// TODO Auto-generated method stub
		if(count==size)
			throw new StackOverFlowException(value);
		//lastItem=value;
		
		
		
		items[count]=value;
		
		count++;
	}

	public int pop() {
		// TODO Auto-generated method stub
		if(count==0)
			throw new StackUnderFlowException();
		count--;
		//return lastItem;
		return items[count];
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
	