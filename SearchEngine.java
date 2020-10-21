package searchengine;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Builds a micro version  Google Search Engine Simulator
 * @author Nhien (Ricky) Lam 
 *
 */
public class SearchEngine {

	private WebCrawler wCrawler; 

	private PageRank pRank; 
	
	 // A list of websites with PageRank scores that user assigns
	private ArrayList<WebLink> userAssignedWebList; 
	
	 // A list of websites with PageRank scores are assigned by the random number generator
	private ArrayList<WebLink> randomAssignedWebList;

	
	
	/**
	 * Assigns PageRank scores to the website
	 * @param url The URL of the website
	 * @param frequency The PageRank frequency score
	 * @param age The PageRank age score
	 * @param numOfLinks The PageRank numOfLinks score
	 * @param money The PageRank money score
	 * @return a new WebLink with the website's URL and the PageRank scores
	 */
	public WebLink rankedWeb(String url, int frequency, int age, int numOfLinks, int money)
	{
		PageRank pr = new PageRank(frequency, age, numOfLinks, money);
		return new WebLink(url, pr);		
	}
	
	/**
	 * Starts the SearchEngine tasks
	 */
	public void runSearchEngine()
	{
		// get input from user
		Scanner in = new Scanner(System.in);

		// valid input options
		String validInput = "s";
		
		// when to stop the program
		boolean quit = false;
		
		System.out.println("**************************");
		System.out.println("Search Engine Simulator");
		System.out.println("**************************");

		/// gets a keyword from user
		System.out.println("Please enter a keyword you want to search?");
		String keyword = in.nextLine();
		System.out.println("keyword = "+ keyword);
		wCrawler = new WebCrawler(keyword);
		wCrawler.search();

		// lets user choose which tasks to perform
		while(!quit)
		{
			System.out.println("\n****************************************************");
			System.out.print("What do you want to perform: "  
					+ "\n" + "Enter 'D' --- Display search results"
					+ "\n" + "Enter 'A' --- Assign 4 scores for a specific website"
					+ "\n" + "Enter 'R' --- Assign scores for ALL the websites using a random number generator"
					+ "\n" + "Enter 'Q' --- Quit"
					+ "\n" + "Enter you option: "
					);
			
			char inputOption = in.next().toUpperCase().charAt(0);
			
			switch(inputOption)
			{	
				case 'D':
					System.out.println(" \nHere are the first 30 URL links: \n");
					int count = 0;
					for(String s : wCrawler.getUrls())
					{
						System.out.println(count);
						if(count >= 30)  // only print the first 30 links
						{
							break;
						}
						System.out.println(s);
						count++;
					}
					break;
				
				// still not completed
				case 'A' :
					// Get input from user
					System.out.println("Enter a website URL you want to score:   ");
					String url = in.nextLine();
					System.out.print("Enter a score for Frequency (1-100):  ");
					int frequency = in.nextInt();
					System.out.print("Enter a score for Age (1-100):  ");
					int age = in.nextInt();
					System.out.print("Enter a score for Number of other web pages link to the page (1-100):  ");
					int numOfLinks = in.nextInt();
					System.out.print("Enter a score for Money (1-100):  ");
					int money = in.nextInt();
					
					// Add a WebLink contains the URL and the PageRank scores too webList
					userAssignedWebList.add(rankedWeb(url,frequency, age, numOfLinks, money));
	                break;
	                
				case 'R' :
					
				
				case 'Q' :
					System.out.println("Thank you! See you again!");
	                quit = true;
	                break;
				
				default:
	                System.out.println("Invalid input! Please try again");
	                break;
			}
			System.out.println("**************************************************** \n" );
		}
	}
}
