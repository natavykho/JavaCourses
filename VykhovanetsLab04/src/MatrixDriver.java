

public class MatrixDriver
{

	public static void main(String[] args)
	{
		
		Matrix matrix = new Matrix(8, true);
		
		matrix.addEdge(0, 1); // edge from A to B
		matrix.addEdge(0, 3); // edge from A to D
		matrix.addEdge(1, 2); // edge from B to C
		matrix.addEdge(1, 5); // edge from B to F
		matrix.addEdge(2, 4); // edge from C to E
		matrix.addEdge(2, 6); // edge from C to G
		matrix.addEdge(2, 7); // edge from C to H
		matrix.addEdge(3, 5); // edge from D to F
		matrix.addEdge(4, 1); // edge from E to B
		matrix.addEdge(4, 5); // edge from E to F
		matrix.addEdge(5, 0); // edge from F to A
		matrix.addEdge(6, 4); // edge from G to E
		matrix.addEdge(6, 7); // edge from G to H
		matrix.addEdge(7, 0); // edge from H to A
		
		System.out.print("DFS: ");
		matrix.DFS();
		System.out.println();
		System.out.println();
		System.out.print("BFS: ");
		matrix.BFS(0);
		
		
		Matrix m = new Matrix(12,false);
		m.addEdge(0, 1);
		m.addEdge(0, 2);
		m.addEdge(0, 4);
		m.addEdge(1, 4);
		m.addEdge(2, 4);
		m.addEdge(2, 5);
		m.addEdge(2, 9);
		m.addEdge(2, 10);
		m.addEdge(5, 6);
		m.addEdge(5, 7);
		m.addEdge(5, 8);
		m.addEdge(7, 8);
		m.addEdge(9, 11);
		m.addEdge(10, 11);
		
		System.out.println();
		System.out.println();
		System.out.println();
		m.DFS();
		System.out.println();
		m.BFS(0);
		
		
		Matrix a = new Matrix(8, false);
		a.addEdge(0, 1);
		a.addEdge(0, 2);
		a.addEdge(0, 3);
		a.addEdge(1, 3);
		a.addEdge(1, 4);
		a.addEdge(2, 5);
		a.addEdge(3, 5);
		a.addEdge(3, 6);
		a.addEdge(4, 6);
		a.addEdge(4, 7);
		a.addEdge(5,6);
		a.addEdge(6, 7);
		System.out.println();
		System.out.println();
		
		System.out.println();
		a.DFS();
		System.out.println();
		a.BFS(0);
		System.out.println();
		System.out.println();
		System.out.println();
		a.edgesIncidentToVertex(0);
		
		
		
		
		
		

	}

}
