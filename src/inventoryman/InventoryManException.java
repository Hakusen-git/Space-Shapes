package inventoryman;

@SuppressWarnings("serial")

/*
 * A custom exception class that will help handle checked exceptions
 */
public class InventoryManException extends Exception {
	public InventoryManException(String msg){
        super(msg);
    }

}
