package inventoryman;

import java.util.List;

/*
 * Main InventoryMan class that implements the InventoryMan API and handle main operations
 */

public class InventoryManImpl implements InventoryMan {

	private String _flatName;
	private ItemLog _items;
	public InventoryManImpl(String flatName) {
			_flatName = flatName;
			_items = new ItemLog();
		}
	
	/*
	 * Two add methods that add items(Music and Book) into the ItemLog
	 * Exception from the item constructor will be caught here
	 */
	
	public String addBook(String author, String title, String publicationYear, String publisher,
			String acquisitionDateStr, String owner, String costStr, String formatStr) {
		try {
			Item book = new Book ( author,  title,  publicationYear,  publisher, acquisitionDateStr,  owner,  costStr,  formatStr);
			_items.add(book);
			return "Success";
		}catch(InventoryManException e) {
			System.out.println(e.getMessage());
			return "ERROR: " + e.getMessage(); 
		}
	}
		
	@Override
	public String addMusic(String artist, String title, String releaseDateStr, String acquisitionDateStr, 
			String owner, String costStr, String formatStr) {
		try {
			Item music = new Music(artist, title, releaseDateStr, acquisitionDateStr, owner, costStr, formatStr);
			_items.add(music);
			return "Success";
		} catch(InventoryManException e) {
			System.out.println(e.getMessage());
			return "ERROR :" + e.getMessage();
		}
	}
	
	/*
	 * Search through the ItemLog and display required information
	 */
	@Override
	public String getItemToDisplay(String creator, String title, String formatStr) {
		return _items.findItem( creator,  title,  formatStr);
	}

	/*
	 * Sort items in provided order and return a list of String containing sorted item information
	 */
	@Override
	public List<String> getAll(String order) {

		_items.sortItem(order);
		return _items.getAll();
	}

	/*
	 * Return a list of String containing item information from a specific year
	 */
	@Override
	public List<String> getItemsAcquiredInYear(String year) {
		_items.sortItem("Acquisition");

		return _items.findItemByYear(year);
	}

	/*
	 * return a list of String containing sorted item Creator information
	 */
	@Override
	public List<String> getCreators() {
		_items.sortItem("Creator");
		return _items.getCreators();
	}

	/*
	 * Generate the final report from the itemlog
	 */
	@Override
	public List<String> getFlatReport() {
		_items.sortItem("Report");

		return _items.createReport(this._flatName);


	}
	
	
	
	
}
