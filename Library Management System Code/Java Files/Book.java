package LibraryManagementSystem;
public class Book {

	private String title;
	private String author; 
	private double price;
        private int BarCode;
	
	
	public Book() {}
	
	public Book(String title, String author,double price, int BarCode) {
		
		this.title=title;
		this.author=author;
		this.price=price;
                this.BarCode=BarCode;
		
	}

    public int getBarCode() {
        return BarCode;
    }

    public void setBarCode(int BarCode) {
        this.BarCode = BarCode;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

    @Override
    public String toString() {
        return "Book{" + "title=" + title 
                + ", author=" + author 
                + ", price=" + price 
                + ", BarCode=" + BarCode + '}';
    }

	
	
	
}
