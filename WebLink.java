package searchengine;

/**
 * Builds a WebLink item
 * @author Nhien (Ricky) Lam 
 *
 */
public class WebLink implements Comparable {
	private String url;
	private int priority;
	
	/**
	 * Constructs a WebLink item with url and priority
	 * @param url
	 * @param priority
	 */
	public WebLink(String url, int priority) 
	{
		this.url = url;
		this.priority = priority;
	}
	
	/**
	 * Gets the url
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}
	
	/**
	 * Gets the priority
	 * @return the priority
	 */
	public int getPriority()
	{
		return priority;
	}
	
	/**
	 * Checks if 2 WebLink items have the same priority and description
	 * @return true if 2 items have the same priority and description, false otherwise
	 */
	public boolean equals(Object otherObject)
	{
		if (otherObject == null)
		{
			return false;
		}
		if (this.getClass() != otherObject.getClass()) 
		{
			return false;
		}
		
		WebLink other = (WebLink)otherObject;
		return (this.priority == other.priority && this.url.equals(other.url));
	}
	
	/**
	 * Compares the to-do item by priority and description
	 * @return the difference of the 2 items
	 */
	public int compareTo(Object otherObject)
	{
		WebLink other = (WebLink) otherObject;
		
		if(this.priority != other.priority)
		{
			return Double.compare(this.priority, other.priority);
		}
		else
		{
			return this.url.compareTo(other.url);
		}
	}
}