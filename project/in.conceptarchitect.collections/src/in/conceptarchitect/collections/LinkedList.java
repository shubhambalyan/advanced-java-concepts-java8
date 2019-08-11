package in.conceptarchitect.collections;

import java.util.Iterator;

public class LinkedList<X> implements IndexedList<X>, Iterable<X>{
	

	public static <E> LinkedList<E> create(E ... values){
		LinkedList<E> newList=new LinkedList<>();
		
		for(E value :values)
			newList.add(value);
		
		return newList;
	}
	
	
	 class Node {
		
		X value;
		Node next;
		Node previous;

	}
	
	private Node first;
	//optional but useful elements
	private Node last;
	private int count;
	private Node current;
	
	public Container<X> add(X value) {
		
		Node newNode=new Node();
		newNode.value=value;
		newNode.next=null;  //this is the last node
		newNode.previous=last; //current last will be its previous.
		
		if(count==0) //list is currently empty
			first=newNode; //this is also the first
		else
			last.next=newNode;
		
		last=newNode;
		count++;
		
		return this;
		
	}
	
	int currentIndex;
	
	private Node locate_v2(int pos) {
		if(pos==-1)
			return last;
		
		if(pos<0 || pos>=count)
			throw new IndexOutOfBoundsException("Invalid Index "+pos+" Should be in range [0-"+(count-1)+"]");
		
		if(pos==0)
			return first;
		
		if(pos==count-1)
			return last;
		
		//The 80% use case ---> one by one access
		if (current!=null && currentIndex+1==pos) {
			current=current.next;
			currentIndex++;
			return current;
		}
	
		//Direct access to nth index
		int deltaFirst= pos;
		int deltaLast= count-pos-1;
		int deltaCurrent=Math.abs(currentIndex-pos);
		int direction=1;
		int delta=0;
		Node node=null;
		
		if(current!=null && deltaCurrent<=deltaFirst && deltaCurrent<=deltaLast) {
			delta=deltaCurrent;
			direction = pos > currentIndex? 1 : -1;
			node=current;
			//System.out.print("+");
		}
		if(deltaFirst<=deltaLast && deltaFirst<=deltaCurrent) {
			//start from begining
			delta=deltaFirst;
			direction=1;
			node=first;
			//System.out.print("|<");
			
		} else if(deltaLast<=deltaFirst && deltaLast<=deltaCurrent) {
			//start from end
			delta=deltaLast;
			direction=-1;
			node=last;
			//System.out.print("|>");
		} 
		
		for(int i=0;i<delta;i++) {
			if(direction==1)
				node=node.next;
			else
				node=node.previous;
		}
		
		current=node;
		currentIndex=pos;
		return node;
	}
	
	
	private Node locate(int pos) {
		if(pos==-1)
			return last;
		
		if(pos<0 || pos>=count)
			throw new IndexOutOfBoundsException("Invalid Index "+pos+" Should be in range [0-"+(count-1)+"]");
		
		if(pos==0)
			return first;
		
		if(pos==count-1)
			return last;
		
		Node node=first;
		for(int i=0;i<pos;i++)
			node=node.next;
		
		return node;
	}
	
	public X get(int pos) {
		
		return  locate(pos).value;	
		
	}
	
	public IndexedList<X> set(int pos, X value) {
		
		locate(pos).value=value;
		return this;
	}
	
	public <O> O each(ReturnableAction<X,O> action) {
		//System.out.println("using specialized each for LinkedList");
		for(Node n=first; n!=null; n=n.next) {
			action.actOn(n.value);
		}
		
		return action.result();
	}
	
	
	public X remove(int pos) {
		
		Node delNode= locate(pos);
		
		if(delNode.previous!=null)
			delNode.previous.next=delNode.next;
		else
			first=delNode.next;
		
		if(delNode.next!=null)
			delNode.next.previous=delNode.previous;
		else
			last=delNode.previous;
		
		count--;
		current=delNode.next;
		
		return delNode.value;
		
	}
	
	
	public int size() {
		return count;
	}
	
	
	public String toString() {
		
		String str="LinkedList[\t";
		
		for(Node n=first;n!=null;n=n.next)
			str+=(n.value+"\t");
		
		str+="]";
		
		return str;
		
	}
	
	
	
	
	

	@Override
	public Iterator<X> iterator() {
		// TODO Auto-generated method stub
		return new MySimplerIterator();
	}

	class MySimplerIterator implements Iterator<X>{
		
		Node current=first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return  current!=null;
				   
		}

		@Override
		public X next() {
			// TODO Auto-generated method stub
			
			X value= current.value;
			current=current.next;
			
			
			return value;
			
		}

	}

	
	//static class E{}
	
	
	

}
