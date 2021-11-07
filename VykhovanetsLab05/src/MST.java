// this is the website I got the program from:
// https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
// I added a parallel array to print out corresponding city names
// I also added the method to calculate the total cost
// I wrote in the adjacency matrix into the main method to work with it.

import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.*;

class MST
{
	// Number of vertices in the graph
	private static final int V = 12;
	private String cities[] =
		{ "Boston", "Chicago", "Dallas", "Denver", "Las Vegas", "Los Angeles", "Miami", 
		  "Minneapolis", "New York","San Fransisco", "Seattle", "Washington D.C." };

	// A utility function to find the vertex with minimum key
	// value, from the set of vertices not yet included in MST
	int minKey(int key[], Boolean mstSet[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min)
			{
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	// A utility function to print the constructed MST stored in parent[]
	void printMST(int parent[], int graph[][], String city[])
	{

		// System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
		{
			double dist = graph[i][parent[i]] * 1000;
			// System.out.println(parent[i] + " - " + i + "\t" + "($" +graph[i][parent[i]] +
			// ".00)");
			// System.out.println(cities[i] + " - " + cities[parent[i]] + "($" +dist +
			// ".00)");
			System.out.println(cities[i] + " - " + cities[parent[i]] + " ($" + String.format("%,.2f", dist) + ")");
		}
	}

	void printTotal(int parent[], int graph[][])
	{
		double total = 0;
		for (int i = 1; i < V; i++)
		{
			total += graph[i][parent[i]];
		}
		total *= 1000;
		System.out.println("Total Cost: $" + String.format("%,.2f", total));
	}

	// Function to construct and print MST for a graph represented using adjacency
	// matrix representation
	void primMST(int graph[][])
	{
		// Array to store constructed MST
		int parent[] = new int[V];

		// Key values used to pick minimum weight edge in cut
		int key[] = new int[V];

		// To represent set of vertices not yet included in MST
		Boolean mstSet[] = new Boolean[V];

		// Initialize all keys as INFINITE
		for (int i = 0; i < V; i++)
		{
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		// Always include first 1st vertex in MST.
		key[0] = 0; // Make key 0 so that this vertex is
		// picked as first vertex
		parent[0] = -1; // First node is always root of MST

		// The MST will have V vertices
		for (int count = 0; count < V - 1; count++)
		{
			// Pick thd minimum key vertex from the set of vertices
			// not yet included in MST
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those
			// vertices which are not yet included in MST
			for (int v = 0; v < V; v++)

				// graph[u][v] is non zero only for adjacent vertices of m
				// mstSet[v] is false for vertices not yet included in MST
				// Update the key only if graph[u][v] is smaller than key[v]
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v])
				{
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}

		// print the constructed MST
		printMST(parent, graph, cities);
		printTotal(parent, graph);
	}

	public static void main(String[] args)
	{

		MST t = new MST();

		int g[][] = new int[][]
		{
				{ 0, 1613, 0, 0, 0, 0, 0, 0, 338, 0, 0, 725 },
				{ 1613, 0, 0, 0, 0, 0, 0, 661, 0, 0, 0, 1145 },
				{ 0, 0, 0, 1258, 1983, 0, 2161, 1532, 0, 0, 0, 2113 },
				{ 0, 0, 1258, 0, 1225, 0, 0, 1483, 0, 0, 2161, 0 },
				{ 0, 0, 1983, 1225, 0, 435, 0, 0, 0, 919, 0, 0 },
				{ 0, 0, 0, 0, 435, 0, 0, 0, 0, 629, 0, 0 },
				{ 0, 0, 2161, 0, 0, 0, 0, 0, 2145, 0, 0, 1709 },
				{ 0, 661, 1532, 1483, 0, 0, 0, 0, 0, 0, 2661, 0 },
				{ 338, 0, 0, 0, 0, 0, 2145, 0, 0, 0, 0, 383 },
				{ 0, 0, 0, 0, 919, 629, 0, 0, 0, 0, 1306, 0 },
				{ 0, 0, 0, 2161, 0, 0, 0, 2661, 0, 1306, 0, 0 },
				{ 725, 1145, 2113, 0, 0, 0, 1709, 0, 383, 0, 0, 0 } 
				
		};

		t.primMST(g);

	}
}