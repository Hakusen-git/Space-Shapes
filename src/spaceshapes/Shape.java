package spaceshapes;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Abstract superclass to represent the general concept of a Shape. This class
 * defines state common to all special kinds of Shape instances and implements
 * a common movement algorithm. Shape subclasses must override method paint()
 * to handle shape-specific painting.
 *
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public abstract class Shape {
	// === Constants for default values. ===
	protected static final int DEFAULT_X_POS = 0;
	
	protected static final int DEFAULT_Y_POS = 0;
	
	protected static final int DEFAULT_DELTA_X = 5;
	
	protected static final int DEFAULT_DELTA_Y = 5;
	
	protected static final int DEFAULT_HEIGHT = 35;

	protected static final int DEFAULT_WIDTH = 25;

	// ===

	// === Instance variables, accessible by subclasses.
	protected int _x;

	protected int _y;

	protected int _deltaX;

	protected int _deltaY;

	protected int _width;

	protected int _height;

	protected CarrierShape _parent;

	protected String _text;

	protected String _edge = "NONE";
	// ===

	/**
	 * Creates a Shape object with default values for instance variables.
	 */
	public Shape() {
		this(DEFAULT_X_POS, DEFAULT_Y_POS, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape object with a specified x and y position.
	 */
	public Shape(int x, int y) {
		this(x, y, DEFAULT_DELTA_X, DEFAULT_DELTA_Y, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}
	
	/**
	 * Creates a Shape instance with specified x, y, deltaX and deltaY values.
	 * The Shape object is created with a default width and height.
	 */
	public Shape(int x, int y, int deltaX, int deltaY) {
		this(x, y, deltaX, deltaY, DEFAULT_WIDTH, DEFAULT_HEIGHT);
	}

	/**
	 * Creates a Shape instance with specified x, y, deltaX, deltaY, width and
	 * height values.
	 */
	public Shape(int x, int y, int deltaX, int deltaY, int width, int height) {
		_x = x;
		_y = y;
		_deltaX = deltaX;
		_deltaY = deltaY;
		_width = width;
		_height = height;
		_parent = null;
	}
	
	/**
	 * Moves this Shape object within the specified bounds. On hitting a 
	 * boundary the Shape instance bounces off and back into the two- 
	 * dimensional world.
	 * The _edge provides a help for DynamicShape to determine which wall it touches
	 * Due to this implementation the corners will not trigger color switch
	 * @param width - width of two-dimensional world.
	 * @param height - height of two-dimensional world.
	 */
	public void move(int width, int height) {
		int nextX = _x + _deltaX;
		int nextY = _y + _deltaY;

		if (nextX <= 0) {
			nextX = 0;
			_deltaX = -_deltaX;
			_edge = "LEFT";
		} else if (nextX + _width >= width) {
			nextX = width - _width;
			_deltaX = -_deltaX;
			_edge = "RIGHT";
		}

		if (nextY <= 0) {
			nextY = 0;
			_deltaY = -_deltaY;
			_edge = "UP";
		} else if (nextY + _height >= height) {
			nextY = height - _height;
			_deltaY = -_deltaY;
			_edge = "BOTTOM";
		}
		_x = nextX;
		_y = nextY;
	}

	/**
	 * Method that allows text to be pass into the shape that will be printed with the Shape itself.
	 * @param text
	 */
	public void addText(String text){
		_text = text;
	}

	/**
	 *  a template method for Shape hierarchy. It'll provide basic steps for all Shape objects.
	 *  Provides a way to handle painting text in Shape class and leave the rest to concrete classes
	 *  A demonstration of Template Method
	 */
	public final void paint(Painter painter){
		painter(painter);
		if(_text!=null){
			painter.drawCentredText(_x,_y,_width,_height,_text);
		}
	}
	/**
	 * Method to be implemented by concrete subclasses to handle subclass
	 * specific painting.
	 * @param painter the Painter object used for drawing.
	 */
	protected abstract void painter(Painter painter);

	/**
	 * set this shape's parent to a specified CarrierShape
	 */
	void setParent(CarrierShape shape){
		_parent = shape;
	}

	/**
	 * Returns an ordered list of Shape objects.
	 * The first item is the root CarrierShape of the containment hierarchy.
	 * The last item is the callee object. Any intermediate items are CarrierShapes that
	 * connect the root to the callee.
	 */
	public List<Shape> path(){
		List<Shape> path = new LinkedList<Shape>();
		path.add(this);
		CarrierShape parent = this._parent;
		while(parent!=null){
			path.add(parent);
			parent = parent._parent;
		}

		Collections.reverse(path);
		return path;
	}

	/**
	 * Returns this Shape object's x position.
	 */
	public int x() {
		return _x;
	}
	
	/**
	 * Returns this Shape object's y position.
	 */
	public int y() {
		return _y;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaX() {
		return _deltaX;
	}
	
	/**
	 * Returns this Shape object's speed and direction.
	 */
	public int deltaY() {
		return _deltaY;
	}
	
	/**
	 * Returns this Shape's width.
	 */
	public int width() {
		return _width;
	}
	
	/**
	 * Returns this Shape's height.
	 */
	public int height() {
		return _height;
	}
	
	/**
	 * Returns a String whose value is the fully qualified name of this class 
	 * of object. E.g., when called on a RectangleShape instance, this method 
	 * will return "spaceshapes.RectangleShape".
	 */
	public String toString() {
		return getClass().getName();
	}

	/**
	 * Returns this Shape's parent.
	 */
	public CarrierShape parent(){
		return _parent;
	}

    public String text(){
		return _text;
	}
}
