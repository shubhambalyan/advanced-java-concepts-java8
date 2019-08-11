package testapp.linkedlist2;

import in.conceptarchitect.collections.AverageFinder;
import in.conceptarchitect.collections.GenericArray;
import in.conceptarchitect.collections.IndexedList;
import in.conceptarchitect.collections.LinkedList;
import in.conceptarchitect.collections.StringLinkedList;

public class Program {

	public static void main(String[] args) {
		
		//LinkedList<Integer> numbers=new LinkedList<>();
		//GenericArray<Integer> numbers=new GenericArray<>(10);
		
		testList(new GenericArray<>(10),250000);
		
		testList(new GenericArray<>(1000),250000);
		
		testList(new LinkedList<>(), 250000);
		
		
		
		
	}
	
	static void testList(IndexedList<Integer> numbers,int size) {
		
		System.out.println("Testing "+numbers.getClass().getName());
		
		long start=System.currentTimeMillis();
		
		for(int i=1;i<=size;i++)
			numbers.add(i);
		
		long end=System.currentTimeMillis();
		
		System.out.println("Total time taken to add is "+(end-start)+" ms");
		
		
		start=System.currentTimeMillis();
		double result =numbers.each(new AverageFinder<>());
		end=System.currentTimeMillis();
		
		System.out.println("Total time taken to average values is "+(end-start)+" ms");
		
		System.out.println("average of items is "+result);
		
		System.out.println("---------\n\n");
		
		
	}
	
	static void testStringList() {
		// TODO Auto-generated method stub
		StringLinkedList list=new StringLinkedList();
		int count=50000;
		
		long start=System.currentTimeMillis();
		
		addItems(list,count);
		
		long end=System.currentTimeMillis();
		
		System.out.println("Total time taken to add is "+(end-start)+" ms");
		
		
		start=System.currentTimeMillis();
		long result=sumItems(list);
		//long result=list.total();
		end=System.currentTimeMillis();
		
		System.out.println("Total time taken to sum values is "+(end-start)+" ms");
		
		System.out.println("sum of items is "+result);
	}
	
	static void addItems(StringLinkedList list, int count) {
		for(int i=1;i<=count;i++) {
			list.add(""+i);
		}
	}
	
	
	static long sumItems(StringLinkedList list) {
		
		long sum=0;
		for(int i=0;i<list.size();i++) {
			
			sum+=Integer.parseInt(list.get(i));
			
		}
		
		return sum;
		
	}

}
