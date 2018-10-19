package dsalgoproblems.project.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author akhaurishekhar
 */
public class JavaStreamsPractice2 {

	public static void main(String[] args) {
		
//		IntStream.range(1,10).forEach(System.out::print);
//		System.out.println("\n\n");
//		IntStream.range(1, 10).skip(3).forEach(System.out::print);
//		IntStream.range(1, 10).sorted().forEach(System.out::println);
//		IntStream.range(1, 10).sorted().forEach(x -> System.out.print(x+"|"));
//		System.out.println("\n");
//		System.out.println(IntStream.range(1,10).sum());
//		Stream.of("Hello","Akhauri","there!!!").sorted(Collections.reverseOrder()).findFirst().ifPresent(System.out::println);
//		System.out.println("\n\n");
//		String[] names = {"Hello","Akhauri","there!"};
//		Arrays.stream(names).filter(x -> x.startsWith("t")).sorted().forEach(System.out::println);
		
//		Stream.of(new int[]{2,4,6,8,10})
//		.map(x -> x*x)
//		.average()
//		.ifPresent(System.out::println);
		
//		Arrays.stream(new int[]{2,4,6,8,10})
//		.map(x -> x*x)
//		.average()
//		.ifPresent(System.out::println);
		
//		Arrays.stream(new int[]{2,4,6,8,10})
//		.map(x -> x*x).average().ifPresent(System.out::println);
//		
//		List<String> list = Arrays.asList("Hello","Hi","World","Akhauri","Prateek");
//		list.stream().map(String::toLowerCase).filter(x -> x.startsWith("h")).forEach(System.out::println);
		
//		System.out.println(Arrays.asList("A,10.0,15.0","B,20.0,55.0","C","D,24.0","E,100.0,200.0").stream().map(s -> s.split(",")).filter(s -> s.length == 3).count());
		
//		Arrays.asList("A,10.0,15.0","B,20.0,55.0","C","D,24.0","E,100.0,200.0").stream().map(s -> s.split(",")).filter(s -> s.length == 3).count();
//		
//		Map<String,Integer> map = Arrays.asList("A,10,15.0","B,20,55.0","C","D,24","E,100,200.0").stream().map(s -> s.split(","))
//		.filter(s -> s.length == 3).filter(s -> Integer.parseInt(s[1]) > 15).collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
//		
//		for(String s: map.keySet()) {
//			System.out.println(s+"::"+map.get(s));
//		}
		System.out.println(Stream.of(1.0,2.0,3.0).reduce(0.0,(Double a, Double b) -> a+b));
		IntSummaryStatistics summary = IntStream.of(7,2,19,88,73,4,10).summaryStatistics();
		
		System.out.println(summary);
	}
}