package main;

import edu.duke.*;
import java.io.File;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PerimeterAssignmentRunner {
	
	private ArrayList <Double> distList = new ArrayList<>();
	private ArrayList <Double> pointList = new ArrayList<>();
	private ArrayList <Double> xPoints  = new ArrayList<>();
	private ArrayList <Double> BufferList  = new ArrayList<>();
	private ArrayList<Object> BufferList2  = new ArrayList<>();

	private double totalPerim = 0.0;
	
	
    
  // CALCULA PERIMETRO DA FORMA 
	
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
        	System.out.println(currPt + "\n");
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    
   // Retorna numero pontos de Shape FEITO ****************
    
    public int getNumPoints (Shape s) {
        // Put code here
        pointList = (ArrayList)s.getPoints();
        int nPoints = pointList.size();
        return nPoints;
    }
 // ****************
    
   // Retorna Average pontos de Shape (deve retornar 4.0 com o ficheiro 1 seleccionado) FEITO ************
    
    public double getAverageLength(Shape s) {
    	distList.clear();
    	Point prevPt = s.getLastPoint();
    	
    	for (Point currPt : s.getPoints()) {
        	
        	BufferList2.add(currPt);
            double currDist = prevPt.distance(currPt);
            BufferList.add(currDist);
            prevPt = currPt;
            distList.add(currDist);
    	}
    	
    	double avg = distList.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    	
    	System.out.println("Current distance: " + BufferList + "\n" + "List of points: " + BufferList2 + "\n" + avg);
  
        return avg;
    }
   
    
    // RETORNA O VALOR MAIOR DA LISTA DE DISTANCIAS  FEITO ******************
  
    public double getLargestSide(Shape s) {
        // Put code here
    	distList.clear();
    	Point prevPoint = s.getLastPoint();
    	
    	for(Point currPt:s.getPoints()) {
    		double currtDist = prevPoint.distance(currPt);
    		
    			distList.add(currtDist);
    			prevPoint = currPt;
    	}
    	System.out.println(distList);
    	
        return Collections.max(distList) ;
    }
  //************************************************ FEITO
    public double getLargestX(Shape s) {
        // Put code here
        
        for (Point p : s.getPoints()){
            System.out.println(p);
            xPoints.add((double) p.getX());
            System.out.println(p.getX());
        }
       
        return Collections.max(xPoints);
    }
  //************************************************
    public double getLargestPerimeterMultipleFiles() {
    	
        // Put code here
    	BufferList.clear();
    	DirectoryResource dr = new DirectoryResource();
    	
        for (File f : dr.selectedFiles()) {
        	
        	PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        	FileResource fl = new FileResource(f);
        	Shape ts = new Shape(fl);
           	BufferList.add(pr.getPerimeter(ts));
        	
        }
        
       System.out.println("BufferList : " + BufferList);
       System.out.println("Max BufferList" + Collections.max(BufferList));
        
        return Collections.max(BufferList);
    }

//************************************************
    public String getFileWithLargestPerimeter() {
        // Put code here
    	DirectoryResource dr = new DirectoryResource();
    	HashMap<String, Double>TempMap = new HashMap<String, Double>();
    	 
    	double max ;
    	
    	for(File f: dr.selectedFiles()) {
    		
    	PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
    	FileResource file = new FileResource(f);
    	Shape shape = new Shape(file);
    	
    	TempMap.put(f.getName(), pr.getPerimeter(shape));
    	
    	}

    	max =  Collections.max(TempMap.values());
    	
    		 String fileName = TempMap.entrySet().stream()
    		.filter(entry-> entry.getValue() == max)
    		.map(entry -> entry.getKey())
    		.collect(Collectors.toList()).toString();
   	
    		// System.out.println( "\n\n HashMap : " + TempMap  + "\n Filename" + fileName);
    	
    		 // File temp = ;    // replace this code "\n Max: " + max 
    		 // temp.getName();
    		 
        return fileName; 
    }

//************************************************
    
    public void testPerimeter () {
    	
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        
        System.out.println(pr.getNumPoints(s));
    }
    // **********************************WORKING *************************
    public void testPerimeterMultipleFiles() {
    	
        // Put code here
    	PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
    	
    	System.out.println(pr.getLargestPerimeterMultipleFiles());
    	
    	
    }
    // **********************************WORKING *************************

    public void testFileWithLargestPerimeter() {
    	
        // Put code here
    	PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
    	
    	System.out.println(pr.getFileWithLargestPerimeter());
    	
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
    	
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        
        for (Point p : triangle.getPoints()){
        	
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);       
    }
    

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
        
    }

    public static void main (String[] args) {
    	
       PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
       //DirectoryResource dr = new DirectoryResource();
      // FileResource fr = new FileResource();
      // Shape shape = new Shape(fr);
       System.out.println( "filename with largest perim"+ pr.getFileWithLargestPerimeter() );
       // pr.getAverageLength(shape) + "\n longest side shape 4: " + pr.getLargestSide(shape) + "\n Get largest perim example 1 to 4 : " + pr.getLargestPerimeterMultipleFiles())

    }
}

