
public class Patient implements Comparable<Patient>
{
	private String firstName;
	private String lastName;
	private int waitingNumber;

	public Patient(String firstName, String lastName, int waitingNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.waitingNumber = waitingNumber;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getWaitingNumber()
	{
		return waitingNumber;
	}

	public void setWaitingNumber(int waitingNumber)
	{
		this.waitingNumber = waitingNumber;
	}

	public int compareTo(Patient p2)
	{
		if (waitingNumber < p2.waitingNumber)
			return -1;
		else if (waitingNumber > p2.waitingNumber)
			return 1;
		else
			return 0;
	}

	public String toString()
	{
		return "" + waitingNumber;
	}

}
