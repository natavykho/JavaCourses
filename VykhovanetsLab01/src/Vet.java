public class Vet implements Database
{

	protected String nameOfClinic;
	protected int numPets;
	protected int size;
	Pet[] data;

	public Vet(String nameOfClinic, int numPets)
	{
		this.nameOfClinic = nameOfClinic;
		this.numPets = numPets;
		data = new Pet[numPets];
		size = 0;
	}

	public int size()
	{
		return size;
	}

	public void display()
	{
		System.out.println(nameOfClinic + " Pet List");
		for (int i = 0; i < size; i++)
		{
			if (data[i] != null)
			{
				System.out.printf("%s\n", data[i]);
			}

		}
	}

	public Pet find(String petName)
	{
		for (int i = 0; i < size; i++)
		{
			if (data[i] != null && data[i].getPetName().equals(petName))
			{
				return data[i];
			}
		}
		return null;
	}

	public boolean add(Pet p)
	{
		data[size] = p;
		size += 1;
		return false;
	}

	public boolean delete(Pet p)
	{
		for (int i = 0; i < size; i++)
		{
			if (data[i] == p)
			{

				data[i] = null;
				for (int j = i; j < size - 1; j++)
				{
					data[j] = data[j + 1];
				}
				size -= 1;

				return true;
			}
		}

		return false;

	}
}
