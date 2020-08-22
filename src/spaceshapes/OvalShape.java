package spaceshapes;

/**
 * A sub class of Shape to represent the concept of a Oval Shape. It looks like a Oval.
 * This class defines the functionality of a OvalShape.
 */

public class OvalShape extends Shape{
    /**
     * Default constructor that creates a RectangleShape instance whose instance
     * variables are set to default values.
     */
    public OvalShape() { super(); }

    /**
     * Creates a DynamicShape instance with specified values for instance
     * variables.
     * @param x
     * @param y
     */
    public OvalShape(int x, int y) { super(x,y); }

    /**
     * Creates a DynamicShape instance with specified values for instance
     * variables.
     * @param x
     * @param y
     * @param deltaX
     * @param deltaY
     */
    public OvalShape(int x, int y, int deltaX, int deltaY) {
        super(x, y, deltaX, deltaY);
    }

    /**
     * Creates a DynamicShape instance with specified values for instance
     * variables.
     * @param x
     * @param y
     * @param deltaX
     * @param deltaY
     * @param width
     * @param height
     */
    public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height){
        super(x,y,deltaX,deltaY,width,height);
    }

    public OvalShape(int x, int y, int deltaX, int deltaY, int width, int height, String text){
        super(x,y,deltaX,deltaY,width,height);
        super.addText(text);
    }

    /**
     * Paints this OvalShape object using the supplied Painter object.
     */
    protected void painter(Painter painter) {
        painter.drawOval(_x,_y,_width,_height);
    }


}
