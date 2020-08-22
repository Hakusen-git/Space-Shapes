package spaceshapes;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Before;
import org.junit.Test;


/**
 * Class to test class DynamicShape according to its specification.
 *
 */
public class TestDynamic {
    private MockPainter _painter;

    @Before
    public void setup() {
        _painter = new MockPainter();
    }

    /**
     * Test normal movement of DynamicShape.
     * Ensure that it doesn't paint filled Rectangle and position is correct
     */
    @Test
    public void testNormalMove() {
        DynamicRectangleShape shape = new DynamicRectangleShape(30,20,10,10);
        shape.paint(_painter);
        shape.move(1000,1000);
        shape.paint(_painter);
        shape.move(1000,1000);
        shape.paint(_painter);
        assertEquals("(rectangle 30,20,25,35)" +
                "(rectangle 40,30,25,35)(rectangle 50,40,25,35)", _painter.toString());
    }

    /**
     * Test when DynamicShape bounce off Left wall.
     * Ensure that it changes to fill rectangle after contact with the wall
     * and the getColor and setColor works fine
     * Every time after a color is paint it'll be set back to original color
     */
    @Test
    public void testShapeMoveWithBounceOffLeft() {
        DynamicRectangleShape shape = new DynamicRectangleShape(30, 20, -30, 15);
        shape.paint(_painter);
        shape.move(100, 100);
        shape.paint(_painter);
        shape.move(100, 100);
        shape.paint(_painter);
        assertEquals("(rectangle 30,20,25,35)(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(set color: java.awt.Color[r=255,g=255,b=255])(filledRectangle 0,35,25,35)" +
                "(set color: java.awt.Color[r=212,g=212,b=212])(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(set color: java.awt.Color[r=255,g=255,b=255])(filledRectangle 30,50,25,35)" +
                "(set color: java.awt.Color[r=212,g=212,b=212])", _painter.toString());
    }

    /**
     * Test when DynamicShape bounce off Right wall.
     * Ensure that it changes to fill rectangle after contact with the wall
     * and the getColor and setColor works fine
     * Every time after a color is paint it'll be set back to original color
     */
    @Test
    public void testShapeMoveWithBounceOffRight() {
        DynamicRectangleShape shape = new DynamicRectangleShape(30, 20, 10, 30, Color.YELLOW);
        shape.paint(_painter);
        shape.move(65, 1000);
        shape.paint(_painter);
        shape.move(65, 1000);
        shape.paint(_painter);
        assertEquals("(rectangle 30,20,25,35)(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(set color: java.awt.Color[r=255,g=255,b=0])(filledRectangle 40,50,25,35)" +
                "(set color: java.awt.Color[r=212,g=212,b=212])(current color: java.awt.Color[r=212,g=212,b=212])" +
                "(set color: java.awt.Color[r=255,g=255,b=0])(filledRectangle 30,80,25,35)" +
                "(set color: java.awt.Color[r=212,g=212,b=212])", _painter.toString());
    }


    /**
     * Test when DynamicShape bounce off Up wall.
     * Ensure that it doesn't changes to fill rectangle after contact with the wall
     */
    @Test
    public void testShapeMoveWithBounceOffUp(){
        DynamicRectangleShape shape = new DynamicRectangleShape(50, 20, 10, -30);
        shape.paint(_painter);
        shape.move(1000, 1000);
        shape.paint(_painter);
        shape.move(1000,1000);
        shape.paint(_painter);
        assertEquals("(rectangle 50,20,25,35)" +
                "(rectangle 60,0,25,35)(rectangle 70,30,25,35)", _painter.toString());
    }

    /**
     * Test when DynamicShape bounce off Bottom wall.
     * Ensure that it doesn't changes to fill rectangle after contact with the wall
     */
    @Test
    public void testShapeMoveWithBounceOffBottom(){
        DynamicRectangleShape shape = new DynamicRectangleShape(20, 80, 10, 35);
        shape.paint(_painter);
        shape.move(1000, 150);
        shape.paint(_painter);
        shape.move(1000,150);
        shape.paint(_painter);
        assertEquals("(rectangle 20,80,25,35)" +
                "(rectangle 30,115,25,35)(rectangle 40,80,25,35)", _painter.toString());
    }

    /**
     * Test when DynamicShape bounce off top left corner.
     * Ensure that it doesn't changes to fill rectangle after contact with the corner
     */
    @Test
    public void testShapeMoveWithBounceOffTopLeft(){
        DynamicRectangleShape shape = new DynamicRectangleShape(20, 20, -20, -20);
        shape.paint(_painter);
        shape.move(1000, 1000);
        shape.paint(_painter);
        shape.move(1000, 1000);
        shape.paint(_painter);
        assertEquals("(rectangle 20,20,25,35)" +
                "(rectangle 0,0,25,35)(rectangle 20,20,25,35)", _painter.toString());
    }

    /**
     * Test when DynamicShape bounce off top right corner.
     * Ensure that it doesn't changes to fill rectangle after contact with the corner
     */
    @Test
    public void testShapeMoveWithBounceOffTopRight(){
        DynamicRectangleShape shape = new DynamicRectangleShape(50,30,25,35);
        shape.paint(_painter);
        shape.move(100, 100);
        shape.paint(_painter);
        shape.move(100, 100);
        shape.paint(_painter);
        assertEquals("(rectangle 50,30,25,35)" +
                "(rectangle 75,65,25,35)(rectangle 50,30,25,35)", _painter.toString());
    }

    /**
     * Test when DynamicShape bounce off bottom left corner.
     * Ensure that it doesn't changes to fill rectangle after contact with the corner
     */
    @Test
    public void testShapeMoveWithBounceOffBottomLeft(){
        DynamicRectangleShape shape = new DynamicRectangleShape(30,50, -30,30);
        shape.paint(_painter);
        shape.move(100, 115);
        shape.paint(_painter);
        shape.move(100, 115);
        shape.paint(_painter);
        assertEquals("(rectangle 30,50,25,35)" +
                "(rectangle 0,80,25,35)(rectangle 30,50,25,35)", _painter.toString());
    }

    /**
     * Test when DynamicShape bounce off bottom right corner.
     * Ensure that it doesn't changes to fill rectangle after contact with the corner
     */
    @Test
    public void testShapeMoveWithBounceOffBottomRight(){
        DynamicRectangleShape shape = new DynamicRectangleShape(100, 100, 25, 15);
        shape.paint(_painter);
        shape.move(150, 150);
        shape.paint(_painter);
        shape.move(150, 150);
        shape.paint(_painter);
        assertEquals("(rectangle 100,100,25,35)" +
                "(rectangle 125,115,25,35)(rectangle 100,100,25,35)", _painter.toString());
    }


}
