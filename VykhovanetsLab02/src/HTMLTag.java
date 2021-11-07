
public class HTMLTag
{
	private String tagName, tagBody;
	
	
	public HTMLTag(String tagName, String tagBody)
	{
		this.tagName = tagName;
		this.tagBody = tagBody;
	}


	public String getTagName()
	{
		return tagName;
	}

	public void setTagName(String tagName)
	{
		this.tagName = tagName;
	}

	public String getTagBody()
	{
		return tagBody;
	}

	public void setTagBody(String tagBody)
	{
		this.tagBody = tagBody;
	}


	public String toString()
	{
		String first = "<" + tagName + ">";
		String middle = tagBody;
		String last = "</" + tagName + ">";
		return first + middle + last;
		
	}
	
		

}
