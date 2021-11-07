public class Hashtable
{

	HashEntry[] table;
	int tableSize;

	public Hashtable(int tableSize)
	{
		table = new HashEntry[tableSize];
		this.tableSize = tableSize;
	}

	// this calculates the hash key of the element
	public int hashFunction(String name)
	{
		int hash = (name.charAt(0) * 17) % tableSize;
		return hash;
	}

	// this puts the entry into the array, using the hashFunction
	// create a HashEntry object using the input values
	// if the ideal location is empty, place the entry there
	// if the ideal location is not empty, handle the collision
	public void put(String name, String number)
	{
		HashEntry entry = new HashEntry(name, number);
		if (table[hashFunction(name)] == null)
		{
			table[hashFunction(name)] = entry;

		}
		// collision handling:
		// creates a temporary HashEntry variable for other entries
		// loops through until you find a spot to put the entry
		// count starts at the next location after the ideal location
		// if the next location is empty, the entry is placed there
		// if not, you test whether the one that is there is closer to its ideal
		// location
		// if it is, you place entry in there, and handle collision with the one you
		// took out
		else
		{
			HashEntry temp;
			Boolean isPlaced = false;
			int count = hashFunction(name) + 1;

			while (isPlaced == false)
			{
				if (count == table.length)
				{
					count = 0;
				}
				if (table[count] == null)
				{
					table[count] = entry;
					isPlaced = true;

				} 
				else if (Math.abs(count - hashFunction(table[count].getKey())) < Math
						.abs((count - hashFunction(name))))
				{

					temp = table[count];
					table[count] = entry;
					put(temp.key, temp.value);
					isPlaced = true;
					count++;
					if (count == table.length)
					{
						count = 0;
					}
				} 
				else
				{
					count++;
					if (count == table.length)
					{
						count = 0;
					}
				}
			}
		}
	}

	// the get function takes in the key, and searches for the key starting from
	// ideal location
	// the while loop iterates when table[hash] is null or is not equal to the key
	// when you reach the end of the table, hash is reset to the beginning of the
	// table
	// when you iterate to the location before the starting point and have not found
	// the key,
	// return: Not Found
	public String get(String name)
	{
		int hash = hashFunction(name);
		while (table[hash] == null || !table[hash].getKey().equals(name))
		{
			hash += 1;
			if (hash == table.length)
			{
				hash = 0;
			}
			if (hash == (hashFunction(name) - 1) && !table[hash].getKey().equals(name))
			{
				return "Not Found";
			}
		}
		// if(table[hash].getKey().equals(name)) {
		// return table[hash].getValue();
		// }
		return table[hash].getValue();
	}

	public int fromInitial(String name)
	{
		int i = hashFunction(name);
		int count = 0;
		while (table[i] == null || !table[i].getKey().equals(name))
		{
			i++;
			count++;
			if (i == table.length)
			{
				i = 0;
			}

		}
		// if(table[i].getKey().equals(name)){
		return count;
		// }
	}

	public void printHashElementInfo(String name)
	{
		int i = hashFunction(name);
		HashEntry theEntry;
		while (table[i] == null || !table[i].getKey().equals(name))
		{
			i++;
			if (i == table.length)
			{
				i = 0;
			}
		}
		theEntry = table[i];
		System.out.println(theEntry);
		System.out.print("Stored Index: ");
		System.out.print(i);
		System.out.print(", Ideal index: ");
		System.out.print(hashFunction(name));
		System.out.print(", probe length: ");
		System.out.print(fromInitial(name));
		System.out.println();

	}

	// the print:
	//
	public String toString()
	{
		String str = "";
		for (int i = 0; i < table.length; i++)
		{
			if (table[i] != null)
			{
				int DIB = fromInitial(table[i].getKey());
				str += "[" + i + "]: " + (table[i]) + " [Probe Length: " + DIB + "]" + "\n";
			}

			// this is what you print if table[i] == null
			else
			{
				str += "[" + i + "]: \n";
			}
		}
		return str; 
	}

}
