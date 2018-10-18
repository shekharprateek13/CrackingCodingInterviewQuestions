package project.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author akhauri shekhar
 */
public class JavaStreamsPractice1 {

	static class Employee{
		private String name;
		private int age;
		
		Employee(){}
		Employee(String name, int age){
			this.name = name;
			this.age = age;
		}
		
		public String getName() {
			return this.name;
		}
		
		public int getAge() {
			return this.age;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
	}

	public static void main(String[] args) {
		Function<Employee, String> funcEmpToString= (Employee e) -> { return e.getName(); };
		List<Employee> employeeList =  
				Arrays.asList(
						new Employee("Tom Jones", 45), 
						new Employee("Harry Major", 25),
						new Employee("Ethan Hardy", 65),
						new Employee("Nancy Smith", 15),
						new Employee("Deborah Sprightly", 29)
						);

		Function<String,String> funcEmpToStringAndThen = (String s) -> { return s.substring(0,1);};
		
		List<String> empNameList=convertEmpListToNamesList(employeeList, funcEmpToString.andThen(funcEmpToStringAndThen));
		empNameList.forEach(System.out::print);
	}

	public static List<String> convertEmpListToNamesList(List<Employee> employeeList, Function<Employee, String> funcEmpToString) {
//		employeeList.stream().map(emp -> funcEmpToString.apply(emp)).forEach(empNameList::add);
//		System.out.println("\n\n");
//		System.out.println(empNameList);
//		System.out.println("\n\n");

		List<String> empNameList = new ArrayList<String>(); 
		for(Employee emp:employeeList) {
			empNameList.add(funcEmpToString.apply(emp));
		}
		return empNameList;
	}
}