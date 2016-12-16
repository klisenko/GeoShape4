package cp120.assignments.geo_shape;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;

public class TestGeoShape {
	private static final GeoPoint DEFAULT_ORIGIN  = new GeoPoint( 0f, 0f );
	private GeoPoint origin = DEFAULT_ORIGIN;
	private static final Color DEFAULT_COLOR = Color.BLUE;
	private Color color = DEFAULT_COLOR;

	@Test
	public final void testGeoShape() {
		ImplementedGeoShape shape = new ImplementedGeoShape(origin, Color.RED);
		Assert.assertEquals(origin, shape.getOrigin());
		Assert.assertEquals(Color.RED, shape.getColor());
		Assert.assertNotNull(shape);
	}

	@Test
	public final void testDrawShapeGraphics2D() {
		GeoPoint start = new GeoPoint(10, 10);
		ImplementedGeoShape line = new ImplementedGeoShape(start, Color.RED);
		
		line.setEdgeColor(Color.GREEN);
		line.setEdgeWidth(10);
		
		GeoPlane plane = new GeoPlane();
		
		plane.addShape(line);
		plane.show();
		
		String msg = "Do you see a thick green line";
		int result = JOptionPane.showConfirmDialog(null, msg);
		Assert.assertEquals(JOptionPane.YES_OPTION, result);
	}

	@Test
	public final void testGetOrigin() {
		GeoShape shape = new GeoRectangle(origin, color, 2.3, 3.1);
		Assert.assertEquals(origin, shape.getOrigin());
	}

	@Test
	public final void testGetIntOrigin() {
		GeoShape shape = new GeoRectangle(origin, color, 2.3, 3.1);
		Assert.assertEquals(origin.getIntPoint(), shape.getIntOrigin());
	}

	@Test
	public final void testSetOrigin() {
		GeoShape shape = new GeoRectangle(origin, color, 2.3, 3.1);
		shape.setOrigin(new GeoPoint( 6.55f, 7.28f ));
		GeoPoint expected = new GeoPoint( 6.55f, 7.28f);
		Assert.assertEquals(expected.getXco(), shape.getOrigin().getXco(), 0.0f);
		Assert.assertEquals(expected.getYco(), shape.getOrigin().getYco(), 0.0f);
	}

	@Test
	public final void testGetColor() {
		GeoShape shape = new GeoRectangle(origin, Color.RED, 2.3, 3.1);
		shape.getColor();
		Assert.assertEquals(Color.RED, shape.getColor());
	}

	@Test
	public final void testSetColor() {
		GeoShape shape = new GeoRectangle(origin, Color.RED, 2.3, 3.1);
		shape.setColor(DEFAULT_COLOR);
		Assert.assertEquals(DEFAULT_COLOR, shape.getColor());
	}

	@Test
	public final void testGetEdgeWidth() {
		GeoShape shape = new GeoRectangle(origin, Color.RED, 2.3, 3.1);
		shape.setEdgeWidth(2.0f);
		Assert.assertEquals(2.0f, shape.getEdgeWidth(), 0.0f);
	}

	@Test
	public final void testSetEdgeWidth() {
		GeoShape shape = new GeoRectangle(origin, Color.RED, 2.3, 3.1);
		shape.setEdgeWidth(2.0f);
		Assert.assertEquals(2.0f, shape.getEdgeWidth(), 0.0f);
	}

	@Test
	public final void testGetEdgeColor() {
		GeoShape shape = new GeoRectangle(origin, Color.RED, 2.3, 3.1);
		shape.setEdgeColor(Color.BLACK);
		Assert.assertEquals(Color.BLACK, shape.getEdgeColor());
	}

	@Test
	public final void testSetEdgeColor() {
		GeoShape shape = new GeoRectangle(origin, Color.RED, 2.3, 3.1);
		shape.setEdgeColor(Color.CYAN);
		Assert.assertEquals(Color.CYAN, shape.getEdgeColor());
	}

	@Test
	public final void testSetEdge() {
		GeoShape shape = new GeoRectangle(origin, Color.RED, 2.3, 3.1);
		shape.setEdge(Color.GREEN, 4.0f);
		Assert.assertEquals(Color.GREEN, shape.getEdgeColor());
		Assert.assertEquals(4.0f, shape.getEdgeWidth(), 0.0f);
	}

	@Test
	public final void testToString() {
		ImplementedGeoShape shape = new ImplementedGeoShape(origin, Color.RED);		
		shape.setEdge(Color.ORANGE, 6.0f);
		shape.setOrigin(new GeoPoint( 6.55f, 7.28f ));
		shape.setColor(Color.RED);
		String expectedOrigin = "(6.55,7.28)";
		String hexColor = "#"+Integer.toHexString(Color.RED.getRGB()).substring(2);
		String hexEdgeColor = "#"+Integer.toHexString(Color.ORANGE.getRGB()).substring(2);
		float edgeWidth = 6.0f;
		String expected = String.format("origin=%s,color=%s,edgeColor=%s,edgeWidth=%s", expectedOrigin,hexColor,hexEdgeColor,edgeWidth);
		Assert.assertEquals(expected, shape.toString());
	}
	
	
	public class ImplementedGeoShape extends GeoShape {
		
		/**
		 * Constructor for ImplementedGeoShape.
		 * 
		 * @param origin
		 * @param color
		 */
		public ImplementedGeoShape(GeoPoint origin, Color color) {
			super(origin, color);
		}
		
		/* (non-Javadoc)
		 * Method to draw the Line.
		 * @param gtx
		 * @see cp120.assignments.assignment006.GeoRectangle#draw(java.awt.Graphics2D)
		 */
		@Override
		public void draw(Graphics2D gtx) {						
			String arg1 = this.toString();
			String output = String.format("Drawing GeoShape: %s", arg1);
			System.out.println(output);
			
			GeoPoint end = new GeoPoint(200f, 300f);
			
			float xStart = this.getOrigin().getXco();
			float yStart = this.getOrigin().getYco();
			float xEnd = end.getXco();
			float yEnd = end.getYco();
			
			Line2D.Double line = new Line2D.Double(xStart, yStart, xEnd, yEnd);
			super.draw(line, gtx);
			
		}
		

		
	}

}
