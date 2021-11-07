
public class Dog extends Pet
{
	protected String size;

	public Dog(String petName, String ownerName, double petWeight, String size)
	{
		super(petName, ownerName, petWeight);
		this.size = size;
	}

	@Override
	public int visit(int numShots)
	{
		totalAllVisitCost = super.visit(numShots) + 15;
		if (size == "medium")
		{
			return totalAllVisitCost += (numShots * 2.5);
		} else if (size == "large")
		{
			return totalAllVisitCost += (numShots * 5);
		} else
		{
			return totalAllVisitCost;
		}
	}

	public String getSize()
	{
		return size;
	}

	public void setSize(String size)
	{
		this.size = size;
	}

	public String toString()
	{
		String print = petName + " : " + ownerName + " : " + petWeight + " lbs : " + numVisits + " visit(s)";
		String print2 = " [" + size + " Dog]";
		if (numVisits > 0)
		{
			return print + ", Average Cost / visit: $" + super.averageCost() + print2;
		} else
		{
			return print + print2;
		}

	}

}
