package inventoryman;

/*
 * Item class that represents a single music item from the library
 */

public class Music extends Item {


	private String _releaseDate;
	private String _artist;

	
	// Music constructor need to declare a Exception to be thrown because "super" constructor throws exception
	public Music(String artist, String title, String releaseDateStr, String acquisitionDateStr,
				 String owner, String costStr, String formatStr) throws InventoryManException{
		super(title,  acquisitionDateStr, owner,  costStr,  formatStr);
		_artist = artist;
		_releaseDate = releaseDateStr;
	}

	public String getCreator() {
		return _artist;
	}

	public String formatting() {
		String format;
		format = "'" + super.getTitle() + "' by " + _artist + ", " + _releaseDate + ". (" + super.itemFormat() + ")";
		return format;
	}



	public String reportFormatting() {
		return super.getOwner() + "'" + super.getTitle() + "' by " + _artist + " " + super.getFormat();
	}


}
