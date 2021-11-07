
public class PatientListDriver
{

	public static void main(String[] args)
	{
		MinHeap<Patient> mp = new MinHeap<Patient>();

		mp.add(new Patient("Bob", "Jones", 3000));
		mp.add(new Patient("Dave", "Smith", 2000));
		mp.add(new Patient("Susie", "Smith", 1000));
		mp.add(new Patient("Jessica", "Montgomery", 2001));

		System.out.println("Processing patient number: " + mp.remove());
		System.out.println("Processing patient number: " + mp.remove());

		mp.add(new Patient("Billy", "Joel", 1001));
		mp.add(new Patient("Dawn", "Angelo", 3001));
		mp.add(new Patient("Sally", "Atwater", 3002));
		mp.add(new Patient("Michael", "Jordan", 5000));

		System.out.println("Processing patient number: " + mp.remove());
		System.out.println("Processing patient number: " + mp.remove());
		System.out.println("Processing patient number: " + mp.remove());

		mp.add(new Patient("Nikki", "Last", 5001));
		mp.add(new Patient("Mike", "Powers", 2002));

		for (int i = 0; i < 5; ++i)
		{
			System.out.println("Processing patient number: " + mp.remove());
		}

	}

}
