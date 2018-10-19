package dsalgoproblems.programs.java.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Streams1 {

	public static void main(String...args){

//		//Code creates a Collection..
//		Arrays.asList("a1","a2","a3").stream().findFirst().ifPresent(System.out::print);
//
//		//Code does not create a Collection..
//		Stream.of("a1","a2","a3").findFirst().ifPresent(System.out::print);
//
//		System.out.println();
//
//		//		IntStream.range(1,100).filter( x -> x%2 == 0).
//
//		System.out.println();
		List<String> list = new ArrayList<String>();
//		list.stream().no
		
		
		Stream.of("d2", "a2", "b1", "a3", "c")
		.map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> {
			System.out.println("anyMatch: " + s);
			return s.startsWith("A");
		});
	}
}