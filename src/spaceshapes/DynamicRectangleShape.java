package spaceshapes;


import java.awt.Color;

/**
 * A sub class of Shape to represent the  concept of a Dynamic Shape. It changes
 * color when it hit left and right wall.
 * This class defines the functionality of a DynamicShape.
 */

public class DynamicRectangleShape extends Shape {

    // DEFAULT COLOR OF THIS DYNAMIC SHAPE
    protected static final Color DEFAULT_COLOR = Color.white;


    private Color _color;

    /**
     * Default constructor that creates a DynamicShape instance whose instance
     * variables are set to default values.
     */
    public DynamicRectangleShape(){
        super();
        _color = DEFAULT_COLOR;
    }

    /**
     * Creates a DynamicShape instance with specified values for instance
     * variables.
     * @param color
     */
    public DynamicRectangleShape(Color color){
        super();
        _color = color;
    }

    /**
     * Creates a DynamicShape instance with specified values for instance
     * variables.
     * @param x
     * @param y
     * @param deltaX
     * @param deltaY
     */
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY){
        super(x, y, deltaX, deltaY);
        _color = DEFAULT_COLOR;
    }

    /**
     * Creates a DynamicShape instance with specified values for instance
     * variables.
     * @param x
     * @param y
     * @param deltaX
     * @param deltaY
     * @param color
     */
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, Color color){
        super(x, y, deltaX, deltaY);
        _color = color;
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
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height){
        super(x,y,deltaX,deltaY,width,height);
        _color = DEFAULT_COLOR;
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
     * @param color
     */
    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, Color color){
        super(x,y,deltaX,deltaY,width,height);
        _color = color;
    }

    public DynamicRectangleShape(int x, int y, int deltaX, int deltaY, int width, int height, String changes_color, Color cyan) {
        super(x,y,deltaX,deltaY,width,height);
        super.addText(changes_color);
        _color = cyan;
    }


    /**
     * Paints this DynamicShape object using the supplied Painter object.
     * Draws filled rectangle when hit left or right walls
     * Draws normal rectangle when hit corners or up or bottom walls
     */
    protected void painter(Painter painter) {
        if(super._edge.equals("LEFT") || super._edge.equals("RIGHT")){
            Color current = painter.getColor();
            painter.setColor(_color);
            painter.fillRect(_x,_y,_width,_height);
            painter.setColor(current);
        } else{
            painter.drawRect(_x,_y,_width,_height);
        }
    }

}
