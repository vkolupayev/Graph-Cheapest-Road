package ads4;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		
		String me = "Savininkas1";
		int test = 0;
		String file = "Data.txt";
		ArrayList<Edge> edgesAL = new ArrayList<Edge>();
		
		Scanner sc = new Scanner(new File(file));
		
		
		while(sc.hasNext())
		{
			edgesAL.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextDouble(), sc.next(), me));
		}
		
		Edge[] edges = new Edge[edgesAL.size()];
		edges = edgesAL.toArray(edges);
		
		/*Edge[] edges2 = {
				new Edge(0, 2, 1, "Savininkas1", me),
				new Edge(0, 3, 4, "Savininkas3", me),
				new Edge(0, 4, 2, "Savininkas1", me),
				new Edge(0, 1, 3, "Savininkas1", me),
				new Edge(1, 3, 2, "Savininkas1", me),
				new Edge(1, 4, 3, "Savininkas1", me),
				new Edge(1, 5, 1, "Savininkas1", me),
				new Edge(2, 4, 1, "Savininkas1", me),
				new Edge(3, 5, 4, "Savininkas2", me),
				new Edge(4, 5, 2, "Savininkas1", me),
				new Edge(4, 6, 7, "Savininkas2", me),
				new Edge(4, 7, 2, "Savininkas1", me),
				new Edge(5, 6, 4, "Savininkas3", me),
				new Edge(6, 7, 5, "Savininkas1", me),
				new Edge(0, 1, 2, "Savininkas1", me),
				new Edge(0, 2, 4, "Savininkas3", me),
				new Edge(2, 1, 1, "Savininkas1", me)

		};*/

		Graph g = new Graph(edges);
		g.calculateShortestDistance(test);
		
		g.printResults(test);
		
	}
		
}
