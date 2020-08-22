package spaceshapes;

/**
 * A sub class of Shape to represent the  concept of a Hexagon Shape. It looks like a Hexagon when it's
 * width is greater than 40, and looks like a diamond when it's less than 40.
 * This class defines the functionality of a HexagonShape.
 */

public class HexagonShape extends Shape{

    /**
     * Creates a HexagonShape object with default values for instance variables.
     */
    public HexagonShape(){
        super();
    }

    /**
     * Creates a HexagonShape instance with specified x, y
     * The HexagonShape object is created with a default deltaX, deltaY, width and height.
     */
    public HexagonShape(int x, int y){
        super(x,y);
    }

    /**
     * Creates a HexagonShape instance with specified x, y, deltaX and deltaY values.
     * The HexagonShape object is created with a default width and height.
     */
    public HexagonShape(int x, int y, int deltaX, int deltaY){
        super(x, y, deltaX, deltaY);
    }

    /**
     * Creates a HexagonShape instance with specified x, y, deltaX, deltaY, width and
     * height values.
     */
    public HexagonShape(int x, int y, int deltaX, int deltaY, int width, int height){
        super(x,y,deltaX,deltaY,width,height);
    }

    public HexagonShape(int x, int y, int deltaX, int deltaY, int width, int height, String s) {
        super(x,y,deltaX,deltaY,width,height);
        super.addText(s);
    }

    /**
     * Paints this HexagonShape object using the supplied Painter object and drawLine method.
     */
    protected void painter(Painter painter){
        if(super.width() >= 40) {
            painter.drawLine(super.x()+20, super.y(), super.x()+super.width()-20, super.y());
            painter.drawLine(super.x()+super.width()-20, super.y(), super.x()+super.width(), super.y() + super.height()/2);
            painter.drawLine(super.x()+super.width(), super.y() + super.height()/2, super.x()+super.width()-20, super.y()+super.height());
            painter.drawLine(super.x()+super.width()-20, super.y()+super.height(), super.x()+20, super.y()+super.height());
            painter.drawLine(super.x()+20, super.y()+super.height(), super.x(), super.y() + super.height()/2);
            painter.drawLine(super.x(), super.y() + super.height()/2, super.x()+20, super.y());
        } else{
            painter.drawLine(super.x()+super.width()/2, super.y(), super.x()+super.width(), super.y() + super.height()/2);
            painter.drawLine(super.x()+super.width(), super.y() + super.height()/2, super.x()+super.width()/2, super.y()+ super.height());
            painter.drawLine(super.x()+super.width()/2, super.y()+ super.height(), super.x(), super.y() + super.height()/2);
            painter.drawLine(super.x(), super.y() + super.height()/2, super.x()+super.width()/2, super.y());
        }
    }

}
