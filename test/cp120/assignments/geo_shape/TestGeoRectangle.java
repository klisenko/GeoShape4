package cp120.assignments.geo_shape;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;

public class TestGeoRectangle {
	private static final GeoPoint DEFAULT_ORIGIN  = new GeoPoint( 0f, 0f );
	private GeoPoint origin = DEFAULT_ORIGIN;
	private static final Color DEFAULT_COLOR = Color.BLUE;
	private Color color = DEFAULT_COLOR;
	

	@Test
	public final void testRectangle() {
		GeoRectangle shape = new GeoRectangle(0, 0);
		GeoRectangle shape2 = new GeoRectangle(origin, 0, 0);
		Assert.assertNotNull(shape2);
		
		Assert.assertEquals(0f, shape.getWidth(), 0.0f);
		Assert.assertEquals(0f, shape.getHeight(), 0.0f);
		Assert.assertEquals(DEFAULT_COLOR, shape.getColor());
		Assert.assertEquals(DEFAULT_COLOR, shape2.getColor());
		
		shape2.setColor(color);
		GeoPoint origin = new GeoPoint(40f, 60f);
		
		double w = 180.4;
		double h = 301.8;		
		shape.setHeight(h);
		shape.setWidth(w);
		shape.setOrigin(origin);
		Assert.assertEquals(w, shape.getWidth(), 0.0d);
		Assert.assertEquals(h, shape.getHeight(), 0.0d);
		Assert.assertEquals(w * h, shape.area(), 0.0d);
		Assert.assertEquals(2*w + 2*h, shape.perimeter(), 0.0d);
		Assert.assertEquals(w, shape.getWidth(), 0.0d);
		Assert.assertEquals(h, shape.getHeight(), 0.0d);
		
		shape.setEdgeColor(Color.PINK);
		shape.setEdgeWidth(7.3f);;
		
		String hexColor = "#"+Integer.toHexString(shape.getColor().getRGB()).substring(2);
		String hexEdgeColor = "#"+Integer.toHexString(shape.getEdgeColor().getRGB()).substring(2);
		String arg1 = String.format("origin=%s,color=%s,edgeColor=%s,edgeWidth=%s", origin.toString(),hexColor,hexEdgeColor,shape.getEdgeWidth());
		String expected = String.format("%s,width=%s,height=%s", arg1, w, h);
		Assert.assertEquals(expected, shape.toString());
		
		shape.setColor(Color.CYAN);
		shape.setEdgeColor(Color.LIGHT_GRAY);
		shape.setEdgeWidth(3);
		
		GeoPlane plane = new GeoPlane();
		
		plane.addShape(shape);
		plane.show();
		plane.redraw();
		
		String msg = "Do you see a Cyan Rectangle with a Light Gray edge";
		int result = JOptionPane.showConfirmDialog(null, msg);
		Assert.assertEquals(JOptionPane.YES_OPTION, result);
		plane.removeShape(shape);
		
		
		
	}

}
