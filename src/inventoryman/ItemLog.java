package inventoryman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * Represent a list of items
 */

public class ItemLog {
    private List<Item> _items= new ArrayList<Item>();
    

    public void add(Item item){
        _items.add(item);
    }

    public List<String> getAll(){
        List<String> newItems = new ArrayList<String>();
        for (int i = 0; i < _items.size(); i++){
            newItems.add(_items.get(i).formatting());
        }
        return newItems;
    }

    public List<String> getCreators(){
        List<String> newItems = new ArrayList<String>();
        newItems.add(_items.get(0).getCreator());
        for(int i = 1; i < _items.size(); i++) {
            if(_items.get(i).getCreator() != _items.get(i-1).getCreator()) {
                newItems.add(_items.get(i).getCreator());
            }
        }
        return newItems;
    }

    public String findItem (String creator, String title, String formatStr) {
        for (int i = 0; i < _items.size(); i++) {
            if (_items.get(i).findItem(creator, title, formatStr)) {
                return _items.get(i).formatting();
            }
        }
        return "Can't find item";
    }

    public List<String> findItemByYear( String year ){
        List<String> newItems = new ArrayList<String>();
        for (int i = 0; i < _items.size(); i++){
            if(_items.get(i).findByYear(year)){
                newItems.add(_items.get(i).formatting());
            }
        }
        return newItems;
    }

    public void sortItem(String order) {
    	try {
        Collections.sort(_items, _items.get(0).itemComparator(order));
    	} catch(InventoryManException e) { //Exception from itemComparator method is caught here
    		System.out.println(e.getMessage());
    	}
    }

    public List<String> createReport(String flatName){
        List<String> report = new ArrayList<String>();
        report.add(flatName);
        for(int i=0; i < _items.size(); i++){
            report.add(_items.get(i).reportFormatting());
        }

        return report;

    }

}
