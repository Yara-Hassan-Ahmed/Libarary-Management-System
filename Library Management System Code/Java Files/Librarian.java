package LibraryManagementSystem;

public class Librarian extends Person {

	private int workID;
	
	public Librarian() {}
	
	public Librarian (String fullName,double age,int workID){
		
		super(fullName,age);
		this.workID=workID;
		
	}

	public int getWorkID() {
		return workID;
	}

	public void setWorkID(int workID) {
		this.workID = workID;
	}

	@Override
	public String toString(){
		
		return " librarian's name is: "+getFullName()
                        +"\n age: "+getAge()
                        +"\n work ID: "+getWorkID();
		
	}
}
