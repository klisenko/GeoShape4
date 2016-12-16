package cp120.assignments.geo_shape;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;

public class TestGeoOval {
	private static final GeoPoint DEFAULT_ORIGIN  = new GeoPoint( 0f, 0f );
	private GeoPoint origin = DEFAULT_ORIGIN;
	private static final Color DEFAULT_COLOR = Color.BLUE;
	private Color color = DEFAULT_COLOR;

	@Test
	public final void testOval() {
		GeoOval shape = new GeoOval(600f, 500f);
		GeoOval shape2 = new GeoOval(origin, 700f, 200f);
		Assert.assertNotNull(shape);
		Assert.assertNotNull(shape2);
		
		Assert.assertEquals(600f, shape.getWidth(), 0.0f);
		Assert.assertEquals(500f, shape.getHeight(), 0.0f);
		Assert.assertEquals(DEFAULT_COLOR, shape.getColor());
		Assert.assertEquals(DEFAULT_COLOR, shape2.getColor());
		
		GeoPoint newOrigin = new GeoPoint(50f, 100f);
		shape.setOrigin(newOrigin);
		Assert.assertEquals(newOrigin, shape.getOrigin());
		shape2.setColor(color);
		
		double w = 400.5;
		double h = 200.2;		
		shape.setHeight(h);
		shape.setWidth(w);
		
		double a = h / 2;
		double b = w / 2; 
		double expectedArea = a * b * Math.PI;		
		Assert.assertEquals(expectedArea, shape.area(), 0.0d);
		
		double expectedPerimeter = 2*Math.PI*Math.sqrt((Math.pow(a, 2) + Math.pow(b, 2)) / 2); 
		Assert.assertEquals(expectedPerimeter, shape.perimeter(), 0.0d);
		
		shape.setColor(Color.darkGray);
		shape.setEdgeColor(Color.WHITE);
		shape.setEdgeWidth(8);
		
		GeoPlane plane = new GeoPlane();
		
		plane.addShape(shape);
		plane.show();
		plane.redraw();
		
		String msg = "Do you see a Dark Gray Oval with a White edge";
		int result = JOptionPane.showConfirmDialog(null, msg);
		Assert.assertEquals(JOptionPane.YES_OPTION, result);
		plane.removeShape(shape);		
	}

}
