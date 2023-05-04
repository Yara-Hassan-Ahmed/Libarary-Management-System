package LibraryManagementSystem;

abstract class Person {

	private String fullName;
	private double age;
	
	public Person(){}
	
	public Person(String fullName,double age){
		
		this.fullName=fullName;
		this.age=age;
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}
	public String toString(){
		return " personnel's name is: "+getFullName()
                        +"\n age: "+getAge();
		
	}}
