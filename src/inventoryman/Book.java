package inventoryman;


/*
 * Item class that represents a single book item from the library
 */

public class Book extends Item{
	private String _publicationYear;
	private String _publisher;
	private String _author;
	
	// Book constructor need to declare a Exception to be thrown because "super" constructor throws exception
	public Book (String author, String title, String publicationYear, String publisher,
			String acquisitionDateStr, String owner, String costStr, String formatStr) throws InventoryManException{
		super(title, acquisitionDateStr,  owner,  costStr,  formatStr);
		_publisher = publisher;
		_publicationYear = publicationYear;
		_author = author;
	}


	String getCreator() {
		return _author;
	}

	public String formatting() {
		String format = new String();
		format = _author + ", '" + super.getTitle() + "'. (" + _publicationYear  + ", " + _publisher + "). ["
				+ super.itemFormat() + "]";
		
		return format;
	}



	public String reportFormatting() {
		return super.getOwner()  + _author + ", '" + super.getTitle() + "'. " + super.getFormat();
	}

}
