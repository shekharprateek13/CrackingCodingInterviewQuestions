package dsalgoproblems.project.streams;

public class Employee {

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

	@Override
	public String toString() {
		return "{name:" + name + ", age:" + age + "}";
	}
}
