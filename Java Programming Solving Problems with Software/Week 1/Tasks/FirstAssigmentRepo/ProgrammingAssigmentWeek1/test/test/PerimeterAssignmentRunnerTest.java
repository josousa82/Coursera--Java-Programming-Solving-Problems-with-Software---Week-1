package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import edu.duke.FileResource;
import edu.duke.Shape;
import main.PerimeterAssignmentRunner;
import org.hamcrest.core.*;
import org.hamcrest.CoreMatchers;

public class PerimeterAssignmentRunnerTest {
	 
	private PerimeterAssignmentRunner testPr;
	private FileResource ShapeCoordFile;
	private Shape testShape;
	
	@Before
	public void create() {
		testPr = new PerimeterAssignmentRunner();
		ShapeCoordFile = new FileResource();
				
	}
	
	
	@Test
	public void getAverageLengthtest() {
		testShape = new Shape(ShapeCoordFile);
		double lengTestPr =  testPr.getAverageLength(testShape);
		double t = 4.0;
		assertEquals(t, lengTestPr, 0);
	}
}
