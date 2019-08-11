package in.conceptarchitect.collections;

import java.util.Iterator;


@Deprecated
public class StringLinkedList implements Iterable<String>{
	
	class Node {
		
		String value;
		Node next;
		Node previous;

	}
	
	private Node first;
	//optional but useful elements
	private Node last;
	private int count;
	private Node current;
	
	public void add(String value) {
		
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
		
	}
	
	int currentIndex;
	private Node locate_0(int pos) {
		if(pos==-1)
			return last;
		if(pos<0 || pos>=count)
			throw new IndexOutOfBoundsException("Invalid Index "+pos+" Should be in range [0-"+(count-1)+"]");
		
		if(pos==count-1)
			return last;
		
		if(current!=null && pos==currentIndex+1) {
			current=current.next;
			currentIndex++;
			return current;
		}
			
		
		Node n=first;
		for(int i=0;i<pos;i++) {
			n=n.next;
		}
		
		current=n;
		currentIndex=pos;
		return n;
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
	
	public String get(int pos) {
		
		return  locate(pos).value;	
		
	}
	
	public void set(int pos, String value) {
		
		locate(pos).value=value;
	}
	
	public String remove(int pos) {
		
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
	
	
//	public long total() {
//		long sum=0;
//		for(Node n=first;n!=null;n=n.next) {
//			
//			sum+=Integer.parseInt(n.value);
//			
//		}
//		
//		return sum;
//	}

	@Override
	public Iterator<String> iterator() {
		// TODO Auto-generated method stub
		return new MySimplerIterator();
	}

	
	class MyIterator implements Iterator<String>{
		
		Node current=null;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return  current==null && first!=null  //traverse has not yet started 
					||
					current.next!=null ;  //traverse has started but there are places to visited.
				   
		}

		@Override
		public String next() {
			// TODO Auto-generated method stub
			
			if(current==null) //traverse has not started yet
				current=first;
			else 
				current=current.next;
			
			
			return current.value;
			
		}

	}


	class MySimplerIterator implements Iterator<String>{
		
		Node current=first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return  current!=null;
				   
		}

		@Override
		public String next() {
			// TODO Auto-generated method stub
			
			String value= current.value;
			current=current.next;
			
			
			return value;
			
		}

	}

	
	
	
	

}
