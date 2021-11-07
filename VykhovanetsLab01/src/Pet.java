public class Pet
{
	protected String petName;
	protected String ownerName;
	protected double petWeight;
	protected int numVisits;
	protected int totalAllVisitCost;

	public Pet(String petName, String ownerName, double petWeight)
	{
		this.petName = petName;
		this.ownerName = ownerName;
		this.petWeight = petWeight;

	}

	public int visit(int numShots)
	{
		totalAllVisitCost += 85 + (numShots * 30);
		numVisits += 1;
		return totalAllVisitCost;
	}

	public double averageCost()
	{
		return totalAllVisitCost / numVisits;
	}

	public String getPetName()
	{
		return petName;
	}

	public void setPetName(String petName)
	{
		this.petName = petName;
	}

	public String getOwnerName()
	{
		return ownerName;
	}

	public void setOwnerName(String ownerName)
	{
		this.ownerName = ownerName;
	}

	public double getPetWeight()
	{
		return petWeight;
	}

	public void setPetWeight(double petWeight)
	{
		this.petWeight = petWeight;
	}

	public int getNumVisits()
	{
		return numVisits;
	}

	public void setNumVisits(int numVisits)
	{
		this.numVisits = numVisits;
	}

	public double getTotalAllVisitCost()
	{
		return totalAllVisitCost;
	}

	public void setTotalAllVisitCost(int totalAllVisitCost)
	{
		this.totalAllVisitCost = totalAllVisitCost;
	}

	public String toString()
	{
		String print = petName + " : " + ownerName + " : " + petWeight + " lbs : " + numVisits + " visit(s)";

		if (numVisits > 0)
		{
			return print + ", Average Cost / visit: $" + averageCost() + "0";
		}
		return print;
	}

}
