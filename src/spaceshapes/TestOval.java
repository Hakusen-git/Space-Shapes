package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * Class to test class OvalShape according to its specification.
 */

public class TestOval {
    private MockPainter _painter;

    @Before
    public void setUp(){
        _painter = new MockPainter();
    }

    /**
     * Test simple move of Oval object
     * Ensure oval shape is painted at the correct position
     */
    @Test
    public void testSimpleMove() {
        OvalShape shape = new OvalShape(100, 20, 12, 15);
        shape.paint(_painter);
        shape.move(500, 500);
        shape.paint(_painter);
        assertEquals("(oval 100,20,25,35)(oval 112,35,25,35)",
                _painter.toString());
    }

    /**
     * Test movement of Oval object when it bounces off right wall
     * Ensure oval shape is painted at the correct position
     */
    @Test
    public void testShapeMoveWithBounceOffRight() {
        OvalShape shape = new OvalShape(100, 20, 12, 15);
        shape.paint(_painter);
        shape.move(135, 10000);
        shape.paint(_painter);
        shape.move(135, 10000);
        shape.paint(_painter);
        assertEquals("(oval 100,20,25,35)(oval 110,35,25,35)"
                + "(oval 98,50,25,35)", _painter.toString());
    }

    /**
     * Test movement of Oval object when it bounces off left wall
     * Ensure oval shape is painted at the correct position
     */
    @Test
    public void testShapeMoveWithBounceOffLeft() {
        OvalShape shape = new OvalShape(10, 20, -12, 15);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        shape.move(10000, 10000);
        shape.paint(_painter);
        assertEquals("(oval 10,20,25,35)(oval 0,35,25,35)"
                + "(oval 12,50,25,35)", _painter.toString());
    }

    /**
     * Test movement of Oval object when it bounces off bottom right corner
     * Ensure oval shape is painted at the correct position
     */
    @Test
    public void testShapeMoveWithBounceOffBottomAndRight() {
        OvalShape shape = new OvalShape(10, 90, -12, 15);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        shape.move(125, 135);
        shape.paint(_painter);
        assertEquals("(oval 10,90,25,35)(oval 0,100,25,35)"
                + "(oval 12,85,25,35)", _painter.toString());
    }

}
