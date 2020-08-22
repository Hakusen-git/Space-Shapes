package inventoryman;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatChecker  {
    private String _date;
    private String _cost;

    public FormatChecker(String date, String cost){
        _date = date;
        _cost = cost;
    }

    public String formatCheck()  {

        Pattern datePattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher dateMatcher = datePattern.matcher(_date);
        Pattern costPattern = Pattern.compile("\\$\\d+\\.\\d{2}");
        Matcher costMatcher = costPattern.matcher(_cost);
            
        if (!dateMatcher.matches() && !costMatcher.matches()) {
        	return "Invalid date and cost format";
        } else if (!dateMatcher.matches()) {
        	return "Invalid date format";
        } else if (!costMatcher.matches()) {
        	return "Invalid cost format";
        }
        return "Success";
           
    }


}
