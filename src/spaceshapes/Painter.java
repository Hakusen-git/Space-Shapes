package spaceshapes;


import java.awt.*;

/**
 * Interface to represent a type that offers primitive drawing methods.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public interface Painter {
	/**
	 * Draws a rectangle. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * Draws an oval. Parameters x and y specify the top left corner of the
	 * oval. Parameters width and height specify its width and height.
	 */
	public void drawOval(int x, int y, int width, int height);
	
	/**
	 * Draws a line. Parameters x1 and y1 specify the starting point of the 
	 * line, parameters x2 and y2 the ending point.
	 */
	public void drawLine(int x1, int y1, int x2, int y2);


	/**
	 *  Draws a filled rectangle. Parameters x and y specify the top left corner of the
	 * 	oval. Parameters width and height specify its width and height.
	 */
	public void fillRect(int x, int y, int width, int height);

	/**
	 * Set Color for the filled rectangle. The parameter is the color we want to set.
	 */
	public void setColor(Color color);

	/**
	 * Get Color of the shape. It returns the color object.
	 */
	public Color getColor();


	/**
	 * It translate the origin to the start point of the carrier shape.
	 * The parameter x and y is the start position of the parent carrier shape
	 */
	public void translate(int x, int y);

	/**
	 * It Draws a text at the center of a shape. The parameter x y is the start position of the shape
	 * width and height is the size of the shape. Text is the text we want to draw.
	 */
	public void drawCentredText(int x, int y, int width, int height, String text);

    public void drawImage(Image picture, int x, int y, int width, int height);
}
