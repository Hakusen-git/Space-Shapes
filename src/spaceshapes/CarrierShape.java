package spaceshapes;

import java.util.ArrayList;
import java.util.List;

/**
 * A sub class of Shape to represent the general concept of a CarrierShape. This class
 * defines unique functionality of CarrierShape such as movement for all children and paint
 * for all children
 *
 * It has a composition relation with Shape
 */
public class CarrierShape extends Shape{

    // A list of shapes to represent children of this CarrierShape
    private List<Shape> _shapes = new ArrayList<Shape>();

    /**
     * Creates a CarrierShape object with default values for instance variables.
     */
    public CarrierShape(){
        super();
    }

    /**
     * Creates a CarrierShape object with a specified x and y position.
     */
    public CarrierShape(int x, int y){
        super(x,y);
    }

    /**
     * Creates a CarrierShape instance with specified x, y, deltaX and deltaY values.
     * The CarrierShape object is created with a default width and height.
     */
    public CarrierShape(int x, int y, int deltaX, int deltaY){
        super(x,y,deltaX,deltaY);
    }


    /**
     * Creates a CarrierShape instance with specified x, y, deltaX, deltaY, width and
     * height values.
     */
    public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height){
        super(x,y,deltaX,deltaY,width,height);
    }

    public CarrierShape(int x, int y, int deltaX, int deltaY, int width, int height, String text){
        super(x,y,deltaX,deltaY,width,height);
        super.addText(text);
    }

    /**
     * Moves a CarrierShape and its child within the specific bound specified by input width and height
     */
    public void move(int width, int height){
        super.move(width,height);
        int subWidth = this._width;
        int subHeight = this._height;
        for(Shape shape: _shapes){
            shape.move(subWidth, subHeight);
        }

    }

    /**
     * Paint CarrierShape by drawing a rectangle around the edge of
     * its bounding box. The CarrierShape object’s children are then painted.
     */
    protected void painter(Painter painter){
        painter.drawRect(_x, _y, _width, _height);

        painter.translate(_x,_y);
        for(Shape shape: _shapes){
            shape.paint(painter);
        }
        painter.translate(-_x,-_y);
    }

    /**
     * Attempts to add a Shape to a CarrierShape object. If successful,
     * a two-way link is established between the CarrierShape and the
     * newly added Shape.
     * @param shape the shape to be added
     * @throws IllegalArgumentException if an attempt is made to add a Shape to
     * a CarrierShape instance where the Shape argument is already a child within
     * a CarrierShape instance. An IllegalArgumentException is also thrown when an attempt
     * is made to add a Shape that will not fit within the bounds of the proposed CarrierShape object
     */
    void add(Shape shape) throws IllegalArgumentException{
        if(shape.parent()!=null || shape.height() + shape.y() >= this.height() || shape.width() + shape.x() >=this.width()){
            throw new IllegalArgumentException();
        } else{
            _shapes.add(shape);
            shape._parent = this;
        }
    }

    /**
     * Removes a particular Shape from a CarrierShape instance.
     * @param shape
     */
    void remove(Shape shape){
        _shapes.remove(shape);
        shape.setParent(null);
    }

    /**
     * Returns the Shape at a specified position within a CarrierShape/
     * If the index is invalid then throws a IndexOutOfBoundsException
     */
    public Shape shapeAt(int index) throws IndexOutOfBoundsException{
        return _shapes.get(index);
    }

    /**
     * Returns the number of children contained within a CarrierShape object.
     */
    public int shapeCount(){
        return _shapes.size();
    }

    /**
     * Returns the index of a specified child within a CarrierShape object.
     * If the Shape is not a child of the CarrierShape, return -1
     */
    public int indexOf(Shape shape){
        if(_shapes.contains(shape)) {
            return _shapes.indexOf(shape);
        } else{
            return -1;
        }
    }

    /**
     * Return true if the Shape is a child of the CarrierShape, false otherwise.
     */
    public boolean contains(Shape shape){
        return _shapes.contains(shape);
    }

    public int length(){
        return _shapes.size();
    }



}
