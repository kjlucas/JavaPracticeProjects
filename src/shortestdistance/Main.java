package shortestdistance;

public class Main {
	public static int[][] points = new int[(int)(31*Math.random())][2];
	public static int[][] shortestPair = new int[2][2];
	public static double shortestDist = Double.MAX_VALUE;
	public static int scopeOfGraph = (int) (Math.random() * 21);
	
	public static void main(String[] args) {
		
		genPoints();
		findClosestPair();
		printResult();
		
	}
	public static void genPoints() {
		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points[0].length; j++) {
				points[i][j] = (int) (Math.pow(-1, (int) (3 * Math.random())) * (scopeOfGraph * Math.random()));
			}
		}
	}
	
	public static void findClosestPair() {
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j <= points.length - 1; j++) {
				double dist = Math.sqrt(Math.pow(points[j][0] - points[i][0], 2) +
										Math.pow(points[j][1] - points[i][1], 2));

				if (dist < shortestDist && dist != 0) {
					shortestDist = dist;
					shortestPair[0][0] = points[i][0];
					shortestPair[0][1] = points[i][1];
					shortestPair[1][0] = points[j][0];
					shortestPair[1][1] = points[j][1];
				}
			}
		}
	}
	
	public static void printResult() {
		System.out.println("Closest pair is " + shortestPair[0][0] + "," + shortestPair[0][1] + " and "
				+ shortestPair[1][0] + "," + shortestPair[1][1] + " with a distnce of " + shortestDist);
	}
}