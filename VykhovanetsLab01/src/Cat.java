
public class Cat extends Pet
{

	protected boolean isOutsideOnly;

	public Cat(String petName, String ownerName, double petWeight, boolean isOutsideOnly)
	{
		super(petName, ownerName, petWeight);
		this.isOutsideOnly = isOutsideOnly;
	}

	public boolean isOutsideOnly()
	{
		return isOutsideOnly;
	}

	public void setOutsideOnly(boolean isInsideOnly)
	{
		this.isOutsideOnly = isInsideOnly;
	}

	public String translate(boolean trueOrFalse)
	{
		return trueOrFalse ? "Outside" : "Inside";
	}

	public int visit(int numShots)
	{
		totalAllVisitCost = super.visit(numShots) + 20;
		if (isOutsideOnly == true)
		{
			return totalAllVisitCost += 30;
		} else
			return totalAllVisitCost;
	}

	public String toString()
	{
		String print = petName + " : " + ownerName + " : " + petWeight + " lbs : " + numVisits + " visit(s)";
		String print2 = " [" + translate(isOutsideOnly) + " Cat]";
		if (numVisits > 0)
		{
			return print + ", Average Cost / visit: $" + super.averageCost() + print2;
		} else
		{
			return print + print2;

		}
	}

}
