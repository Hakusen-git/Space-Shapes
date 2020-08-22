package spaceshapes;

import java.awt.*;

/**
 * Implementation of the Painter interface that does not actually do any
 * painting. A MockPainter implementation responds to Painter requests by
 * logging simply logging them. The contents of a MockPainter object's
 * log can be retrieved by a call to toString() on the MockPainter.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class MockPainter implements Painter {
	// Internal log.
	private StringBuffer _log = new StringBuffer();
	private Color _color = new Color(212, 212, 212);

	/**
	 * Returns the contents of this MockPainter's log.
	 */
	public String toString() {
		return _log.toString();
	}

	/**
	 * Logs the drawRect call.
	 */
	public void drawRect(int x, int y, int width, int height) {
		_log.append("(rectangle " + x + "," + y + "," + width + "," + height + ")");
	}
	
	/**
	 * Logs the drawOval call.
	 */
	public void drawOval(int x, int y, int width, int height) {
		_log.append("(oval " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the drawLine call.
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_log.append("(line " + x1 + "," + y1 + "," + x2 + "," + y2 + ")");
	}

	/**
	 * Logs the fillRect call.
	 */
	public void fillRect(int x, int y, int width, int height) {
		_log.append("(filledRectangle " + x + "," + y + "," + width + "," + height + ")");
	}

	/**
	 * Logs the setColor call.
	 */
	public void setColor(Color color) {
		_color = color;
		_log.append("(set color: " + color + ")");
	}

	/**
	 * Logs the getColor call.
	 */
	public Color getColor() {
		_log.append("(current color: " + _color + ")");
		return _color;
	}

	/**
	 * Logs the translate call.
	 */
	public void translate(int x, int y){

	}

	/**
	 * Logs the drawCentredText call.
	 */
	public void drawCentredText(int x, int y, int width, int height, String text){
		_log.append("(paint text: " + text + ")");
	}

	@Override
	public void drawImage(Image picture, int x, int y, int width, int height) {

	}


}