package test.streams;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class IOStreamTests {

	@Test
	public void testDirectoryApi() throws IOException, URISyntaxException {

		Files
			.list(Paths.get(new URI("file:///temp")))
			.filter(p->p.toString().endsWith(".xml"))
			.forEach(System.out::println);
		
		
	}
	
	@Test
	public void testFileApi() throws IOException {
		String path="/temp/books.xml";
		
		List<?> values=Files
						.lines(Paths.get(path))
						.collect(Collectors.toList());
		
		System.out.println(values.size());
		
		
		
	}
}
