package searchengine;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Builds a MaxPriority Queue to store web url links based on the PageRank
 * @author Nhien (Ricky) Lam 
 *
 */

public class MaxPriorityQueue {
	private PriorityQueue<WebLink> pq;
	
	public MaxPriorityQueue()
	{
		this.pq = new PriorityQueue<>(20, new Comparator<WebLink>()
		{
		    @Override
		    public int compare(WebLink left, WebLink right) 
		    {
		    	if (left.equals(right))
		    	{
		    		return 0;
		    	}
		    	else if (left.compareTo(right) == -1)
		    	{
		    		return +1;
		    	}
		    	else
		    	{
			    	return -1;
		    	}
		    }
		}
		); 
	}
	/*
	public static void main(String[] args)
	{
		//MaxPriorityQueue a = new MaxPriorityQueue();
		PriorityQueue<String> a = new PriorityQueue<>(20, new Comparator<String>()
		{
		    @Override
		    public int compare(String left, String right) 
		    {
		    	if (left.equals(right))
		    	{
		    		return 0;
		    	}
		    	else if (left.length() <right.length())
		    	{
		    		return +1;
		    	}
		    	else
		    	{
			    	return -1;
		    	}
		    }
		}
		); 
		
		a.add("Red",1);
        a.add("Red",5);
        a.add("Blue",2);
        a.add("Cyan",4);
        a.add("Magenta",10);
        a.add("Yellow",3);
        
        System.out.println("The max Priority Queue contents:");
        Iterator iter1 = a.iterator(); 
        while (iter1.hasNext()) 
            System.out.print(iter1.next() + " "); 
	}
*/
}
