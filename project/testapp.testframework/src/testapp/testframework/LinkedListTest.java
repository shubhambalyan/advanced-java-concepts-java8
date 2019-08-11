package testapp.testframework;

import in.conceptarchitect.collections.LinkedList;
import in.conceptarchitect.unittest.TestMethod;

import static in.conceptarchitect.unittest.Assertions.*;

public class LinkedListTest {

	LinkedList<Integer> list;
	int count;
	public void init() {
		list=new LinkedList<>();
		list.addAll(10,20,30,40,50);
		count=list.size();
	}
	
	//success
	@TestMethod
	public void addedItemIsAddedAtTheEnd() {
		list.add(100);
		shouldBeEqual(count+1, list.size());
		shouldBeEqual(100, list.get(count));
		
		
	}
	
	
	public void testNewItemIsAddedAtTheBegining() {
		list.add(100);
		shouldBeEqual(100,list.get(0));
	}
	
	//not called
	@TestMethod
	public void atestToCheckNewItemIsAddedAtTheBegining() {
		list.add(100);
		shouldBeEqual(100,list.get(0));
	}
	//success
	@TestMethod
	public void testInvalidIndexShouldThrowIndexOutOfRange() {
		
		shouldThrow(IndexOutOfBoundsException.class, ()->{
			
			list.get(100);
			
		});
		
	}

	//error case
	@TestMethod
	public void testInvalidIndexShouldReturnNull() {
		
		Object result=list.get(100);
		shouldBeNull(result);
		
	}

}
