package LibraryManagementSystem;

public class Member extends Person {

	private String email;
	private String phoneNum;
        private int memberID;
	
	public Member(){}
	
	public Member (String fullName,double age,String email,String phoneNum,int memberID){
		
		super(fullName,age);
		this.email=email;
		this.phoneNum=phoneNum;
                this.memberID=memberID;
		
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "Member{" + "email=" + email 
                + ", phoneNum=" + phoneNum 
                + ", memberID=" + memberID + '}';
    }
    

}
