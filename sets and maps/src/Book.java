
public class Book implements Cloneable{
	private String title;

	private int id;
	private Author author;
	public Book(String title, int id, Author author) {
		super();
		this.title = title;
		this.id = id;
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	protected Book deepClone() throws CloneNotSupportedException {
		Book toReturn = new Book(this.title,this.id,new Author(author.getName(),author.getAge()));
		
		
		return toReturn;
		
		
	}
	
	
}
