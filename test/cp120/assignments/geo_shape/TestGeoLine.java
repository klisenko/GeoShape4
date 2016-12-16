package cp120.assignments.geo_shape;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.junit.Assert;
import org.junit.Test;

public class TestGeoLine {
	private static final GeoPoint DEFAULT_ORIGIN  = new GeoPoint( 0f, 0f );
	private GeoPoint origin = DEFAULT_ORIGIN;
	private static final Color DEFAULT_COLOR = Color.BLUE;
	private Color color = DEFAULT_COLOR;

	@Test
	public final void testLine() {
		GeoPoint start = new GeoPoint(50f, 25f);
		GeoPoint end = new GeoPoint(300f, 600f);
		GeoPoint end2 = new GeoPoint(300f, 200f);
		GeoLine shape = new GeoLine(origin, end);
		Assert.assertNotNull(shape);
		Assert.assertEquals(origin, shape.getOrigin());
		Assert.assertEquals(end, shape.getEnd());
		shape.setColor(color);
		shape.setEnd(end2);
		Assert.assertEquals(end2, shape.getEnd());
		shape.setStart(start);
		Assert.assertEquals(start, shape.getStart());
		Assert.assertEquals(start.distance(end2), shape.length(), 0.0d);
		
		float xEnd = end2.getXco();
		float yEnd = end2.getYco();
		float xStart = start.getXco();
		float yStart = start.getYco();
		double slope = (yEnd - yStart) / (xEnd -xStart);
		Assert.assertEquals(slope, shape.slope(), 0.0d);
		
		shape.setColor(Color.YELLOW);
		shape.setEdgeColor(Color.YELLOW);
		shape.setEdgeWidth(2);
		
		GeoPlane plane = new GeoPlane();
		
		plane.addShape(shape);
		plane.show();
		plane.redraw();
		
		String msg = "Do you see a thin yellow line";
		int result = JOptionPane.showConfirmDialog(null, msg);
		Assert.assertEquals(JOptionPane.YES_OPTION, result);
		
		plane.removeShape(shape);		
		
		String hexColor = "#"+Integer.toHexString(Color.YELLOW.getRGB()).substring(2);
		String hexEdgeColor = "#"+Integer.toHexString(Color.YELLOW.getRGB()).substring(2);
		
		String arg1 = String.format("origin=%s,color=%s,edgeColor=%s,edgeWidth=%s", start.toString(),hexColor,hexEdgeColor,2.0f);
		String arg2 = end2.toString();
		
		String expected = String.format("%s,end=%s", arg1, arg2);
		Assert.assertEquals(expected, shape.toString());
	}

}
