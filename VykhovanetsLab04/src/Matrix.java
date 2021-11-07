import java.util.LinkedList;
import java.util.Queue;

public class Matrix
{
	private boolean matrix[][];
	private boolean isDirected;

	// constructor
	public Matrix(int numVert, boolean isDirected)
	{
		matrix = new boolean[numVert][numVert];
		this.isDirected = isDirected;
	}

	public void addEdge(int startV, int endV)
	{

		matrix[startV][endV] = true;

		if (!isDirected)
		{
			matrix[endV][startV] = true;
		}
	}

	public void removeEdge(int startV, int endV)
	{
		matrix[startV][endV] = false;

		// if not directed graph
		if (!isDirected)
		{
			matrix[endV][startV] = false;
		}
	}

	public boolean isEdge(int startV, int endV)
	{
		return matrix[startV][endV];
	}

	public void edgesIncidentToVertex(int v)
	{
		for (int i = 0; i < matrix[v].length; i++)
		{
			if (matrix[v][i] == true)
			{
				System.out.println(i);
			}
		}
	}

	public void DFS()
	{
		boolean[] visited = new boolean[matrix.length];
		for (boolean v : visited)
		{
			v = false;
		}
		for (int i = 0; i < visited.length; i++)
		{
			if (visited[i] == false)
			{
				DFS(i, visited);
			}
		}

	}

	public void DFS(int v, boolean visited[])
	{
		System.out.print(v + " ");
		visited[v] = true;
		for (int i = 0; i < matrix.length; i++)
		{
			if (matrix[v][i] == true && visited[i] == false)
			{
				// System.out.println(i);
				// visited[i] = true;
				DFS(i, visited);
			}
		}

	} // but will this work for when you start with non zero?
		// it does not

	public void BFS(int V)
	{
		Queue<Integer> queue = new LinkedList<Integer>(); // is queue right?
		boolean[] visited = new boolean[matrix.length];
		for (int i = 0; i < matrix.length; i++)
		{
			visited[i] = false;
		}

		queue.add(V);
		while (!queue.isEmpty())
		{
			int temp = queue.poll();
			visited[temp] = true;
			System.out.print(temp + " ");
			for (int i = 0; i < matrix.length; i++)
			{ // should i make V be 0?
				if (matrix[temp][i] == true && visited[i] == false)
				{ // i changed V to temp and it works
					queue.add(i);
					visited[i] = true;
				}
			}

		}
	}

}
