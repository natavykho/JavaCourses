import java.util.LinkedList;
import java.util.Stack;

public class HTMLTree
{
	public class Node
	{
		private HTMLTag data;
		private int parent;
		private LinkedList<Integer> list;

		public Node(HTMLTag data, int parent)
		{
			this.data = data;
			this.parent = parent;
			list = new LinkedList<Integer>();
		}

		public HTMLTag getData()
		{
			return data;
		}

		public void setData(HTMLTag data)
		{
			this.data = data;
		}

		public int getParent()
		{
			return parent;
		}

		public void setParent(int parent)
		{
			this.parent = parent;
		}

		public LinkedList<Integer> getList()
		{
			return list;
		}

		public void setList(LinkedList<Integer> list)
		{
			this.list = list;
		}

	}

	private int size;
	Node[] treeArray = new Node[100];

	public HTMLTree()
	{
		size = 0;
	}

	public int getSize()
	{
		return size;
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public void addRoot(HTMLTag tag)
	{
		Node n = new Node(tag, -1); 
		treeArray[0] = n;
		size++;
	}

	public void add(HTMLTag parent, HTMLTag tag)
	{
		int index = 0;
		boolean isFound = false;
		for (int i = 0; i < treeArray.length && isFound == false; i++)
		{
			if (treeArray[i].getData().getTagName().equals(parent.getTagName()))
			{
				index = i;
				isFound = true;
				// break; //how to not use this?
			}
		}
		Node n = new Node(tag, index);
		treeArray[size] = n;
		treeArray[index].getList().add(size);
		size++;

	}

	public void printNodes()
	{
		printNodes(treeArray[0], 0);
	}
	
	// print root and check for child nodes
	// print first child node and check for children.
	// if children, print child and check for node
	// if no children, print second child node.

	// if it has a tagBody, you print it all together,
	// but if it doesn't than you print the beginning,
	// then the children, then the closing - with recursion preorder traversal
	private void printNodes(Node n, int count)
	{
		//prints spaces count number of times
		for (int j = 0; j < count; j++)
		{
			System.out.print("    ");
		}

		if (n.getList().isEmpty())
		{
			System.out.print("<" + n.getData().getTagName() + ">");
		} 
		else
		{
			System.out.println("<" + n.getData().getTagName() + ">");
			count++;
		}

		for (int i : n.getList())
		{
			printNodes(treeArray[i], count);

		}

		System.out.print(n.getData().getTagBody());
		if (!n.getList().isEmpty())
		{
			for (int j = 0; j < count - 1; j++)
			{
				System.out.print("    ");
			}
		}
		System.out.println("</" + n.getData().getTagName() + ">");

	}

}
