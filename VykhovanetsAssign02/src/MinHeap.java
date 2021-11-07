
public class MinHeap<E extends Comparable<E>>
{
	private Object[] h;
	private int size;

	public MinHeap()
	{
		h = new Object[10];
		size = 0;
	}

	public void swap(int index1, int index2)
	{
		E temp = (E) h[index1];
		h[index1] = h[index2];
		h[index2] = temp;
	}

	public void add(E e)
	{
		if (size < h.length)
		{
			h[size] = e;
			if (size > 0)
			{
				upheap();
			}
			size++;
		} 
		else
		{
			System.out.println("Heap is full");
		}
	}

	private void upheap()
	{
		int index = size;
		int parentIndex = (index - 1) / 2;
		while (index > 0 && ((E) h[index]).compareTo((E) h[parentIndex]) < 0)
		{
			swap(index, parentIndex);
			index = parentIndex;
			parentIndex = (index - 1) / 2;
		}
	}

	public E remove()
	{
		E r = (E) h[0];
		swap(0, size - 1);
		size--;
		downheap();
		return r;

	}

	private void downheap()
	{
		int index = 0;
		int leftChild = 2 * index + 1;
		int rightChild = 2 * index + 2;

		while (leftChild < size)
		{

			int smallerChild = leftChild;

			if (rightChild < size && ((E) h[rightChild]).compareTo((E) h[leftChild]) < 0)
			{
				smallerChild = rightChild;
			}

			if (((E) h[smallerChild]).compareTo((E) h[index]) < 0)
			{
				swap(smallerChild, index);

			}
			index = smallerChild;
			leftChild = 2 * index + 1;
			rightChild = 2 * index + 2;

		}
	}

	public void breadthFirst()
	{
		for (int i = 0; i < size; ++i)
		{
			System.out.print(h[i] + ", ");
		}
		System.out.println();
		System.out.println();
	}

}
