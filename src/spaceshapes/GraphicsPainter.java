package spaceshapes;

import java.awt.*;

/**
 * Implementation of the Painter interface that delegates drawing to a
 * java.awt.Graphics object.
 * 
 * @author Paramvir Singh (Original Author - Ian Warren)
 * 
 */
public class GraphicsPainter implements Painter {
	// Delegate object.

	private Graphics _g;
	/**
	 * Creates a GraphicsPainter object and sets its Graphics delegate.
	 */
	public GraphicsPainter(Graphics g) {
		this._g = g;
		_g.setColor(new Color(212, 212, 212));
	}

	/**
	 * @see spaceshapes.Painter
	 */
	public void drawRect(int x, int y, int width, int height) {
		_g.drawRect(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter
	 */
	public void drawOval(int x, int y, int width, int height) {
		_g.drawOval(x, y, width, height);
	}

	/**
	 * @see spaceshapes.Painter
	 */
	public void drawLine(int x1, int y1, int x2, int y2) {
		_g.drawLine(x1, y1, x2, y2);
	}


	/**
	 * @see spaceshapes.Painter
	 */
	public void fillRect(int x, int y, int width, int height) {
		_g.fillRect(x,y,width,height);
	}


	/**
	 * @see spaceshapes.Painter
	 */
	public void setColor(Color color) {
		_g.setColor(color);
	}


	/**
	 * @see spaceshapes.Painter
	 */
	public Color getColor() {
		return _g.getColor();
	}


	/**
	 * @see spaceshapes.Painter
	 */
	public void translate(int x, int y){
		_g.translate(x,y);
	}

	/**
	 * @see spaceshapes.Painter
	 */
	public void drawCentredText(int x, int y, int width, int height, String text){
		FontMetrics fontmetrics = _g.getFontMetrics();
		int centerX = x + (width - fontmetrics.stringWidth(text))/2;
		int centerY = y + height/2 ;

		if(fontmetrics.getAscent()>fontmetrics.getDescent()){
			centerY += (fontmetrics.getAscent()-fontmetrics.getDescent())/2;
		} else if (fontmetrics.getAscent()<fontmetrics.getDescent()){
			centerY += (fontmetrics.getDescent()-fontmetrics.getAscent())/2;
		}
		_g.drawString(text, centerX, centerY);
	}

	@Override
	public void drawImage(Image picture, int x, int y, int width, int height) {
		_g.drawImage(picture, x, y, width, height, null);
	}
}
