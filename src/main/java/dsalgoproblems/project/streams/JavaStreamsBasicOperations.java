package dsalgoproblems.project.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author akhauri shekhar
 */
public class JavaStreamsBasicOperations {

	public static void main(String[] args) {
		List<Employee> employeeList =  
				Arrays.asList(
						new Employee("Tom Jones Mitchell Bright", 45), 
						new Employee("Harry Major", 25),
						new Employee("Ethan Hardy", 65),
						new Employee("Nancy Smith", 15),
						new Employee("Deborah Sprightly", 29)
						);

		//Prints out the Maximum length of Employee's Name
		printLongestEmployeeNameLength(employeeList);	

		//Prints out the Minimum length of Employee's Name
		printShortestEmployeeNameLength(employeeList);

	}

	public static void printShortestEmployeeNameLength(List<Employee> employeeList) {
		Supplier<Stream<String>> employeeListSupplier = ()  -> { 
			return employeeList.stream().map(s -> String.valueOf(s.getName().length()));
		};

		employeeListSupplier.get().mapToInt(Integer::parseInt).min().ifPresent(System.out::println);
		employeeListSupplier.get().sorted(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		}).findFirst().ifPresent(System.out::println);
	}

	public static void printLongestEmployeeNameLength(List<Employee> employeeList) {
		//Using Custom Comparator.....
		employeeList.stream().map( s -> s.getName().length()).sorted(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		}).findFirst().ifPresent(System.out::println);

		//Using Supplier.....
		Supplier<Stream<String>> employeeListSupplier = ()  -> { 
			return employeeList.stream().map(s -> String.valueOf(s.getName().length()));
		};

		employeeListSupplier.get().mapToInt(Integer::parseInt).max().ifPresent(System.out::println);
	}
}