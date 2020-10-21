package searchengine;

/**
 * Builds a WebLink item
 * @author Nhien (Ricky) Lam 
 *
 */
public class WebLink implements Comparable {
	private String url;
	private PageRank pRank;
	
	/**
	 * Constructs a WebLink item with url and rank
	 * @param url the URL of the website
	 * @param pRank the PageRank score of the website
	 */
	public WebLink(String url, PageRank pRank) 
	{
		this.url = url;
		this.pRank = pRank;
	}
	
	/**
	 * Gets the url of the website
	 * @return the url
	 */
	public String getUrl()
	{
		return url;
	}
	
	/**
	 * Gets the rank of the website
	 * @return the rank
	 */
	public PageRank getRank()
	{
		return pRank;
	}
	
	/**
	 * Return a PageRank's Frequency score of the website
	 * @return PageRank's Frequency score
	 */
	public int getFrequency()
	{
		return pRank.frequency;
	}
	
	/**
	 * Return a PageRank's Age score of the website
	 * @return PageRank's Age score
	 */
	public int getAge()
	{
		return pRank.age;
	}
	
	/**
	 * Return a PageRank's Number of other web pages that link to the page score of the website
	 * @return PageRank's Number of other web pages that link to the page score score
	 */
	public int getOtherWebLinks()
	{
		return pRank.otherWebLinks;
	}
	
	/**
	 * Return a PageRank's Money score of the website
	 * @return PageRank's Money score
	 */
	public int getMoney()
	{
		return pRank.money;
	}
	
	/**
	 * Return a PageRank's Total score of the website
	 * @return PageRank's Total score
	 */
	public int getTotal()
	{
		return pRank.getTotalScore();
	}
	
	/**
	 * @Override
	 * Checks if 2 WebLink items have the same the total PageRank score
	 * @return true if 2 items have the same same the total PageRank score, false otherwise
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
		return (this.pRank.getTotalScore() == other.pRank.getTotalScore());
	}
	
	/**
	 * @Override
	 * Compares the to-do item by the total PageRank score
	 * @return the difference of the 2 items
	 */
	public int compareTo(Object otherObject)
	{
		WebLink other = (WebLink) otherObject;
		return Double.compare(this.pRank.getTotalScore(), other.pRank.getTotalScore());
	}
	
	/**
	 * @Override
	 * Generate the hash code for a WebLink items
	 * @return the hash code 
	 */
	public int hashCode() 
	{
		return url.length() + pRank.getTotalScore();
	}
}
