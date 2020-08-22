package spaceshapes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * Class to test class HexagonShape according to its specification.
 *
 */

public class TestHexagon {
    private MockPainter _painter;

    @Before
    public void setup(){
        _painter = new MockPainter();
    }

    /**
     * Test basic movement and painting of Hexagon shape.
     */
    @Test
    public void testBasicMovementAndPainting() {
        HexagonShape shape = new HexagonShape(100, 20, 12, 15, 50, 30);
        shape.paint(_painter);
        shape.move(1000,1000);
        shape.paint(_painter);
        assertEquals("(line 120,20,130,20)(line 130,20,150,35)(line 150,35,130,50)(line 130,50,120,50)" +
                "(line 120,50,100,35)(line 100,35,120,20)(line 132,35,142,35)(line 142,35,162,50)" +
                "(line 162,50,142,65)(line 142,65,132,65)(line 132,65,112,50)(line 112,50,132,35)",
                _painter.toString());
    }
    /**
     * Test when Hexagon has a width larger than forty
     * It should has 6 lines and all being painted at correct position
     */
    @Test
    public void widthNotLessThanForty(){
        HexagonShape shape = new HexagonShape(100, 20, 12, 15, 50, 30);
        shape.paint(_painter);
        assertEquals("(line 120,20,130,20)(line 130,20,150,35)(line 150,35,130,50)(line 130,50,120,50)" +
                "(line 120,50,100,35)(line 100,35,120,20)", _painter.toString());
    }

    /**
     * Test when Hexagon has a width larger than forty
     * It should has 4 lines and all being painted at correct position
     */
    @Test
    public void widthLessThanForty(){
        HexagonShape shape = new HexagonShape(100, 20, 12, 15, 20, 30);
        shape.paint(_painter);
        assertEquals("(line 110,20,120,35)(line 120,35,110,50)(line 110,50,100,35)(line 100,35,110,20)",
                _painter.toString());
    }

}
