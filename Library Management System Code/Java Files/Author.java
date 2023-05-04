package LibraryManagementSystem;

public class Author extends Person implements AuthorInterface {

    private int authorID;

    public Author() {
    }

    public Author(String fullName, double age, int authorID) {

        super(fullName, age);
        this.authorID = authorID;
    }

    @Override
    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }

    @Override
    public String toString() {

        return " author's name is: " + getFullName() + "\n author's ID: " + authorID
                + "\n=============\n";

    }
}
