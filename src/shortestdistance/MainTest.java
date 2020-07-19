package shortestdistance;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

	@Test
	void testPointValues() {
		Main.genPoints();
		boolean pointsOutOfGraph = false;
		for(int i = 0; i< Main.points.length; i++) {
			for(int j : Main.points[i]) {
				if(j < -Main.scopeOfGraph || j > Main.scopeOfGraph) {
					pointsOutOfGraph = true; 
				}
			}
		}
		assertFalse(pointsOutOfGraph);
	}
	
	@Test
	void testForNegs() {
		Main.genPoints();
		boolean hasNegs = false;
		for(int i = 0; i < Main.points.length; i++) {
			for(int j : Main.points[i]) {
				if(j < 0) {
					hasNegs = true;
				}
			}
		}
		assertTrue(hasNegs);
	}

	@Test
	void testShortestDistance() {
		Main.findClosestPair();
		boolean closer = false;
		for(int i = 0; i < Main.points.length-1; i++) {
			for(int j = i + 1; j < Main.points.length; j++) {
				double dist =  Math.sqrt(Math.pow(Main.points[j][0] - Main.points[i][0], 2) + 
										Math.pow(Main.points[j][1] - Main.points[i][1], 2));
				
				if(Main.shortestDist > dist && dist != 0) {
					closer = true;
				}
				
			}
		}
		assertFalse(closer);
	}

}
