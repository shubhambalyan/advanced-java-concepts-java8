package test.streams;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import in.conceptarchitect.collections.AverageFinder;


public class StreamTests {

	Stream<Integer> stream;
	
	@Before
	public void setUp() throws Exception {
		
		stream= Stream.of(2,3,9,5,2,8,1,13,15,4,3,21,24,29,31,47,45,22);
	}


	
	@Test
	public void main_canUseForEach() {
		
		System.out.println("main_canUseForEach");
		//stream.forEach(value -> System.out.print(value+"\t"));
		
		stream.forEach(System.out::println);
		
		System.out.println();
	}

	
	@Test
	public void canCountMembersInStream() {
		long size= stream.count();
		assertEquals(18,size);
		
	}
	
	@Test
	public void canAverageUsingForEach() {
		AverageFinder<Integer> finder=new AverageFinder<>();
		
		stream.forEach(finder::actOn);
		
		assertEquals(15.777, finder.result(),0.001);
	}
	
	
	@Test
	public void canSumUsingReduce() {
		int sum=stream.reduce(0, (n1,n2)->n1+n2 );
		
		assertEquals(284,sum);
	}

	@Test
	public void canFilterEvenNumbers() {
		
		long result=stream
						.filter(value->value%2==0)
						.count();
		
		assertEquals(6,result);
		
	}
	
	@Test
	public void main_testMultipleOperators() {
		
		System.out.println("print all numbers divisible by 3 and 5");
		stream
			.filter(n->n%3==0)
			.filter(n->n%5==0)
			.forEach(System.out::println);
			
		
	}
	
	@Test
	public void test_collector() {
		
		List<Integer> result=stream
								.collect(Collectors.toList());
		
		assertEquals(18,result.size());
	}
	
	@Test
	public void testSkipAndLimit() {
		
		List<Integer> result= stream
								.filter(n->n%2!=0)
								.skip(3)
								.filter(n->n%2!=0)
								.limit(5)
								.collect(Collectors.toList());
		
		assertEquals(5,result.size());
		assertEquals(1,(int)result.get(0));
		
	}
	
	class Prediction
	{
		int luckyNumber;
		String luck;
		@Override
		public String toString() {
			return "Prediction [luckyNumber=" + luckyNumber + ", luck=" + luck + "]";
		}
		public Prediction(int luckyNumber, String luck) {
			super();
			this.luckyNumber = luckyNumber;
			this.luck = luck;
		}
		
		
		
	}
	
	@Test
	public void mapCanChangeObjectType() {
		
		final String []predictions = {
							   "You have a great day",
							   "Success will be yours",
							   "Plan it Right",
							   "Look Before you Leap",
							   "Come Tomorrow"
							   };
		
		int s=predictions.length;
		List<?> result= 			stream
										.filter(n -> n>10) //take number greater than 10
										//.map(n-> n%s)
										.map( n -> new Prediction(n, predictions[n%s]))  //map to prediction
										//we have stream of prediction
										.map(p-> p.luck)  //now we get a stream of strings
										.limit(4) 
										//.map(str -> str.length())
										.collect(Collectors.toList());
		
		
		for(Object p : result)
			System.out.println(p);
		
		assertEquals(4,result.size());
		
		
		
		
	}

	class Counter{
		int count;
		public void increment() {count++;}
		public int  getCount() {return count;}
	}
	
	@Test
	public void main_streamIsNonFunctionalTillConnectedToATerminalConsumerOperation() {
		final Counter filter1Counter=new Counter();
		final Counter filter2Counter=new Counter();
		final Counter mapCounter=new Counter();
		
		Stream<?> s= stream
						.filter(n->{
							filter1Counter.increment();
							System.out.println("filtering for odds:"+n);
							return n%2!=0;
						}).
						filter(n->{
							filter2Counter.increment();
							System.out.println("filtering for >10:"+n);
							return n>10;
						})
						.limit(5)
						.map(n->{
							System.out.println("mapping *10:"+n);
							mapCounter.increment();
							return n*10;
						});
		
		
		System.out.println("Stream is created.");
		System.out.println("Stream doesn't work without a terminal operation");
		
		assertEquals(0,filter1Counter.getCount());
		assertEquals(0,filter2Counter.getCount());
		assertEquals(0,mapCounter.getCount());
						
	}

	@Test
	public void streamTerminalConsumerOperationTriggersIntermediateOperation() {
		final Counter filter1Counter=new Counter();
		final Counter filter2Counter=new Counter();
		final Counter mapCounter=new Counter();
		
		Stream<?> s= stream
						.filter(n->{
							filter1Counter.increment();
							System.out.println("filtering for odds:"+n);
							return n%2!=0;
						}).
						filter(n->{
							filter2Counter.increment();
							System.out.println("filtering for >10:"+n);
							return n>10;
						})
						.limit(5)
						.map(n->{
							System.out.println("mapping *10:"+n);
							mapCounter.increment();
							return n*10;
						});
		
		
		System.out.println("Stream is created.");
		System.out.println("Now attaching a terminal");
		
		s.count(); //this triggers stream operations
		
		assertEquals(15,filter1Counter.getCount());
		assertEquals(10,filter2Counter.getCount());
		assertEquals(5,mapCounter.getCount());
						
	}

	@Test
	public void main_BufferedOperation() {
		
		stream
			//.limit(5)
			.filter(n->{
				System.out.println("filter1(before distinct):"+n);
				return n>10;
			})
			.filter(n->{
				System.out.println("filter2(before distinct):"+n);
				return n%2!=0;
			})
			//.distinct()
			.sorted()
			.map(n->{
				System.out.println("filter 3(after distinct):"+n);
				return n;
			})
			.map(n->{
				System.out.println("filter 4(after distinct):"+n);
				return n;
			})
			.count();
			
			
			
	}
	
	@Test(expected=IllegalStateException.class)
	public void streamCanBeOperatedOnlyOnce() {
		
		long count=stream.count(); //stream is consumed and closed
		
		assertTrue(count>0);
		
		//invalid operation on a closed stream
		stream.forEach(System.out::println); 
	}
	
	
	@Test
	public void listToStream() {
		
		List<Integer> list= Arrays.asList(2,3,9,6);
		
		//every stream() call returns a new stream
		long count = list.stream().count();
		
		//it's a new stream from the same list
		list.stream().forEach(System.out::println);
		
	}
	
	
	
}
