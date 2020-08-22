package inventoryman;

import java.util.Comparator;


/*
 * Item class that represents a single item from the library
 */
abstract public class Item {
	private String _title;
	private String _acquisitionDate;
	private String _owner;
	private String _cost;
	private String _format;



	public Item(String title, String acquisitionDateStr, String owner, String costStr, String formatStr) throws InventoryManException{
		FormatChecker itemChecker = new FormatChecker(acquisitionDateStr, costStr);
		String validation = itemChecker.formatCheck();
		if(!validation.equals("Success")) {
			throw new InventoryManException(validation);
		}
		_title = title;
		_acquisitionDate = acquisitionDateStr;
		_owner = owner;
		_cost = costStr;
		_format = formatStr;
	}

	public Boolean findByYear(String year){
		return _acquisitionDate.contains(year);
	}


	abstract String getCreator();
	
	// Four getter methods to provide information from the object
	public String getOwner() {
		return _owner + ": ";
	}
	
	public String getTitle() {
		return _title;
	}
	
	public String getFormat() {
		return "(" + _format + ")";
	}
	
	public String itemFormat() {
		return  _format + ", " + _owner + ", " + _acquisitionDate + ", " + _cost;
	}

	abstract String formatting();

	public Boolean findItem(String artist, String title, String format) {
		if(artist.equals(this.getCreator()) && title.equals(_title) && format.equals(_format)){
			return true;
		}

		return false;
	}

	abstract String reportFormatting();

	// In order to respect the encapsulation, Comparator is implemented as anonymous inner class  
	public Comparator<Item> itemComparator(String order) throws InventoryManException {
		Order e = Order.valueOf(order);

		switch(e){
			case Creator:
				return new Comparator<Item>() {
					public int compare(Item i1, Item i2) {
						return i1.getCreator().compareTo(i2.getCreator());
					}
				};

			case Title:
				return new Comparator<Item>() {
					public int compare(Item i1, Item i2) {
						return i1._title.compareTo(i2._title);
					}
				};

			case Acquisition:
				return new Comparator<Item>() {
					public int compare(Item i1, Item i2) {
						return i1._acquisitionDate.compareTo(i2._acquisitionDate);
					}
				};

			case Report:
				return new Comparator<Item>() {
					public int compare(Item i1, Item i2) {
						int compareOwner = i1._owner.compareTo(i2._owner);

						if(compareOwner != 0){
							return compareOwner;
						}

						if(i1 instanceof Book && i2 instanceof Music){
							return -1;
						}
						else if(i1 instanceof Music && i2 instanceof Book){
							return 1;
						}

						int compareCreator = i1.getCreator().compareTo(i2.getCreator());

						if(compareCreator != 0){
							return compareCreator;
						}

						int compareTitle = i1._title.compareTo(i2._title);
						return compareTitle;


					}
				};

			default:
				throw new InventoryManException("Invalid order"); //In fact will not be reached
		}
	}
	
	



}
